import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RadixSortFloatCounter {

    public static void radixSort(float[] arr) {

        long startTime = System.currentTimeMillis();

        int counter = 0;

        if (arr == null || arr.length == 0) {
            counter += 2; //arr == null and arr.length == 0 comparison
            counter += 1; //return value
            return;
        }

        int mostSf = 0; 
        counter += 1; //assignment for mostSf

        // Find the number of decimal places with the most significant figures
        for (int i = 0; i < arr.length; i++) {
            counter += 1; // i < arr.length comparison
            String[] parts = Float.toString(arr[i]).split("\\.");
            counter += 3; //assignment for parts and calling Float.toString(), split() methods
            int decPlaces = parts.length > 1 ? parts[1].length() : 0;
            counter += 3; //assignment for decPlaces and parts.length > 1 comparison and array access
            if (decPlaces > mostSf) {
                mostSf = decPlaces;
                counter += 2; //mostSf assignment and decPlaces > mostSf comparison
            }
            counter += 2; //increment and assignment for i
        }
        counter += 1; //last i < arr.length comparison

        int[] intArray = new int[arr.length];
        counter += 2; //intArray assignment and array access

        // Convert the float array to integer array and adjust the values based on the number of decimal places
        for (int i = 0; i < arr.length; i++) {
            counter += 1; // i < arr.length comparison
            arr[i] = (float) (arr[i] * Math.pow(10, mostSf));
            counter += 3; // array access, multiplying and arr[i] assignment
            intArray[i] = Math.round(arr[i]);
            counter += 3; // array access, round() method and intArray[i] assignment
            counter += 2; //increment and assignment for i
        }
        counter += 1; //last i < arr.length comparison

        // Find the maximum number in the integer array to determine the number of digits
        int max = intArray[0];
        counter += 2; //array access and max assignment
        for (int i = 1; i < intArray.length; i++) {
            counter += 1; // i < intArray.length comparison
            if (intArray[i] > max) {
                counter += 2; //intArray[i] > max comparison and array access
                max = intArray[i];
                counter += 2; //array access and max assignment
            }
            counter += 2; //increment and assignment for i
        }
        counter += 1; //last i < intArray.length comparison

        // Create arrays for storing numbers in buckets and a bucket list
        ArrayList<Integer>[] array1 = (ArrayList<Integer>[]) new ArrayList[10];
        counter += 1; //array1 assignment
        ArrayList<Integer>[] array2 = (ArrayList<Integer>[]) new ArrayList[10];
        counter += 1; //array2 assignment
        ArrayList<Integer> bucket = new ArrayList<Integer>(arr.length);
        counter += 1; //bucket assignment

        for (int i = 0; i < 10; i++) {
            counter += 1; // i < 10 comparison
            array1[i] = new ArrayList<Integer>();
            counter += 2; //array access and array1[i] assignment
            array2[i] = new ArrayList<Integer>();
            counter += 2; //array access and array2[i] assignment
            counter += 2; //increment and assignment for i
        }
        counter += 1; //last i < 10 comparison

       int cnt = 0;
       counter += 1; //cnt assignment
       
           // Perform radix sort for each digit position
    for (int exp = 1; max / exp > 0; exp *= 10) {
        counter += 2; // divide operation and max / exp > 0 comparison
        if (cnt % 2 == 0) {
            counter += 2; //% operation and cnt % 2 == 0 comparison
            System.out.println("Using Array 1!");
            //comparisonSort(intArray, exp, array1, bucket);
            int n = intArray.length;
            counter += 1; //n assignment

            // Clear the temporary arrays
            for (int i = 0; i < 10; i++) {
                counter += 1; // i < 10 comparison
                array1[i].clear();
                counter += 2; //array access and clear() method
                counter += 2; //increment and assignment for i
            }
            counter += 1; //last i < 10 comparison

            // Place the numbers in the corresponding buckets based on the current digit
            for (int i = 0; i < 10; i++) {
                counter += 1; // i < 10 comparison
                for (int j = 0; j < n; j++) {
                    counter += 1; // j < n comparison
                    int exact_num = (intArray[j] / exp) % 10;
                    counter += 4; // array access, / operation, % operation and exact_num assignment
                    if (exact_num == i) {
                        counter += 1; // exact_num == i comparison
                        array1[i].add(intArray[j]);
                        counter += 3; // array[i] and intArray[j] array access and add() method
                    } else {
                        counter += 1; // exact_num == i comparison
                        continue;
                    }
                    counter += 2; //increment and assignment for j
                }
                counter += 1; // last j < n comparison
                counter += 2; //increment and assignment for i
            }
            counter += 1; //last i < 10 comparison

            // Merge the numbers from the buckets into the bucket list
            for (int i = 0; i < 10; i++) {
                counter += 1; // i < 10 comparison
                for (int j = 0; j < array1[i].size(); j++) {
                    counter += 3; // array1[i] access, size() method and j < array1[i].size() comparison
                    bucket.add(array1[i].get(j));
                    counter += 3; //array1[i] access, get() method and add() method
                    counter += 2; //increment and assignment for j
                }
                counter += 3; // last array1[i] access, size() method and j < array1[i].size() comparison
                counter += 2; //increment and assignment for i
            }
            counter += 1; //last i < 10 comparison

            // Copy the sorted numbers back to the input array
            for (int i = 0; i < n; i++) {
                counter += 1; // i < n comparison
                intArray[i] = bucket.get(i);
                counter += 3; //intArray[i] access and get() method and intArray[i] assignment
                counter += 2; //increment and assignment for i
            }
            counter += 1; // last i < n comparison

            // Clear the bucket list
            for (int i = 0; i < n; i++) {
                counter += 1; // i < n comparison
                bucket.remove(0);
                counter += 1; // remove() method
                counter += 2; //increment and assignment for i
            }
            counter += 1; // last i < n comparison

            System.out.println(Arrays.toString(array1));
            System.out.println("Array 2: ");
            System.out.print(Arrays.toString(array2));
            System.out.println("");
            System.out.println("");

        } else {
            counter += 2; // % operation and cnt % 2 == 0 comparison
            System.out.println("Using Array 2!");
            //comparisonSort(intArray, exp, array2, bucket);
            int n = intArray.length;
            counter += 1; //n assignment

            // Clear the temporary arrays
            for (int i = 0; i < 10; i++) {
                counter += 1; // i < 10 comparison
                array2[i].clear();
                counter += 2; //array access and clear() method
                counter += 2; //increment and assignment for i
            }
            counter += 1; //last i < 10 comparison

            // Place the numbers in the corresponding buckets based on the current digit
            for (int i = 0; i < 10; i++) {
                counter += 1; // i < 10 comparison
                for (int j = 0; j < n; j++) {
                    counter += 1; // j < n comparison
                    int exact_num = (intArray[j] / exp) % 10;
                    counter += 4; // array access, / operation, % operation and exact_num assignment
                    if (exact_num == i) {
                        counter += 1; // exact_num == i comparison
                        array2[i].add(intArray[j]);
                        counter += 3; // array2[i] and intArray[j] array access and add() method
                    } else {
                        counter += 1; // exact_num == i comparison
                        continue;
                    }
                    counter += 2; //increment and assignment for j
                }
                counter += 1; // last j < n comparison
                counter += 2; //increment and assignment for i
            }
            counter += 1; //last i < 10 comparison

            // Merge the numbers from the buckets into the bucket list
            for (int i = 0; i < 10; i++) {
                counter += 1; // i < 10 comparison
                for (int j = 0; j < array2[i].size(); j++) {
                    counter += 3; // array2[i] access, size() method and j < array2[i].size() comparison
                    bucket.add(array2[i].get(j));
                    counter += 3; //array2[i] access, get() method and add() method
                    counter += 2; //increment and assignment for j
                }
                counter += 3; // last array2[i] access, size() method and j < array2[i].size() comparison
                counter += 2; //increment and assignment for i
            }
            counter += 1; //last i < 10 comparison

            // Copy the sorted numbers back to the input array
            for (int i = 0; i < n; i++) {
                counter += 1; // i < n comparison
                intArray[i] = bucket.get(i);
                counter += 3; //intArray[i] access and get() method and intArray[i] assignment
                counter += 2; //increment and assignment for i
            }
            counter += 1; // last i < n comparison

            // Clear the bucket list
            for (int i = 0; i < n; i++) {
                counter += 1; // i < n comparison
                bucket.remove(0);
                counter += 1; // remove() method
                counter += 2; //increment and assignment for i
            }
            counter += 1; // last i < n comparison

            System.out.println(Arrays.toString(array2));

            System.out.println("Array 1: ");
            System.out.print(Arrays.toString(array1));
            System.out.println("");
            System.out.println("");
        }
        cnt++;
        counter += 2; //increment and assignment for i
    }
    counter += 2; // divide operation and last max / exp > 0 comparison

    // Convert the sorted integer array back to float array
    int i = 0;
    counter += 1; //assignment for i
    for (float value : intArray) {
        counter += 1; // intArray iteration
        value = (float) (value / Math.pow(10, mostSf));
        counter += 3; // Math.pow(), / operation and value assignment
        arr[i] = value;
        counter += 2; //array access and assignment
        i++;
        counter += 2; //increment and assignment for i
    }
    counter += 1; // last intArray iteration

    long endTime = System.currentTimeMillis();
    long elapsed = endTime - startTime;
    System.out.print("Running Time: ");
    System.out.print(elapsed);
    System.out.println("");

    System.out.print("Counter: ");
        System.out.print(counter);
        System.out.println("");

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
        System.out.println("Enter array size:");
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
    RadixSortFloatCounter.radixSort(data);

    System.out.println("");
    System.out.println("Sorted List: ");
    System.out.print(Arrays.toString(data));

}
}
