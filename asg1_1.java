import java.util.Arrays;

class RadixSort {

    // first, we get the largest number in the array so that we can get the largest significant number
    int getMax(int arr[]) {
        int max = arr[0];
        int size = arr.length;
        for (int i = 1; i < size; i++){
            if (arr[i] > max)
                max = arr[i];
        }
        //System.out.println(max);
        return max;
    }

    // use counting sort to sort the elements based on significant places
    void countingSort(int array[], int place) {

        // get array size length
        int size = array.length;

        // declare output array
        int[] output = new int[size];

        // declare count array to count occurence of each digit in array (0-9)
        int[] count = new int[10];
        // initialize each number occurences to 0
        for (int i = 0; i < 10; ++i){
            count[i] = 0;
        }

        // calculate occurences of each numbers in array
        for (int i = 0; i < size; i++){
            count[(array[i] / place) % 10]++;
        }

        //System.out.println(Arrays.toString(count));

        // calculate cumulative count
        for (int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }

        //System.out.println(Arrays.toString(count));

        // place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            // to place the number in its respective orders in output array
            output[count[(array[i] / place) % 10] - 1] = array[i];
            // reduce the cumulative count after a number is placed
            count[(array[i] / place) % 10]--;
            //System.out.println(Arrays.toString(output));
            //System.out.println(Arrays.toString(count));
        }

        // move sorted array back to original array
        for (int i = 0; i < size; i++){
            array[i] = output[i];
        }

        //System.out.println(Arrays.toString(output));
    }

    // main function to implement radix sort
    void radixSort(int array[]) {
    // Get maximum element
    int max = getMax(array);
    
    // to declare array 1 and array 2
    int cnt = 0;
    // apply counting sort to sort elements based on place value.
    for (int place = 1; max / place > 0; place *= 10){
        System.out.println("Array " + ((cnt % 2) + 1));
        countingSort(array, place);
        cnt ++;
        System.out.println(Arrays.toString(array));
    }
    }

    public static void main(String args[]) {
    int[] data = {275,87,426,61,409,170,677,503};
    RadixSort rs = new RadixSort();
    rs.radixSort(data);
    System.out.println("");
    System.out.println("Sorted List: " + Arrays.toString(data));
    }
}
