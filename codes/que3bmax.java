import java.util.Arrays;


public class que3bmax {
    private int[] heap;         
    private int size;           
    private int capacity;       

    
    public que3bmax(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    
    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    private int getLeftChildIndex(int i) {
        return 2 * i + 1;
    }

  
    private int getRightChildIndex(int i) {
        return 2 * i + 2;
    }

    
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

 
    private void siftUp(int i) {
        int parent = getParentIndex(i);
        while (i > 0 && heap[i] > heap[parent]) {
            swap(i, parent);
            i = parent;
            parent = getParentIndex(i);
        }
    }

   
    private void siftDown(int i) {
        int largest = i;
        int left = getLeftChildIndex(i);
        int right = getRightChildIndex(i);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            siftDown(largest);
        }
    }

   
    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Priority Queue is full.");
        }
        heap[size] = value;
        size++;
        siftUp(size - 1);
    }

   
    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Priority Queue is empty.");
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return max;
    }

  
    public int peekMax() {
        if (size == 0) {
            throw new IllegalStateException("Priority Queue is empty.");
        }
        return heap[0];
    }

    
    public int size() {
        return size;
    }

   
    public boolean isEmpty() {
        return size == 0;
    }

    
    public static void main(String[] args) {
        que3bmax pq = new que3bmax(10);
        pq.insert(5);
        pq.insert(3);
        pq.insert(10);
        pq.insert(7);

        System.out.println("Extracted Max: " + pq.extractMax());
        System.out.println("Peek Max: " + pq.peekMax()); 
}
}