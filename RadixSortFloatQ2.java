import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RadixSortFloatQ2 {

    // Find the maximum number in the array to determine the number of digits
    private static int getMax(int[] input_arr) {
        int max = input_arr[0];
        for (int i = 1; i < input_arr.length; i++) {
            if (input_arr[i] > max) {
                max = input_arr[i];
            }
        }
        return max;
    }

    // Perform comparison sort for each digit position
    private static void comparisonSort(int[] input_arr, int exp, ArrayList<Integer>[] temp, ArrayList<Integer> bucket) {
        int n = input_arr.length;

        // Clear the temporary arrays
        for (int i = 0; i < 10; i++) {
            temp[i].clear();
        }

        // Place the numbers in the corresponding buckets based on the current digit
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

        // Merge the numbers from the buckets into the bucket list
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < temp[i].size(); j++) {
                bucket.add(temp[i].get(j));
            }
        }

        // Copy the sorted numbers back to the input array
        for (int i = 0; i < n; i++) {
            input_arr[i] = bucket.get(i);
        }

        // Clear the bucket list
        for (int i = 0; i < n; i++) {
            bucket.remove(0);
        }

        System.out.println(Arrays.toString(temp));
    }

    public static void radixSort(float[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int mostSf = 0;

        // Find the number of decimal places with the most significant figures
        for (int i = 0; i < arr.length; i++) {
            String[] parts = Float.toString(arr[i]).split("\\.");
            int decPlaces = parts.length > 1 ? parts[1].length() : 0;
            if (decPlaces > mostSf) {
                mostSf = decPlaces;
            }
        }

        int[] intArray = new int[arr.length];

        // Convert the float array to integer array and adjust the values based on the number of decimal places
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.pow(10, mostSf));
            intArray[i] = Math.round(arr[i]);
        }

        // Find the maximum number in the integer array to determine the number of digits
        int max = getMax(intArray);

        // Create arrays for storing numbers in buckets and a bucket list
        ArrayList<Integer>[] array1 = (ArrayList<Integer>[]) new ArrayList[10];
        ArrayList<Integer>[] array2 = (ArrayList<Integer>[]) new ArrayList[10];
        ArrayList<Integer> bucket = new ArrayList<Integer>(arr.length);

        for (int i = 0; i < 10; i++) {
            array1[i] = new ArrayList<Integer>();
            array2[i] = new ArrayList<Integer>();
        }

       int cnt = 0;
       
           // Perform radix sort for each digit position
    for (int exp = 1; max / exp > 0; exp *= 10) {
        if (cnt % 2 == 0) {
            System.out.println("Using Array 1!");
            comparisonSort(intArray, exp, array1, bucket);
            System.out.println("Array 2: ");
            System.out.print(Arrays.toString(array2));
            System.out.println("");
            System.out.println("");
        } else {
            System.out.println("Using Array 2!");
            comparisonSort(intArray, exp, array2, bucket);
            System.out.println("Array 1: ");
            System.out.print(Arrays.toString(array1));
            System.out.println("");
            System.out.println("");
        }
        cnt++;
    }

    // Convert the sorted integer array back to float array
    int i = 0;
    for (float value : intArray) {
        value = (float) (value / Math.pow(10, mostSf));
        arr[i] = value;
        i++;
    }
}

public static void main(String[] args) {
    float data[];
    String temp;
    int arrSize = 1;
    Scanner myObj = new Scanner(System.in);
    boolean containsOnlyDigits = false;

    // Read and validate the array size from user input
    while (!containsOnlyDigits) {
        containsOnlyDigits = true;
        System.out.println("Enter array size");
        temp = myObj.nextLine();

        // Check if the input contains only digits
        for (int i = 0; i < temp.length(); i++) {
            if (!Character.isDigit(temp.charAt(i))) {
                containsOnlyDigits = false;
                break;
            }
        }

        if (containsOnlyDigits) {
            arrSize = Integer.parseInt(temp);
            System.out.println("Array size is " + arrSize);
        } else {
            System.out.println("Please input a number!");
            System.out.println();
        }
    }

    data = new float[arrSize];

    // Generate random float values for the array
    for (int i = 0; i < arrSize; i++) {
        data[i] = (float) ThreadLocalRandom.current().nextInt(1, 10000000 + 1) / 100;
    }

    // Perform radix sort on the array
    RadixSortFloatQ2.radixSort(data);

    System.out.println("");
    System.out.println("Sorted List: ");
    System.out.print(Arrays.toString(data));
}
}
