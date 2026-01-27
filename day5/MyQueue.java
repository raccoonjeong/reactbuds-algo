import java.util.NoSuchElementException;

class MyQueue {
    private final int[] arr;
    private int front; // 현재 맨 앞 원소 위치
    private int rear;  // 다음에 삽입할 위치
    private int size;

    public MyQueue(int capacity) {
        this.arr = new int[capacity];
        // this.size = capacity;
    }

    public void offer(int x) {
        /*
        1, 1, 1, 1, 1
        f: 1
        r: 5
        s: 5

        r-f == s-1 꽉참?
        4 = 4 
        
        0, 1, 1, 1, 0
        f: 2
        r: 4

        s: 5
        3-1 != 4
        

        1, 1, 0, 1, 1
        f: 4
        r: 2
        

        */
        if (arr.length == size) {
            throw new IllegalStateException();
        }
        arr[rear] = x;
        rear = (rear + 1) % arr.length;
        size ++;
    }

    public int poll() {
        if (this.size < 1) {
            throw new NoSuchElementException();
        }
        int result = arr[front];
        arr[front] = 0;
        front = (front + 1) % arr.length;
        size --;

        return result;
    }

    public int peek() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
