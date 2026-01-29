import java.util.NoSuchElementException;

class MyLinkedList {

    private static class Node {

        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int x) {
        Node newNode = new Node(x);

        if (head == null) {

            // IMPROVED
            assert tail == null : "Invariant broken: head==null but tail!=null"; // 불변식 체크

            head = newNode;
//            if (tail == null) {
//                tail = newNode;
//            } else {
            // 이런 상황은 없다고 가정
            // head가 null 이면 tail도 늘 null이어야함
//            }
            // IMPROVED
            tail = newNode;
        } else {
            // head is not null
            newNode.next = head;
            head = newNode;
        }

        size++;

    }

    public void addLast(int x) {
        Node newNode = new Node(x);

        if (tail == null) {
            // IMPROVED
            assert head == null : "Invariant broken: tail==null but head!=null"; // 불변식 체크

            tail = newNode;
//            if (head == null) {
//                head = newNode;
//            } else {
//                // 이런 상황은 없다고 가정
//                // head가 null 이면 tail도 늘 null이어야함
//            }
            // IMPROVED
            head = newNode;
        } else {
            // tail is not null
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public int removeFirst() {
//        if (size == 0 || head == null) {
        // IMPROVED
        if (size == 0) {
            throw new NoSuchElementException();
        }

        int target = head.val;

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return target;
        }

        head = head.next;

        size--;

        return target;
    }

    public int removeLast() {
//       if (size == 0 || tail == null) {
        // IMPROVED
        if (size == 0) {
            throw new NoSuchElementException();
        }

        int target = tail.val;

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return target;
        }
        Node prev = head;
        while (true) {
            // if (prev.next != null && prev.next == tail) {
            // IMPROVED
            if (prev.next == tail) {
                break;
            }
            prev = prev.next;
        }

        tail = prev;
        tail.next = null;
        size--;

        return target;
    }

    public int get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
//        int target = 0;
        // IMPROVED
        int target;
        Node prev = head;
        while (true) {

            if (index == count) {
                target = prev.val;
                break;
            }

            count++;
            prev = prev.next;
        }

        return target;
    }

    public int size() {
        return size;
    }
}
