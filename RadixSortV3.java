import java.util.ArrayList;
import java.util.Arrays;

public class RadixSortV3 {

    private static int getMax(int[] input_arr) {
        // Find maximum number to know number of digits
        int max = input_arr[0];
        for (int i = 1; i < input_arr.length; i++) {
            if (input_arr[i] > max) {
                max = input_arr[i];
            }
        }

        return max;
    }

    private static void comparisonSort(int[] input_arr, int exp, ArrayList<Integer>[] temp, ArrayList<Integer> bucket) {

        int n = input_arr.length;
        
        for (int i = 0; i < 10; i++) {
            temp[i].clear();
        }

        // System.out.println("Current Temp Array:");
        // System.out.println(Arrays.toString(temp));

        // Initialize identify array

        // int[] identify = new int[10];
        // for (int i = 0; i < 10; i++) {
        // identify[i] = i;
        // }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < n; j++) {
                int exact_num = (input_arr[j] / exp) % 10;
                if (exact_num == i) {
                    temp[i].add(input_arr[j]);
                } else {
                    continue;
                }
            }
        }

        // System.out.println(output);
        // System.out.println(arr);

        // Copy the output array to arr[], so that arr[] now contains sorted numbers
        // according to current digit

        for (int i = 0; i < 10; i++) {
            for(int j = 0; j < temp[i].size(); j++){
                bucket.add(temp[i].get(j));
            }
        }
        //System.out.println(bucket);

        for (int i = 0; i < n; i++) {
            input_arr[i] = bucket.get(i);
        }

        for (int i = 0; i < n; i++) {
            bucket.remove(0);
        }

        // return input_arr;

        System.out.println(Arrays.toString(temp));
        //System.out.println(bucket);
        // System.out.println(output);
    }

    public static void radixSort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }

        // Find maximum number to know number of digits
        int max = getMax(arr);

        ArrayList<Integer>[] array1 = (ArrayList<Integer>[]) new ArrayList[10];
        ArrayList<Integer>[] array2 = (ArrayList<Integer>[]) new ArrayList[10];

        ArrayList<Integer> bucket = new ArrayList<Integer>(arr.length);

        for (int i = 0; i < 10; i++) {
            array1[i] = new ArrayList<Integer>();
            array2[i] = new ArrayList<Integer>();
        }

        int cnt = 0;
        
        for (int exp = 1; max / exp > 0; exp *= 10) {
            if (cnt % 2 == 0) {
                System.out.println("Using Array 1!");
                comparisonSort(arr, exp, array1, bucket);
                System.out.println("Array 2: ");
                System.out.print(Arrays.toString(array2));
                System.out.println("");
                System.out.println("");
            } else {
                System.out.println("Using Array 2!");
                comparisonSort(arr, exp, array2, bucket);
                System.out.println("Array 1: ");
                System.out.print(Arrays.toString(array1));
                System.out.println("");
                System.out.println("");
            }

            cnt++;
            //System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {

        int[] data = {275,87,426,61,409,170,677,503};

        RadixSortV3.radixSort(data);

        System.out.println("");
        System.out.println("Sorted List: ");
        System.out.print(Arrays.toString(data));
    }
}
