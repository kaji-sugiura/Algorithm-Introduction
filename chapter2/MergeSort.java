package chapter2;

import java.util.Arrays;
import java.util.Random;

/**
 * マージソート
 * 時間計算量O(nlogn)
 * 分割統治法を用いてソートする
 */
public class MergeSort {
    private static final int THRESHOLD_NUMBER = 10;

    public static void mergeSort(int[] numbers, int p, int r) {
        if (p < r) {
            if (r - p < THRESHOLD_NUMBER) {
                insertionSort(numbers, p, r);
            } else {
                int q = p + (r - p) / 2;
                mergeSort(numbers, p, q);
                mergeSort(numbers, q + 1, r);
                merge(numbers, p, q, r);
            }
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

    private static void insertionSort(int[] numbers, int p, int r) {
        for (int i = p + 1; i <= r; i++) {
            int key = numbers[i];
            int j = i - 1;
            while (j >= p && key < numbers[j]) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[100000];
        Random rand = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000);
        }
        mergeSort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }
}
