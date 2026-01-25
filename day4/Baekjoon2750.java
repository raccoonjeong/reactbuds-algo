
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



// 수 정렬하기
// https://www.acmicpc.net/problem/2750
public class Baekjoon2750 {

    // 병합 정렬 이론 읽어보고 내가 구현한 코드
    public static void main(String[] args) throws IOException{
        /*
5
5
2
3
4
1
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];
        for(int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int[] result = divide(arr);

        StringBuilder sb = new StringBuilder();
        for(int i : result) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);

    }

    static int[] divide(int[] arr) {

        if (arr.length <= 1) {
            return arr;
        }

        int pivot = arr.length / 2;

        int[] arr1 = new int[pivot];
        int[] arr2 = new int[arr.length - pivot];

        for (int i = 0; i < arr.length; i++) {
            if (i < pivot) {
                arr1[i] = arr[i];
            } else {
                arr2[i - pivot] = arr[i];
            }
        }

        return conquer(divide(arr1), divide(arr2));

    }

    static int[] conquer(int[] arr1, int[] arr2) {

        int[] conquered = new int[arr1.length + arr2.length];

        int arr1Pointer = 0;
        int arr2Pointer = 0;

        for (int i = 0; i < conquered.length; i++) {
            if (arr1Pointer >= arr1.length) {
                // arr1은 끝났음
                conquered[i] = arr2[arr2Pointer];
                arr2Pointer ++;
                continue;
            }
             if (arr2Pointer >= arr2.length) {
                // arr2는 끝났음
                conquered[i] = arr1[arr1Pointer];
                arr1Pointer ++;
                continue;
            }

            if (arr1[arr1Pointer] < arr2[arr2Pointer]) {
                conquered[i] = arr1[arr1Pointer];
                arr1Pointer ++;
            } else {
                conquered[i] = arr2[arr2Pointer];
                arr2Pointer ++;
            }

       
        }

        return conquered;

    }


    // 아래는 AI가 개선해준 코드
    /*
    1️⃣ 불필요한 배열 생성/복사 제거

    Before

    divide()마다 arr1, arr2 새로 생성

    매 단계마다 전체 복사 발생 → 메모리/시간 낭비

    After

    배열은 arr 1개만 유지

    정렬 범위만 left ~ right 인덱스로 관리

    👉 시간·메모리 효율 대폭 개선

    2️⃣ 보조 배열(temp) 1개만 생성해서 재사용

    temp를 처음에 딱 한 번만 생성

    모든 병합 단계에서 작업용 버퍼로 재사용

    👉 GC 부담 감소, 대용량 입력에서도 안정적

    3️⃣ 병합 결과를 arr에 즉시 반영

    conquer()가 새 배열을 반환하지 않음

    병합 결과를 temp → arr(left~right)로 바로 복사

    👉 정렬 상태가 arr에 누적됨 (결과 책임 명확)

    4️⃣ 배열 역할 분리 명확화

    arr: 입력이자 최종 출력 (정렬 결과의 주인)

    temp: 병합 순간에만 쓰는 임시 작업 공간

    👉 코드 의도가 분명해짐, 설계적으로도 정석

    5️⃣ 안정 정렬(stable sort) 유지
    if (arr[arr1Pointer] <= arr[arr2Pointer])


    같은 값이면 왼쪽 먼저

    👉 병합 정렬의 장점(안정성)까지 챙김
    
    */
    public static void main_ai(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // [개선] 매번 arr1/arr2를 만들지 않고, temp(보조배열) 1개만 만들어 재사용
        int[] result = divide_ai(arr);

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }

    static int[] divide_ai(int[] arr) {
        if (arr.length <= 1) return arr;

        // [개선] 보조배열(temp)을 딱 1번만 생성해서 재귀 전체에서 재사용
        int[] temp = new int[arr.length];

        // [개선] 기존처럼 "배열을 반환"하는 흐름은 유지하되,
        //       내부는 인덱스 범위로만 나눠서 불필요한 배열 생성/복사를 없앰
        divide_ai(arr, 0, arr.length - 1, temp);
        return arr;
    }

    // [개선] arr1/arr2를 만들지 않고, 정렬할 구간(left~right)만 넘겨서 분할
    static void divide_ai(int[] arr, int left, int right, int[] temp) {
        if (left >= right) return;

        int pivot = (left + right) / 2;

        divide_ai(arr, left, pivot, temp);
        divide_ai(arr, pivot + 1, right, temp);

        // [개선] conquer가 새 배열을 반환하지 않고,
        //       temp를 활용해 arr 구간(left~right)을 직접 병합 정렬 결과로 만든다
        conquer_ai(arr, left, pivot, right, temp);
    }

    // [개선] arr1/arr2 대신 "두 구간(left~mid, mid+1~right)"을 병합
    static void conquer_ai(int[] arr, int left, int mid, int right, int[] temp) {

        int arr1Pointer = left;      // [개선] arr1의 시작 인덱스 역할
        int arr2Pointer = mid + 1;   // [개선] arr2의 시작 인덱스 역할
        int tempPointer = left;      // [개선] temp에 채워 넣을 위치(같은 구간에 덮어쓰기 위해 left부터)

        // [개선] 양쪽 구간이 둘 다 남아있는 동안 비교하며 temp에 채움
        while (arr1Pointer <= mid && arr2Pointer <= right) {
            // [개선] 안정성까지 챙기고 싶으면 <= (같은 값이면 왼쪽 먼저)
            if (arr[arr1Pointer] <= arr[arr2Pointer]) {
                temp[tempPointer++] = arr[arr1Pointer++];
            } else {
                temp[tempPointer++] = arr[arr2Pointer++];
            }
        }

        // [개선] 왼쪽 구간이 남았으면 temp에 그대로 복사
        while (arr1Pointer <= mid) {
            temp[tempPointer++] = arr[arr1Pointer++];
        }

        // [개선] 오른쪽 구간이 남았으면 temp에 그대로 복사
        while (arr2Pointer <= right) {
            temp[tempPointer++] = arr[arr2Pointer++];
        }

        // [개선] temp에 합쳐진 결과를 arr의 동일 구간(left~right)에만 되돌려 씀
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
