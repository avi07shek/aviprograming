import java.util.Arrays;
public class que6a {
    private static final int MAX_THREADS = Runtime.getRuntime().availableProcessors();

    
    public static void parallelMergeSort(int[] arr) {
        parallelMergeSort(arr, 0, arr.length - 1, MAX_THREADS);
    }
   
    private static void parallelMergeSort(int[] arr, int low, int high, int availableThreads) {
        if (low < high) {
            
            if (availableThreads <= 1) {
                mergeSort(arr, low, high);
            } else {
                int mid = (low + high) / 2;

                Thread leftThread = new Thread(() -> parallelMergeSort(arr, low, mid, availableThreads / 2));
                Thread rightThread = new Thread(() -> parallelMergeSort(arr, mid + 1, high, availableThreads / 2));

                
                leftThread.start();
                rightThread.start();

                try {
                    
                    leftThread.join();
                    rightThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                merge(arr, low, mid, high);
            }
        }
    }
   
    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    
    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }

        
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        
        while (right <= high) {
            temp[k++] = arr[right++];
        }
        
        System.arraycopy(temp, 0, arr, low, temp.length);
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 1, 5, 8, 2, 6, 4};
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        parallelMergeSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}

