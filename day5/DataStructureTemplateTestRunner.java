import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * 사용법: 1) MyStack / MyQueue / MyLinkedList 구현을 너희 코드로 채운다. 2) main 실행
 * <p>
 * - JUnit 없이도 동작 - 값 검증 + 예외(IllegalStateException, NoSuchElementException,
 * IndexOutOfBoundsException) 검증 포함
 */
public class DataStructureTemplateTestRunner {

    public static void main(String[] args) {
        try {
//             testMyStack();
//            testMyQueue();
//            testMyLinkedList();
            testMyLinkedList_Stronger();
            System.out.println("\n✅ ALL TESTS PASSED");
        } catch (AssertionError e) {
            System.out.println("\n❌ TEST FAILED: " + e.getMessage());
            throw e;
        }
    }

    // -----------------------
    // 1) MyStack tests
    // -----------------------
    private static void testMyStack() {
        System.out.println("== MyStack tests ==");

        MyStack s = new MyStack(2);
        assertTrue(s.isEmpty(), "new stack should be empty");
        assertEquals(0, s.size(), "new stack size");

        // empty pop/peek
        assertThrows(NoSuchElementException.class, s::pop, "pop on empty should throw");
        assertThrows(NoSuchElementException.class, s::peek, "peek on empty should throw");

        // push/peek/pop
        s.push(1);
        assertFalse(s.isEmpty(), "after push, stack not empty");
        assertEquals(1, s.size(), "size after push 1");
        assertEquals(1, s.peek(), "peek should be 1");
        assertEquals(1, s.size(), "size unchanged after peek");

        s.push(2);
        assertEquals(2, s.size(), "size after push 2");
        assertEquals(2, s.peek(), "peek should be 2");
        assertEquals(2, s.pop(), "pop should be 2");
        assertEquals(1, s.size(), "size after pop");
        assertEquals(1, s.pop(), "pop should be 1");
        assertTrue(s.isEmpty(), "stack should be empty again");

        // overflow
        s.push(10);
        s.push(20);
        assertThrows(IllegalStateException.class, () -> s.push(30), "push on full should throw");

        System.out.println("✅ MyStack OK");
    }

    // -----------------------
    // 2) MyQueue tests
    // -----------------------
    private static void testMyQueue() {
        System.out.println("== MyQueue tests ==");

        MyQueue q = new MyQueue(3);
        assertTrue(q.isEmpty(), "new queue should be empty");
        assertEquals(0, q.size(), "new queue size");

        // empty poll/peek
        assertThrows(NoSuchElementException.class, q::poll, "poll on empty should throw");
        assertThrows(NoSuchElementException.class, q::peek, "peek on empty should throw");

        // basic flow
        q.offer(1);
        q.offer(2);
        assertEquals(2, q.size(), "size after offers");
        assertEquals(1, q.peek(), "peek should be 1");
        assertEquals(1, q.poll(), "poll should be 1");
        assertEquals(1, q.size(), "size after poll");
        q.offer(3);
        assertEquals(2, q.size(), "size after offer 3");
        assertEquals(2, q.poll(), "poll should be 2");
        assertEquals(3, q.poll(), "poll should be 3");
        assertTrue(q.isEmpty(), "queue should be empty again");

        // circular behavior check (rear wraps)
        q.offer(10);
        q.offer(20);
        q.offer(30);
        assertThrows(IllegalStateException.class, () -> q.offer(40), "offer on full should throw");
        assertEquals(10, q.poll(), "poll should be 10");
        q.offer(40); // should go into wrapped slot
        assertEquals(20, q.poll(), "poll should be 20");
        assertEquals(30, q.poll(), "poll should be 30");
        assertEquals(40, q.poll(), "poll should be 40");
        assertTrue(q.isEmpty(), "queue should be empty at end");

        System.out.println("✅ MyQueue OK");
    }

    // // -----------------------
    // // 3) MyLinkedList tests
    // // -----------------------
    private static void testMyLinkedList() {
        System.out.println("== MyLinkedList tests ==");

        MyLinkedList list = new MyLinkedList();
        assertEquals(0, list.size(), "new list size");

        // remove on empty
        assertThrows(NoSuchElementException.class, list::removeFirst,
            "removeFirst on empty should throw");
        assertThrows(NoSuchElementException.class, list::removeLast,
            "removeLast on empty should throw");

        // addFirst / addLast
        list.addFirst(2); // [2]
        assertEquals(1, list.size(), "size after addFirst");
        assertEquals(2, list.get(0), "get(0)");

        list.addFirst(1); // [1,2]
        list.addLast(3);  // [1,2,3]
        assertEquals(3, list.size(), "size after adds");
        assertEquals(1, list.get(0), "get(0)");
        assertEquals(2, list.get(1), "get(1)");
        assertEquals(3, list.get(2), "get(2)");

        // get out of bounds
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1), "get(-1) should throw");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3), "get(3) should throw");

        // removeFirst
        assertEquals(1, list.removeFirst(), "removeFirst should return 1"); // [2,3]
        assertEquals(2, list.size(), "size after removeFirst");
        assertEquals(2, list.get(0), "get(0) after removeFirst");

        // removeLast
        assertEquals(3, list.removeLast(), "removeLast should return 3"); // [2]
        assertEquals(1, list.size(), "size after removeLast");
        assertEquals(2, list.get(0), "single element check");

        // removeLast on single element should update head/tail properly
        assertEquals(2, list.removeLast(), "removeLast on single should return 2"); // []
        assertEquals(0, list.size(), "size after removing last element");
        assertThrows(NoSuchElementException.class, list::removeFirst,
            "removeFirst on empty again should throw");
        assertThrows(NoSuchElementException.class, list::removeLast,
            "removeLast on empty again should throw");

        // mixed operations
        list.addLast(10); // [10]
        list.addLast(20); // [10,20]
        list.addFirst(5); // [5,10,20]
        assertEquals(3, list.size(), "size after mixed add");
        assertEquals(20, list.removeLast(), "removeLast should return 20"); // [5,10]
        assertEquals(5, list.removeFirst(), "removeFirst should return 5"); // [10]
        assertEquals(10, list.get(0), "remaining element should be 10");

        System.out.println("✅ MyLinkedList OK");
    }

    // -----------------------
    // Minimal assertion helpers
    // -----------------------
    private static void assertEquals(int expected, int actual, String msg) {
        if (expected != actual) {
            throw new AssertionError(msg + " | expected=" + expected + " actual=" + actual);
        }
    }

    private static void assertTrue(boolean cond, String msg) {
        if (!cond) {
            throw new AssertionError(msg + " | expected=true actual=false");
        }
    }

    private static void assertFalse(boolean cond, String msg) {
        if (cond) {
            throw new AssertionError(msg + " | expected=false actual=true");
        }
    }

    @FunctionalInterface
    private interface ThrowingRunnable {

        void run();
    }

    private static void assertThrows(Class<? extends Throwable> expected, ThrowingRunnable r,
        String msg) {
        try {
            r.run();
        } catch (Throwable t) {
            if (expected.isInstance(t)) {
                return;
            }
            throw new AssertionError(msg + " | expected exception=" + expected.getSimpleName()
                + " actual=" + t.getClass().getSimpleName(), t);
        }
        throw new AssertionError(
            msg + " | expected exception=" + expected.getSimpleName() + " but none thrown");
    }


    private static void testMyLinkedList_Stronger() {
        System.out.println("== MyLinkedList stronger tests ==");

        // 1) 기존 테스트 + 누락 케이스(원래 코드에서 터지기 쉬운 흐름들)
        {
            MyLinkedList list = new MyLinkedList();
            assertEquals(0, list.size(), "new list size");
            assertThrows(NoSuchElementException.class, list::removeFirst,
                "removeFirst on empty should throw");
            assertThrows(NoSuchElementException.class, list::removeLast,
                "removeLast on empty should throw");
            assertInvariants(list, "empty invariants");

            // ✅ 원래 코드에서 특히 취약: addFirst로만 채운 뒤 removeLast
            list.addFirst(1); // [1]
            assertEquals(1, list.size(), "size after addFirst(1)");
            assertEquals(1, list.get(0), "get(0) after addFirst(1)");
            assertInvariants(list, "after addFirst(1)");

            assertEquals(1, list.removeLast(), "removeLast should work after addFirst-only"); // []
            assertEquals(0, list.size(), "size back to 0");
            assertInvariants(list, "after removeLast -> empty");

            // ✅ 원래 코드에서 취약: removeFirst가 tail 갱신 누락되는지
            list.addLast(10); // [10]
            assertInvariants(list, "after addLast(10)");
            assertEquals(10, list.removeFirst(), "removeFirst single should return 10"); // []
            assertEquals(0, list.size(), "size after removeFirst single");
            assertInvariants(list, "after removeFirst single -> empty");

            // addLast / addFirst 혼합
            list.addFirst(2); // [2]
            list.addLast(3);  // [2,3]
            list.addFirst(1); // [1,2,3]
            assertEquals(3, list.size(), "size after mixed adds");
            assertEquals(1, list.get(0), "get(0)");
            assertEquals(2, list.get(1), "get(1)");
            assertEquals(3, list.get(2), "get(2)");
            assertInvariants(list, "after mixed adds");

            assertEquals(1, list.removeFirst(), "removeFirst should return 1"); // [2,3]
            assertEquals(3, list.removeLast(), "removeLast should return 3");   // [2]
            assertEquals(2, list.get(0), "remaining should be 2");
            assertEquals(1, list.size(), "size should be 1");
            assertInvariants(list, "after removes to single");

            assertEquals(2, list.removeFirst(), "removeFirst should remove last remaining"); // []
            assertEquals(0, list.size(), "size should be 0");
            assertThrows(NoSuchElementException.class, list::removeLast,
                "removeLast on empty again should throw");
            assertInvariants(list, "end empty again");
        }

        // 2) get(index) 경계/연속 검증
        {
            MyLinkedList list = new MyLinkedList();
            for (int i = 0; i < 20; i++) {
                list.addLast(i); // [0..19]
            }
            assertEquals(20, list.size(), "size after addLast 0..19");
            assertInvariants(list, "after addLast 0..19");

            assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1), "get(-1) throw");
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(20), "get(size) throw");

            for (int i = 0; i < 20; i++) {
                assertEquals(i, list.get(i), "get(" + i + ") should return " + i);
            }

            // removeLast 반복 후 get 검증
            for (int i = 19; i >= 0; i--) {
                assertEquals(i, list.removeLast(), "removeLast returns " + i);
                assertEquals(i, list.size(), "size after removeLast to " + i);
                assertInvariants(list, "after removeLast i=" + i);
                if (i > 0) {
                    assertEquals(0, list.get(0), "head should still be 0");
                }
            }
            assertEquals(0, list.size(), "finally empty");
            assertInvariants(list, "finally empty");
        }

        // 3) "참조 구현"과 랜덤 비교 (LinkedList와 동작 동일해야 함)
        //    - 이게 가장 강력함: 누락된 꼬리 처리/size/연결 깨짐을 거의 다 잡아냄
        {
            MyLinkedList my = new MyLinkedList();
            LinkedList<Integer> ref = new LinkedList<>();
            Random rnd = new Random(7); // 고정 seed로 재현 가능

            for (int step = 0; step < 3000; step++) {
                int op = rnd.nextInt(6);

                if (op == 0) { // addFirst
                    int v = rnd.nextInt(1000) - 500;
                    my.addFirst(v);
                    ref.addFirst(v);
                } else if (op == 1) { // addLast
                    int v = rnd.nextInt(1000) - 500;
                    my.addLast(v);
                    ref.addLast(v);
                } else if (op == 2) { // removeFirst
                    if (ref.isEmpty()) {
                        assertThrows(NoSuchElementException.class, my::removeFirst,
                            "removeFirst on empty (step " + step + ")");
                    } else {
                        int a = my.removeFirst();
                        int b = ref.removeFirst();
                        assertEquals(b, a, "removeFirst value (step " + step + ")");
                    }
                } else if (op == 3) { // removeLast
                    if (ref.isEmpty()) {
                        assertThrows(NoSuchElementException.class, my::removeLast,
                            "removeLast on empty (step " + step + ")");
                    } else {
                        int a = my.removeLast();
                        int b = ref.removeLast();
                        assertEquals(b, a, "removeLast value (step " + step + ")");
                    }
                } else if (op == 4) { // get(index)
                    if (ref.isEmpty()) {
                        assertThrows(IndexOutOfBoundsException.class, () -> my.get(0),
                            "get(0) on empty (step " + step + ")");
                    } else {
                        int idx = rnd.nextInt(ref.size());
                        assertEquals(ref.get(idx), my.get(idx),
                            "get(" + idx + ") (step " + step + ")");
                    }
                } else { // size
                    assertEquals(ref.size(), my.size(), "size compare (step " + step + ")");
                }

                // 매 스텝마다 불변식 + size 비교
                assertEquals(ref.size(), my.size(), "size must match ref (step " + step + ")");
                assertInvariants(my, "invariants (step " + step + ")");

                // 가끔 전체 내용도 확인(비용 줄이려고 가끔만)
                if (step % 200 == 0) {
                    for (int i = 0; i < ref.size(); i++) {
                        assertEquals(ref.get(i), my.get(i),
                            "full scan get(" + i + ") at step " + step);
                    }
                }
            }
        }

        System.out.println("✅ MyLinkedList stronger tests OK");
    }

    /**
     * ✅ 강화 포인트: - private 필드(head/tail/size)까지 reflection으로 점검해서 "테스트는 통과하지만 내부 구조가 깨진 구현"을 잡아냄
     */
    private static void assertInvariants(MyLinkedList list, String label) {
        try {
            Object head = getField(list, "head");
            Object tail = getField(list, "tail");
            int size = (int) getField(list, "size");

            // 빈 리스트 불변식: head/tail 모두 null, size 0
            if (size == 0) {
                assertTrue(head == null, label + " - size=0 => head must be null");
                assertTrue(tail == null, label + " - size=0 => tail must be null");
                return;
            }

            // 비어있지 않으면 head/tail은 null이면 안됨
            assertTrue(head != null, label + " - size>0 => head must not be null");
            assertTrue(tail != null, label + " - size>0 => tail must not be null");

            // tail.next는 반드시 null
            Object tailNext = getNodeField(tail, "next");
            assertTrue(tailNext == null, label + " - tail.next must be null");

            // head부터 size개 정확히 순회 가능해야 함 + tail이 마지막 노드여야 함
            Object cur = head;
            Object last = null;
            int cnt = 0;

            while (true) {
                if (cur == null) {
                    break;
                }
                last = cur;
                cnt++;
                if (cnt > size) {
                    break; // cycle/size 불일치 방지
                }
                cur = getNodeField(cur, "next");
            }

            assertEquals(size, cnt, label + " - traversal count must match size");
            assertTrue(last == tail, label + " - tail must point to last node");

        } catch (Exception e) {
            throw new AssertionError("Reflection invariant check failed: " + label + " / " + e, e);
        }
    }

    private static Object getField(Object target, String fieldName) throws Exception {
        Field f = target.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        return f.get(target);
    }

    private static Object getNodeField(Object node, String fieldName) throws Exception {
        Field f = node.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        return f.get(node);
    }

}
