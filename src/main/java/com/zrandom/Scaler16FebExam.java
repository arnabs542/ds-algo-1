package com.zrandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Scaler16FebExam {

    private static int[] findDivisors(int input) {

        List<Integer> div = new ArrayList<>();

        for (int i = 1; i <= input; i++) {
            if (input % i == 0) {
                div.add(i);
            }
        }

        int[] array = div.stream().mapToInt(i -> i).toArray();

        return array;
    }

    public static String solve1(String A) {

        String concated = A.concat(A);
        char c[] = concated.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == Character.toUpperCase(c[i])) {
                c[i] = '-';
            }
        }

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

        for (int i = 0; i < c.length; i++) {
            if (vowels.contains(c[i])) {
                c[i] = '#';
            }
        }

        return new String(c).replace("-", "");
    }

    public static LinkedList.ListNode solve2(LinkedList.ListNode A) {

        List<Integer> p = new ArrayList<>();

        LinkedList.ListNode fastPtr = A;

        while (fastPtr != null && fastPtr.next != null) {
            p.add(fastPtr.val * 10 + fastPtr.next.val);
            fastPtr = fastPtr.next.next;
        }

        Collections.sort(p);

        int u, t;

        LinkedList.ListNode newest = A;

        for (int i = 0; i < p.size(); i++) {
            t = (p.get(i) / 10) % 10;
            u = p.get(i) % 10;

            newest.val = t;
            newest.next.val = u;

            newest = newest.next.next;
        }

        return A;
    }

    public static int[] solve3(int[] A, int[] B) {

        int index = 0;
        int count = 0;

        int[] output = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            int[] divisors = findDivisors(B[i]);

            for (int j = 0; j < divisors.length; j++) {
                if (A[divisors[j] - 1] != 0) {
                    A[divisors[j] - 1]--;
                }
            }
            count = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] == 0) {
                    count++;
                }
            }

            output[index] = count;
            index++;
        }

        return output;
    }

    public static int solve4(int[] arr, int sum) {

        int start = 0;
        int end = arr.length - 1;

        int count = 0;
        while (start <= end) {
            if ((2 * arr[start]) + arr[end] >= sum) {
                int temp = end - start + 1;
                count = count + temp;
                end--;
            } else {
                start++;
            }
        }


//        for (int i = 0; i < arr.length; i++) {
//            if (3 * arr[i] >= sum) {
//                count++;
//            }
//        }

        return count;
    }

    public static void main(String[] args) {

//        LinkedList list = new LinkedList();
//
//        // Insert the values
//        list = list.insert(list, 6);
//        list = list.insert(list, 5);
//        list = list.insert(list, 4);
//        list = list.insert(list, 3);
//        list = list.insert(list, 1);
//        list = list.insert(list, 2);
//        list = list.insert(list, 8);
//        list = list.insert(list, 7);
//
//        list.printList(list);
//
//        solve2(list.head);
//
//        list.printList(list);
//
//
//        int div[] = solve3(new int[]{3, 1, 4, 2}, new int[]{2, 4, 3});

        int[] arr = new int[]{2, 3, 5, 8, 10};
        int count = solve4(arr, 12);
        System.out.println(count);

    }


}
