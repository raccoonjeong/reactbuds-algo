
import java.util.NoSuchElementException;

// 희원 코드
// class MyStack {
//     private final int[] arr;
//     private int top; // 다음에 들어갈 위치(=size)

//     public MyStack(int capacity) {
//         // TODO:  최대 크기 지정
//         this.arr = new int[capacity];
//     }

//     public void push(int x) {
//         // TODO: 스택에 x 추가 (가득 차면 IllegalStateException)
//         if(top == arr.length) {
//             throw new IllegalStateException();
//         }

//         arr[top] = x;

//         top += 1;
//     }

//     public int pop() {
//         // TODO: 맨 위 값 제거 후 반환 (비어있으면 NoSuchElementException)
//         if(top == 0) throw new NoSuchElementException();

//         int v = arr[top - 1];

//         arr[top - 1] = 0;

//         top -= 1;

//         return v;
//     }

//     public int peek() {
//         // TODO: 맨 위 값 반환 (비어있으면 NoSuchElementException)
//         if(top == 0) throw new NoSuchElementException();

//         int v = arr[top - 1];

//         return v;
//     }

//     public boolean isEmpty() {
//         // TODO
//         if(top == 0) return true;

//         return false;
//     }

//     public int size() {
//         // TODO
//         return top;
//     }
// }


// 보경 코드
//
//class MyStack {
//    //정수만 저장하는 MyStack 클래스를 배열로 구현하세요.
//
//    private final int[] arr;
//    private int top; // 다음에 들어갈 위치(=size)
//
//    public MyStack(int capacity) {
//        this.arr = new int[capacity];
//        // {0, 0}
//    }
////    public MyStack(int capacity, int[] arr) {
////        // TODO 생성자 MyStack(int capacity) : 최대 크기 지정
////        // capacity와 arr.length 의 구별에 어려움이 있음 ,논리적,물리적 용량 ?
////
////
////
////    }
//
//    public void push(int x) {
//        // TODO void push(int x) : 스택에 x 추가 (가득 차면 IllegalStateException)
//        // IllegalStateException 가 뭔지부터 찾아봄 ㅠ
//        //top은 인덱스 같은건가 ?
//        if(arr.length == top){
//            throw  new IllegalStateException("IllegalStateException");
//        }
//        arr[top] = x;
//        top++;
//
//    }
//
//    public int pop() {
//        // TODO int pop() : 맨 위 값 제거 후 반환 (비어있으면 NoSuchElementException)
//        //비어있으면이 맨위값이 비어있다는거?
//        if(top == 0){
//            throw new NoSuchElementException("NoSuchElementException");
//        }
//        top--; // 맨위값제거 x, 다음에 들어갈 위치 먼저 제거
//        return arr[top]; // 반환
//
////        return -1; // 이건 왜 존재하는거지ㅏ ?
//    }
//
//    public int peek() {
//        // TODO int peek() : 맨 위 값 반환 (비어있으면 NoSuchElementException)
//        if(top==0){
//            throw new NoSuchElementException("NoSuchElementException");
//        }
//        return arr[top-1];
////        return -1;
//    }
//
//    public boolean isEmpty() {
////        // TODO boolean isEmpty()
////        return false;
//
//        if (top == 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public int size() {
//        // TODO int size()
//        return top;
//    }
//}


// 은지 코드
//class MyStack {
//    private final int[] arr;
//    private int top; // 다음에 들어갈 위치(=size)
//
//    public MyStack(int capacity) {
//        arr = new int[capacity];
//    }
//
//    public void push(int x) {
//        if(top < arr.length) {
//            arr[top] = x;
//            top++;
//        } else {
//            throw new IllegalStateException();
//        }
//
//    }
//
//    public int pop() {
//        if (top == 0) {
//            throw new NoSuchElementException();
//        }
////        if(top<arr.length) {
//        int result = arr[top - 1];
//        arr[top - 1] = 0;
//        top--;
//        return result;
////        } else {
////            System.out.println("NoSuchElementException");
////            throw new NoSuchElementException();
////        }
////        return -1;
//    }
//
//    public int peek() {
//        if (top == 0) {
//            throw new NoSuchElementException();
//        }
////        if(top<arr.length) {
//            System.out.println(Arrays.toString(arr));
//            return arr[top - 1];
////        } else {
////            System.out.println("NoSuchElementException");
////        }
////        return -1;
//    }
//    // 비어 있어야 true임
//    public boolean isEmpty() {
//        if(!(top==0)) {
////            System.out.println(1);
//            return false;
//
//        } else {
////            System.out.println(0);
//            return true;
//
//        }
//    }
//
//    public int size() {
////        System.out.println(top);
////        return -1;
//        return top;
//    }
//
//}

// 내 코드
class MyStack {
   private final int[] arr;
   private int top; // 다음에 들어갈 위치(=size)

   public MyStack(int capacity) {
       this.arr = new int[capacity];
   }

   public void push(int x) {
       if (this.arr.length == top) {
           throw new IllegalStateException();
       }
       top ++;
       this.arr[top - 1] = x;

   }

   public int pop() {
       if (top == 0) {
           throw new NoSuchElementException();
       }
       int result = this.arr[top - 1];
       this.arr[top - 1] = 0;
       top --;
       return result;
   }

   public int peek() {
       if (top == 0) {
           throw new NoSuchElementException();
       }
       return this.arr[top - 1];
   }

   public boolean isEmpty() {
       // TODO
       return top == 0;
   }

   public int size() {
       // TODO
       return top;
   }
}
