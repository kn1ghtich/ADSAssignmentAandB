package B.B1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] nums = line.split(" ");
            ArrayList<Integer> currentLine = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                currentLine.add(Integer.parseInt(nums[j]));
            }
            lines.add(currentLine);
        }

        int q = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (x > 0 && x <= n && y >0){
                ArrayList<Integer> currentLine = lines.get(x-1);

                if (y <= currentLine.size()){
                    System.out.println(currentLine.get(y));
                } else {
                    System.out.println("ERROR!");
                }
            } else {
                System.out.println("ERROR!");
            }
        }

    }
    /*
    5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5
     */
}
