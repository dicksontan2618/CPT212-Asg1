//package CPT212_Asg1;

// import ArrayList and Arrays
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RadixSortCounter {

    // call function
    public static void radixSort(int[] arr) {
        
        long startTime = System.currentTimeMillis();

        int counter = 0;
        
        // check if input array is empty
        if (arr == null || arr.length == 0) {
            counter += 2; //arr == null and arr.length == 0 comparison
            counter += 1; //return value
            return;
        }
        
        // call "getMax" to get maximum number to obtain the largest digit/significant number in input array
        int max = arr[0];
        counter += 2; // max assignment and array access
        for (int i = 1; i < arr.length; i++) {
            counter += 1; //i < input_arr.length comparison
            if (arr[i] > max) {
                max = arr[i];
                counter += 2; //max assignment and array access
                counter += 2; //input_arr[i] > max comparison and array access
            }
            counter += 2; //increment and assignment for i
        }
        counter += 1; //last i < input_arr.length comparison
        

        // declare "array1" and "array2" for sorting purposes
        // both arrays are array of ArrayList<Integer>
        ArrayList<Integer>[] array1 = (ArrayList<Integer>[]) new ArrayList[10];
        counter += 1; //array1 assignment
        ArrayList<Integer>[] array2 = (ArrayList<Integer>[]) new ArrayList[10];
        counter += 1; //array2 assignment

        // delare "store" array that serves as a temporary storage that used to store the result of converting array of ArrayList into ArrayList<Integer>
        ArrayList<Integer> store = new ArrayList<Integer>(arr.length);
        counter += 1; //store assignment

        // fill each element of "array1" and "array2" with empty ArrayList<Integer>
        for (int i = 0; i < 10; i++) {
            counter += 1; //i < 10 comparison
            array1[i] = new ArrayList<Integer>();
            counter += 2; //array access and assignment for array1[i]
            array2[i] = new ArrayList<Integer>();
            counter += 2; //array access and assignment for array2[i]
        }
        counter += 1; //last i < 10 comparison

        // "count" is used to determine which array (array1/array2) is being used at that particular significant number
        int count = 0;
        counter += 1; //assignment for count
        // for loop to increase the decimal place/significant number for each iteration 
        for (int place = 1; max / place > 0; place *= 10) {
            counter += 2; //max / place > 0 comparison and / arithmetic                 operation
            if (count % 2 == 0) {
                System.out.println("Using Array 1!");
                // get input array length
                //sortNumber function for array1
        int n = arr.length;
        counter += 1; //assignment for n
        
        // "results" is array of ArrayList that contains the sorted data
        // to clear previous "results" array so that no overlapping of data occurs
        for (int i = 0; i < 10; i++) {
            counter += 1; //i < 10 comparison
            array1[i].clear();
            counter += 2; //array access and calling clear method
            counter += 2; //increment and assignment for i
        }
        counter += 1; //last i < 10 comparison

        // core logic for the sort algorithm
        // loop from 0-9 (index of the array of ArrayList)
        for (int i = 0; i < 10; i++) {
            // loop through each number in input array
            counter += 1; //i < 10 comparison
            for (int j = 0; j < n; j++) {
                counter += 1; //j < n comparison
                // get the digit of the number's significant place
                int exact_num = (arr[j] / place) % 10;
                counter += 3; //assignment for exact_num and / and % arithmetic operations
                if (exact_num == i) {
                    // add the number into the ArrayList of its respective index in the array of ArrayList
                    array1[i].add(arr[j]);
                    counter += 3; //2 array access and calling add() method
                    counter += 1; //exact_num == i comparison
                } else {
                    continue;
                }
            counter += 2; //increment and assignment for j
            }
        counter += 1; //last j < n comparison
        counter += 2; //increment and assignment for i
        }
        counter += 1; //last i < 10 comparison

        // "store" is a temporary storage that used to store the result of converting array of ArrayList into ArrayList<Integer>
        // converting array of ArrayList into ArrayList<Integer> is to ease the process to convert ArrayList<Integer> to array of integers which is the initial data passed
        for (int i = 0; i < 10; i++) {
            counter += 1; //i < 10 comparison
            for (int j = 0; j < array1[i].size(); j++) {
                counter += 3; //j < result[i].size() comparison and array                access and calling size() method
                store.add(array1[i].get(j));
                counter += 3; //calling size() and get () methods and array              access
                counter += 2; //increment and assignment for j
            }
            counter += 3; //last j < result[i].size() comparison and array               access and calling size() method
        }
        counter += 1; //last i < 10 comparison

        // pass the sorted array back to the input array
        for (int i = 0; i < n; i++) {
            counter += 1; //i < n comparison
            arr[i] = store.get(i);
            counter += 3; //array access and assignment for input_arr[i] and             calling get() method
            counter += 2; //increment and assignment for i
        }
        counter += 1; //last i < n comparison

        // clear the "store" ArrayList for next time use
        for (int i = 0; i < n; i++) {
            counter += 1; //i < n comparison
            store.remove(0);
            counter += 1; //calling remove() method
            counter += 2; //increment and assignment for i
        }
        counter += 1; //last i < n comparison

        System.out.println(Arrays.toString(array1));
        counter += 2; //calling println() and toString() methods
                System.out.println("Array 2: ");
                System.out.print(Arrays.toString(array2));
                System.out.println("");
                System.out.println("");
                counter += 1; // calling toString() methods
                counter += 2; //count % 2 == 0 comparison and % arithmetic               operation
            } else {
                System.out.println("Using Array 2!");
                // get input array length
                //sortNumber function for array2
        int n = arr.length;
        counter += 1; //assignment for n
        // "results" is array of ArrayList that contains the sorted data
        // to clear previous "results" array so that no overlapping of data occurs
        for (int i = 0; i < 10; i++) {
            counter += 1; //i < 10 comparison
            array2[i].clear();
            counter += 2; //array access and calling clear method
            counter += 2; //increment and assignment for i
        }
        counter += 1; //last i < 10 comparison

        // core logic for the sort algorithm
        // loop from 0-9 (index of the array of ArrayList)
        for (int i = 0; i < 10; i++) {
            // loop through each number in input array
            counter += 1; //i < 10 comparison
            for (int j = 0; j < n; j++) {
                counter += 1; //j < n comparison
                // get the digit of the number's significant place
                int exact_num = (arr[j] / place) % 10;
                counter += 3; //assignment for exact_num and / and % arithmetic operations
                if (exact_num == i) {
                    // add the number into the ArrayList of its respective index in the array of ArrayList
                    array2[i].add(arr[j]);
                    counter += 3; //2 array access and calling add() method
                    counter += 1; //exact_num == i comparison
                } else {
                    continue;
                }
            counter += 2; //increment and assignment for j
            }
        counter += 1; //last j < n comparison
        counter += 2; //increment and assignment for i
        }
        counter += 1; //last i < 10 comparison

        // "store" is a temporary storage that used to store the result of converting array of ArrayList into ArrayList<Integer>
        // converting array of ArrayList into ArrayList<Integer> is to ease the process to convert ArrayList<Integer> to array of integers which is the initial data passed
        for (int i = 0; i < 10; i++) {
            counter += 1; //i < 10 comparison
            for (int j = 0; j < array2[i].size(); j++) {
                counter += 3; //j < result[i].size() comparison and array                access and calling size() method
                store.add(array2[i].get(j));
                counter += 3; //calling size() and get () methods and array              access
                counter += 2; //increment and assignment for j
            }
            counter += 3; //last j < result[i].size() comparison and array               access and calling size() method
        }
        counter += 1; //last i < 10 comparison

        // pass the sorted array back to the input array
        for (int i = 0; i < n; i++) {
            counter += 1; //i < n comparison
            arr[i] = store.get(i);
            counter += 3; //array access and assignment for input_arr[i] and             calling get() method
            counter += 2; //increment and assignment for i
        }
        counter += 1; //last i < n comparison

        // clear the "store" ArrayList for next time use
        for (int i = 0; i < n; i++) {
            counter += 1; //i < n comparison
            store.remove(0);
            counter += 1; //calling remove() method
            counter += 2; //increment and assignment for i
        }
        counter += 1; //last i < n comparison

        System.out.println(Arrays.toString(array2));
        counter += 2; //calling println() and toString() methods
                System.out.println("Array 1: ");
                System.out.print(Arrays.toString(array1));
                System.out.println("");
                System.out.println("");
                counter += 1; // calling toString() methods
                counter += 2; //count % 2 == 0 comparison and % arithmetic               operation
            }
            count++;
            counter += 2; //increment and assignment for count
            counter += 2; //increment and assignment for place
        }
        counter += 2; // last max / place > 0 comparison and / arithmetic                 operation

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
        
        // initialize  original array
        int data[];

        // initialize variables that use to get input from user later
        String temp;
        int arrSize = 1;

        // to get input from user on the size of original array
        // prompt user to input again if the input is not a number
        try (Scanner myObj = new Scanner(System.in)) {
            boolean containsOnlyDigits = false;
            while (containsOnlyDigits == false) {
                containsOnlyDigits = true;
                System.out.println("Enter array size : ");
                temp = myObj.nextLine();
                for (int i = 0; i < temp.length(); i++) {
                    if (!Character.isDigit(temp.charAt(i))) { 
                        containsOnlyDigits = false;
                    }
                }

                if (containsOnlyDigits) {
                    arrSize = Integer.parseInt(temp);
                } else {
                    System.out.println("Please input a number!");
                    System.out.println();
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        // initialize the size of original array based on input size
        data = new int[arrSize];

        // add random numbers into original array
        for (int i = 0; i < arrSize; i++) {
            data[i] = ThreadLocalRandom.current().nextInt(1, 100000 + 1);
        }

         // show original array
         System.out.println("");
         System.out.println("Original List: ");
         System.out.print(Arrays.toString(data));
         System.out.println("");
 
         // pass original array to radix sort algorithm
         System.out.println("");
         RadixSortCounter.radixSort(data);
 
         // show sorted array
         System.out.println("");
         System.out.println("Sorted List: ");
         System.out.print(Arrays.toString(data));

    }
}
