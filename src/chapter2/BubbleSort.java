package src.chapter2;

import java.util.Arrays;

public class BubbleSort {
    static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers.length - 1; j > i; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 5, 2, 6, 3, 1, 9, 4, 10, Integer.MAX_VALUE, 100, -100, -20, 0 };
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
