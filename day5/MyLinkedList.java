import java.util.NoSuchElementException;
import java.util.Objects;


// version 1 ... 다시 작성 예정
class MyLinkedList {
    private static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int x) {
        Node newNode = new Node(x);
        
        if (Objects.isNull(head)) {
            head = newNode;
            if (!Objects.isNull(tail)) {
                head.next = tail;
            }
        } else {
            newNode.next = head;
            head = newNode;
        }

        
        
        size ++;
    }

    public void addLast(int x) {
        Node newNode = new Node(x);

        if (Objects.isNull(tail)) {
            tail = newNode;
            if (Objects.isNull(head)) {
                head = newNode;
            } else {
                Node prevNode = head;
                while (true) {
                    if (prevNode.next == null) {
                        break;
                    }
                    prevNode = prevNode.next;
                }

                prevNode.next = tail;
            }

        } else {
            tail.next = newNode;
            tail = newNode;
        }
        
        size ++;
    }

    public int removeFirst() {
        
        if (Objects.isNull(head)) {
            throw new NoSuchElementException();
        }
        int firstNodeVal = head.val;
        head = head.next;

        size --;

        return firstNodeVal;
    }

    public int removeLast() {

        if (Objects.isNull(tail)) {
            throw new NoSuchElementException();
        }
        int lastNodeVal = tail.val;

        Node prev = head;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            while (true) {
                if (prev.next == tail) {
                    break;
                }
                prev = prev.next;
            }

            tail = prev;
            tail.next = null;
        }
        size --;
        
        return lastNodeVal;
    }

    public int get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int count = 0;
        int val;
        Node temp = head;

        while (true) { 
            if (count == index) {
                val = temp.val;
                break;
            }
            temp = temp.next;
            count ++;
        }

        return val;
    }

    public int size() {
        return size;
    }
}
