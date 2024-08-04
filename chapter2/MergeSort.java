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

        int[] tmp = new int[n1 + n2];

        int i = p;
        int j = q + 1;
        int k = 0;

        while (i <= q && j <= r) {
            if (numbers[i] < numbers[j]) {
                tmp[k++] = numbers[i++];
            } else {
                tmp[k++] = numbers[j++];
            }
        }

        while (i <= q) {
            tmp[k++] = numbers[i++];
        }

        while (j <= r) {
            tmp[k++] = numbers[j++];
        }

        for (i = p, k = 0; i <= r; i++, k++) {
            numbers[i] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 5, 2, 6, 3, 1, 9, 4, 10, Integer.MAX_VALUE, 100, -100, -20, 0 };
        sort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }
}
