package CPT212_Asg1;

// import ArrayList and Arrays
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RadixSort {

    // function to get the largest number in the input array so that we can obtain the largest digit/significant number 
    private static int getMax(int[] input_arr) {
        int max = input_arr[0];
        for (int i = 1; i < input_arr.length; i++) {
            if (input_arr[i] > max) {
                max = input_arr[i];
            }
        }
        return max;
    }

    // function to sort the number into their respective
    private static void sortNumber(int[] input_arr, int place, ArrayList<Integer>[] result, ArrayList<Integer> store) {

        // get input array length
        int n = input_arr.length;

        // "results" is array of ArrayList that contains the sorted data
        // to clear previous "results" array so that no overlapping of data occurs
        for (int i = 0; i < 10; i++) {
            result[i].clear();
        }

        // core logic for the sort algorithm
        // loop from 0-9 (index of the array of ArrayList)
        for (int i = 0; i < 10; i++) {
            // loop through each number in input array
            for (int j = 0; j < n; j++) {
                // get the digit of the number's significant place
                int exact_num = (input_arr[j] / place) % 10;
                if (exact_num == i) {
                    // add the number into the ArrayList of its respective index in the array of ArrayList
                    result[i].add(input_arr[j]);
                } else {
                    continue;
                }
            }
        }

        // "store" is a temporary storage that used to store the result of converting array of ArrayList into ArrayList<Integer>
        // converting array of ArrayList into ArrayList<Integer> is to ease the process to convert ArrayList<Integer> to array of integers which is the initial data passed
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < result[i].size(); j++) {
                store.add(result[i].get(j));
            }
        }

        // pass the sorted array back to the input array
        for (int i = 0; i < n; i++) {
            input_arr[i] = store.get(i);
        }

        // clear the "store" ArrayList for next time use
        for (int i = 0; i < n; i++) {
            store.remove(0);
        }

        System.out.println(Arrays.toString(result));
    }

    // call function
    public static void radixSort(int[] arr) {

        // check if input array is empty
        if (arr == null || arr.length == 0) {
            return;
        }

        // call "getMax" to get maximum number to obtain the largest digit/significant number in input array
        int max = getMax(arr);

        // declare "array1" and "array2" for sorting purposes
        // both arrays are array of ArrayList<Integer>
        ArrayList<Integer>[] array1 = (ArrayList<Integer>[]) new ArrayList[10];
        ArrayList<Integer>[] array2 = (ArrayList<Integer>[]) new ArrayList[10];

        // delare "store" array that serves as a temporary storage that used to store the result of converting array of ArrayList into ArrayList<Integer>
        ArrayList<Integer> store = new ArrayList<Integer>(arr.length);

        // fill each element of "array1" and "array2" with empty ArrayList<Integer>
        for (int i = 0; i < 10; i++) {
            array1[i] = new ArrayList<Integer>();
            array2[i] = new ArrayList<Integer>();
        }

        // "count" is used to determine which array (array1/array2) is being used at that particular significant number
        int count = 0;
        // for loop to increase the decimal place/significant number for each iteration 
        for (int place = 1; max / place > 0; place *= 10) {
            if (count % 2 == 0) {
                System.out.println("Using Array 1!");
                sortNumber(arr, place, array1, store);
                System.out.println("Array 2: ");
                System.out.print(Arrays.toString(array2));
                System.out.println("");
                System.out.println("");
            } else {
                System.out.println("Using Array 2!");
                sortNumber(arr, place, array2, store);
                System.out.println("Array 1: ");
                System.out.print(Arrays.toString(array1));
                System.out.println("");
                System.out.println("");
            }
            count++;
        }
    }

    public static void main(String[] args) {

        // initialize input data
        // int[] data = { 275, 87, 426, 61, 409, 17012, 677, 503 };

        // // data passed to fucntion to be sorted
        // RadixSort.radixSort(data);

        // System.out.println("");
        // System.out.println("Sorted List: ");
        // System.out.print(Arrays.toString(data));
        int data[];
        String temp;
        int arrSize=1;
        try (Scanner myObj = new Scanner(System.in)) {
            boolean containsOnlyDigits=false;
            while (containsOnlyDigits==false){
                containsOnlyDigits=true;
            System.out.println("Enter array size : ");
            temp = myObj.nextLine();
                for (int i = 0; i < temp.length(); i++) {
     if (!Character.isDigit(temp.charAt(i))) { // in case that a char is NOT a digit, enter to the if code block
            containsOnlyDigits = false;
     }
   }

   if (containsOnlyDigits) {
     arrSize=Integer.parseInt(temp);
    //  System.out.println("Array size is "+ arrSize);
   } else {
     System.out.println("Please input a number!");
     System.out.println();
   }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } 
        data = new int[arrSize];
        for (int i=0; i<arrSize;i++){
            data[i]=ThreadLocalRandom.current().nextInt(1, 100000 + 1);
        }
        System.out.println("");
        System.out.println("Original List: ");
        System.out.print(Arrays.toString(data));
        System.out.println("");
        
        System.out.println("");
        RadixSort.radixSort(data);

        System.out.println("");
        System.out.println("Sorted List: ");
        System.out.print(Arrays.toString(data));
    }
}
