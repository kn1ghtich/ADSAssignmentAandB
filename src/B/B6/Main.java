package B.B6;

public class Main {
    public static void heapify(int[] arr, int n, int i, boolean isMaxHeap) {
        int largestOrSmallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        //if left child is larger or smaller than root
        if (left < n && (isMaxHeap ? arr[left] > arr[largestOrSmallest] : arr[left] < arr[largestOrSmallest])) {
            largestOrSmallest = left;
        }

        if (left < n && (isMaxHeap ? arr[right] > arr[largestOrSmallest] : arr[right] < arr[largestOrSmallest])) {
            largestOrSmallest = right;
        }

        if (largestOrSmallest != i) {
            int temp = arr[i];
            arr[i] = arr[largestOrSmallest];
            arr[largestOrSmallest] = temp;
            heapify(arr, n, largestOrSmallest, isMaxHeap);
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,12,45,31,43};
        int n = arr.length;

        boolean isMaxHeap = true;
        for (int i = n/2-1; i >= 0; i--) {
            heapify(arr, n, i, isMaxHeap);
        }

        System.out.println("Max Heap:");
        printArray(arr);

        isMaxHeap = false;
        for (int i = n/2-1; i >= 0; i--) {
            heapify(arr, n, i, isMaxHeap);
        }
        System.out.println("Min Heap:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
