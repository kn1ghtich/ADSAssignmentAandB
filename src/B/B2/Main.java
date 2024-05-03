package B.B2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        List<Integer> L = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            L.add(scanner.nextInt());
        }

        int Q = scanner.nextInt();

        for (int i = 0; i < Q; i++) {
            String queryType = scanner.next();
            if (queryType.equals("Insert")) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                L.add(x, y);
            } else if (queryType.equals("Delete")) {
                int x = scanner.nextInt();
                L.remove(x);
            }
        }

        for (int num : L) {
            System.out.print(num + " ");
        }

        scanner.close();


    }
}