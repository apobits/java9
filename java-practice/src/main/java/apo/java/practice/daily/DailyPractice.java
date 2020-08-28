package apo.java.practice.daily;


import java.util.Arrays;

public class DailyPractice {

    public static void main(String[] args) {
        var array = new int[]{2, 1, 4, 9, 3, 7, 8};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }


    static void insertionSort(int[] array) {
        var index = -1;
        while (++index < array.length - 1) {
            int tempIndex = index;
            while (tempIndex >= 0 && array[tempIndex + 1] < array[tempIndex]) {
                var temp = array[tempIndex];
                array[tempIndex] = array[tempIndex + 1];
                array[tempIndex + 1] = temp;
                tempIndex--;
            }
        }
    }

}


