import java.util.ArrayList;

public class RadixSortV2 {

    private static float getMax (ArrayList<Float> input_arr){
        // Find maximum number to know number of digits
        float max = input_arr.get(0);
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

        //temp = new ArrayList<Float>(n);

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

    public static void radixSort(ArrayList<Float> arr) {

        if (arr == null || arr.size() == 0) {
            return;
        }
        
      int mostSf = 0;
        for (int i = 0; i < arr.size(); i++) {
          String[] parts = Float.toString(arr.get(i)).split("\\.");
          int decPlaces = parts.length > 1 ? parts[1].length() : 0;
          if (decPlaces > mostSf) {
            mostSf = decPlaces;
          }
    
        }
        ArrayList<Integer> intArray = new ArrayList<Integer>();
    
        for (int i = 0; i < arr.size(); i++) {
          arr.set(i,(float)(arr.get(i) * Math.pow(10, mostSf)));
          intArray.add(Math.round(arr.get(i)));
        }
int max =(int) getMax(arr);
        // Find maximum number to know number of digits
        

        ArrayList<Integer> array1 = new ArrayList<Integer>(intArray.size());
        ArrayList<Integer> array2 = new ArrayList<Integer>(intArray.size());

        for (int i = 0; i < arr.size(); i++) {
            array1.add(i);
            array2.add(i);
        }
        int cnt = 0;
        // Perform counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            if (cnt % 2 == 0) {
                System.out.println("Using Array 1!");
                comparisonSort(intArray, exp, array1);
                System.out.println("Array 2: ");
                System.out.print(array2);
                System.out.println("");
            } else {
                System.out.println("Using Array 2!");
                comparisonSort(intArray, exp, array2);
                System.out.println("Array 1: ");
                System.out.print(array1);
                System.out.println("");
            }
            
            cnt++;
            //System.out.println(arr);
        }
    int index = 0;
    arr.clear();
    for (float value: intArray) {
      value = (float)(value / Math.pow(10, mostSf));
      arr.add(value);
    }
    }

    public static void main(String[] args) {
        ArrayList<Float> arr = new ArrayList<Float>();
        arr.add(275.0f);
        arr.add(87.2f);
        arr.add(426.3f);
        arr.add(61.4f);
        arr.add(409.5f);
        arr.add(170.0f);
        arr.add(677.0f);
        arr.add(503.0f);

        RadixSortV2.radixSort(arr);

        System.out.println("");
        System.out.println("Sorted List: ");
        System.out.print(arr);
    }
}
