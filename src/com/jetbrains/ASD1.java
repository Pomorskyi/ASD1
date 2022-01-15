import java.io.File;
import java.util.Scanner;

class ASD1 {

    public static void main(String[] args) {
        File f = new File(args[0]);
        Scanner scanner = null;

        try {
            scanner = new Scanner(f);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long curSum = 0;
        long curCount = 0;
        long maxSum = 0;
        long maxCount = 0;
        long curEl = 452346;
        long prevEl;
        long sumOfSame = 0;
        long countOfSame = 0;
        boolean isGoingUp = false;
        boolean isGoingUpLast = false;
        int index = 0;

        while (scanner.hasNextLong()) {
            isGoingUpLast = isGoingUp;
            prevEl = curEl;
            curEl = scanner.nextLong();

            if (curEl == prevEl) {
                countOfSame++;
                sumOfSame += curEl;

                curSum += curEl;
                curCount++;
                continue;
            } else {
                if (curEl > prevEl) {
                    isGoingUp = true;
                }
                if (curEl < prevEl) {
                    isGoingUp = false;
                }

                countOfSame = 1;
                sumOfSame = curEl;
            }
            if (index++ > 1) {
                if (isGoingUp) {
                    if (isGoingUpLast) {
                        if (curCount > maxCount) {
                            maxCount = curCount;
                            maxSum = curSum;
                        }
                        curCount++;
                        curSum += curEl;
                    } else {
                        curCount = 2;
                        curSum = prevEl + curEl;
                    }
                } else {
                    if (isGoingUpLast) {
                        if (curCount > maxCount) {
                            maxCount = curCount;
                            maxSum = curSum;
                        }
                        curCount = 2;
                        curSum = prevEl + curEl;
                    } else {
                        curCount++;
                        curSum += curEl;
                    }
                }
            } else {
                curCount++;
                curSum += curEl;
            }
        }
        if (curCount > maxCount) {
            maxCount = curCount;
            maxSum = curSum;
        }

        System.out.println(maxCount + " " + maxSum);

    }
}
