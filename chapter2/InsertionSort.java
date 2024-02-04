package chapter2;

import java.util.Arrays;

/**
 * 挿入ソート
 * ソート済みの配列の正しい位置へkeyを挿入していく
 * 小さな要素に対して効率よくソートを行う
 */
public class InsertionSort {
    public static void sort(int[] numbers) {
        for (int j = 1; j < numbers.length; j++) {
            int key = numbers[j];
            int i = j - 1;
            while (i >= 0 && numbers[i] > key) {
                numbers[i + 1] = numbers[i];
                i--;
            }
            numbers[i + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 4, 2, 1, 5, 6 };
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
