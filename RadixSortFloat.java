import java.util.Arrays;

class RadixSort {

  // first, we get the largest number in the array so that we can get the largest significant number
  int getMax(int arr[]) {
    int max = arr[0];
    int size = arr.length;
    for (int i = 1; i < size; i++) {
      if (arr[i] > max)
        max = arr[i];
    }
    //System.out.println(max);
    return max;
  }

  // use counting sort to sort the elements based on significant places
  void countingSort(int array[], int place, int identify[]) {

    // get array size length
    int size = array.length;

    // declare output array
    int[] output = new int[size];

    // int[] identify = new int[10];
    // for (int i = 0; i < 10; i++) {
    //     identify[i] = i;
    // }

    // declare count array to count occurence of each digit in array (0-9)
    int[] count = new int[10];
    // initialize each number occurences to 0
    for (int i = 0; i < 10; ++i) {
      count[i] = 0;
    }

    // calculate occurences of each numbers in array
    for (int i = 0; i < size; i++) {
      int exact_num = (array[i] / place) % 10;
      for (int j = 0; j < 10; j++) {
        if (exact_num == j) {
          count[j]++;
        }
      }
      //count[(array[i] / place) % 10]++;
    }

    //System.out.println(Arrays.toString(count));

    // calculate cumulative count
    for (int i = 1; i < 10; i++) {
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
    for (int i = 0; i < size; i++) {
      array[i] = output[i];
    }

    //System.out.println(Arrays.toString(output));
  }

  // main function to implement radix sort
  void radixSort(float array[]) {
    // Get maximum element
    int mostSf = 0;
    for (int i = 0; i < array.length; i++) {
      String[] parts = Float.toString(array[i]).split("\\.");
      int decPlaces = parts.length > 1 ? parts[1].length() : 0;
      if (decPlaces > mostSf) {
        mostSf = decPlaces;
      }

    }
    int[] intArray = new int[array.length];

    for (int i = 0; i < array.length; i++) {
      array[i] = (float)(array[i] * Math.pow(10, mostSf));
      intArray[i] = (int) array[i];
    }
    // Get maximum element
    int max = getMax(intArray);

    // to declare array 1 and array 2
    int cnt = 0;
    int[] arr1 = {
      0,
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9
    };
    int[] arr2 = {
      0,
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9
    };
    // apply counting sort to sort elements based on place value.
    int counter = 0;
    for (int place = 1; max / place > 0; place *= 10) {
      //System.out.println("Array " + ((cnt % 2) + 1));
      counter++;
      // if(cnt%2==0){
      countingSort(intArray, place, arr1);
      System.out.println("Using Array " + counter);
      // }
      // else{
      //     countingSort(intArray, place, arr2);
      //     System.out.println("Using Array 2!");
      // }
      //countingSort(array, place, arr1);
      cnt++;
      System.out.println(Arrays.toString(intArray) + "\n");
    }
    int index = 0;
    for (float value: intArray) {
      value = (float)(value / Math.pow(10, mostSf));
      array[index++] = value;
    }
  }

  public static void main(String args[]) {
    float[] data = {
      275.5 f,
      87.3356 f,
      426.346 f,
      61,
      409.3 f,
      170.35 f,
      677.2 f,
      503.34 f
    };
    RadixSort rs = new RadixSort();
    rs.radixSort(data);
    System.out.println("");
    System.out.println("Sorted List: " + Arrays.toString(data));
  }
}
