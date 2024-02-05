package chapter2;

import java.util.Arrays;

/**
 * マージソート
 * 時間計算量O(nlogn)
 * 分割統治法を用いてソートする
 */
public class MergeSort {
    public static void sort(int[] numbers, int p, int r) {
        if (p < r) {
            int q = p + (r - p) / 2;
            sort(numbers, p, q);
            sort(numbers, q + 1, r);
            merge(numbers, p, q, r);
        }
    }

    private static void merge(int[] numbers, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = numbers[i + p];
        }

        for (int j = 0; j < n2; j++) {
            right[j] = numbers[q + 1 + j];
        }

        int i = 0, j = 0;
        int k = p;

        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
                numbers[k++] = left[i++];
            } else {
                numbers[k++] = right[j++];
            }
        }

        while (i < n1) {
            numbers[k++] = left[i++];
        }

        while (j < n2) {
            numbers[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 5, 2, 6, 3, 1, 9, 4, 10, Integer.MAX_VALUE, 100, -100, -20, 0 };
        sort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }
}
