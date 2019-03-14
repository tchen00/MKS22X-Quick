//DDRIVER FROM BRYAN

import java.util.*;
public class Driver {
  public static void main(String[] args) {
    int[] arr = { 2, 10, 15, 23, 0,  5};
    System.out.println("Array: " + Arrays.toString(arr));
    System.out.println(Quick.quickselect(arr,2));
    System.out.println("Array: " + Arrays.toString(arr));
    Quick.quicksort(arr);
    System.out.println("Array: " + Arrays.toString(arr));

  }
}
