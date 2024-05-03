package B.B3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] left = new int[N];
        int[] right = new int[N];
        int leftIndex = 0, rightIndex = 0;

        for (int i = 0; i < N; i++) {
            int operation = scanner.nextInt();
            if (operation == 1) {
                int diskNumber = scanner.nextInt();
                left[leftIndex++] = diskNumber;
            } else if (operation == 2) {
                int diskNumber = scanner.nextInt();
                right[rightIndex++] = diskNumber;
            } else if (operation == 3) {
                System.out.print(left[--leftIndex] + " ");
            } else if (operation == 4) {
                System.out.print(right[--rightIndex] + " ");
            }
        }

        System.out.println(); // to next scenario

        N = scanner.nextInt();
        left = new int[N];
        right = new int[N];
        leftIndex = 0;
        rightIndex = 0;

        for (int i = 0; i < N; i++) {
            int operation = scanner.nextInt();
            if (operation == 1) {
                int diskNumber = scanner.nextInt();
                left[leftIndex++] = diskNumber;
            } else if (operation == 2) {
                int diskNumber = scanner.nextInt();
                right[rightIndex++] = diskNumber;
            } else if (operation == 3) {
                System.out.print(left[--leftIndex] + " ");
            } else if (operation == 4) {
                System.out.print(right[--rightIndex] + " ");
            }
        }

        scanner.close();

    }
}
