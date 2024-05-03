package B.B5;

public class Main {
    public static int countUnableToEat(int[] students, int[] samsas) {
        int unabletoEat = 0;
        int n = students.length;
        int m = samsas.length;

        while (n > 0) {
            if (students[0] == samsas[0]) {

                for (int i = 0; i < n - 1; i++) {
                    students[i] = students[i + 1];
                }
                for (int i = 0; i < m - 1; i++) {
                    samsas[i] = samsas[i + 1];
                }
                n--;
                m--;
                unabletoEat = 0;
            } else {
                int temp = students[0];

                for (int i = 0; i < n - 1; i++) {
                    students[i] = students[i + 1];
                }
                students[n - 1] = temp;
                unabletoEat++;
                if (unabletoEat == n) {
                    return unabletoEat;
                }

            }
        }
        return unabletoEat;
    }

    public static void main(String[] args) {
        int[] students1 = {1,1,0,0};
        int[] samsas1 = {0,1,0,1};
        System.out.println(countUnableToEat(students1, samsas1));

        int[] students2 = {1,1,1,0,0,1};
        int[] samsas2 = {1,0,0,0,1,1};
        System.out.println(countUnableToEat(students2, samsas2));
    }
}
