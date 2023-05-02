import java.util.ArrayList;

public class RadixSortV2 {

    private static int getMax (ArrayList<Integer> input_arr){
        // Find maximum number to know number of digits
        int max = input_arr.get(0);
        for (int i = 1; i < input_arr.size(); i++) {
            if (input_arr.get(i) > max) {
                max = input_arr.get(i);
            }
        }

        return max;
    }
    
    private static void comparisonSort(ArrayList<Integer> input_arr, int exp, ArrayList<Integer> temp) {
        
        int n = input_arr.size();

        for (int i = 0; i < n; i++){
            temp.remove(0);
        }

        //temp = new ArrayList<Integer>(n);

        // Initialize identify array

        // int[] identify = new int[10];
        // for (int i = 0; i < 10; i++) {
        //     identify[i] = i;
        // }

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j<n; j++){
                int exact_num = (input_arr.get(j) / exp) % 10;
                if(exact_num==i){
                    temp.add(input_arr.get(j));
                }
                else{
                    continue;
                }
            }
        }

        // System.out.println(output);
        // System.out.println(arr);

        // Copy the output array to arr[], so that arr[] now contains sorted numbers
        // according to current digit

        for (int i = 0; i < n; i++) {
            input_arr.set(i, temp.get(i));
        }
        
        //return input_arr;

        System.out.println(input_arr);
        // System.out.println(output);
    }

    public static void radixSort(ArrayList<Integer> arr) {

        if (arr == null || arr.size() == 0) {
            return;
        }

        // Find maximum number to know number of digits
        int max = getMax(arr);

        ArrayList<Integer> array1 = new ArrayList<Integer>(arr.size());
        ArrayList<Integer> array2 = new ArrayList<Integer>(arr.size());

        for (int i = 0; i < arr.size(); i++) {
            array1.add(i);
            array2.add(i);
        }
        int cnt = 0;
        // Perform counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            if (cnt % 2 == 0) {
                System.out.println("Using Array 1!");
                comparisonSort(arr, exp, array1);
                System.out.println("Array 2: ");
                System.out.print(array2);
                System.out.println("");
            } else {
                System.out.println("Using Array 2!");
                comparisonSort(arr, exp, array2);
                System.out.println("Array 1: ");
                System.out.print(array1);
                System.out.println("");
            }
            
            cnt++;
            //System.out.println(arr);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(275);
        arr.add(87);
        arr.add(426);
        arr.add(61);
        arr.add(409);
        arr.add(170);
        arr.add(677);
        arr.add(503);

        RadixSortV2.radixSort(arr);

        System.out.println("");
        System.out.println("Sorted List: ");
        System.out.print(arr);
    }
}
