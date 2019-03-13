import java.util.*;
import java.io.*;

public class Quick{
  /*Modify the array such that:
    *1. Only the indices from start to end inclusive are considered in range
    *2. A random index from start to end inclusive is chosen, the corresponding
    *   element is designated the pivot element.
    *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
    *4. all elements in range that are larger than the pivot element are placed after the pivot element.
    *@return the index of the final position of the pivot element.
    */
    public static int partition ( int [] data, int start, int end){
      // picking random pivot at index
      //if (start >= end) return;
      int index = (int)(Math.random() * (end - start + 1)) + start;
     //System.out.println(index);
      int pivot = data[index]; // setting the pivot
      data[index] = data[0];
      data[0] = pivot;
      start++; // pivot found now search through the rest of the data
      // while it doesn't meet in the middle
      while (start < end){
        // if the number is greater than pivot
        if (data[start] > pivot){
          // swap the start and end
          int temp = data[start];
          data[start] = data[end];
          data[end] = temp;
          end--;
        } else{
          // increase start
          start++;
        }
      }
      // if the current start is less than pivot (return the current start)
      if (data[start] < pivot){
        data[0] = data[start];
        data[start] = pivot;
        return start;
      } else{
        // if the current start is equal than the pivot
        data[0] = data[start - 1]; // set the pivot to start - 1
        data[start - 1] = pivot; // swaps the pivot and the start
        return start - 1;
      }
    }

    /*return the value that is the kth smallest value of the array.
    */
    public static int quickselect(int[] data, int k){
      int start = 0;
      int end = data.length - 1;
      int index = partition(data, start, end);
      while (index != k){
        if (index > k){
          end = index - 1;
        } else {
          start = index + 1;
        }
        index = partition(data,start,end);
      }
      return data[index];
    }

    public void quicksort(int[] data){
      int low  = 0;
      int high = data.length - 1;
      quicksortH(data, low, high);
    }

    public void quicksortH(int[] data, int lo, int hi){
      if (lo >= hi){
        return;
      }
      int pivot = partition(data, lo, hi);
      quicksortH(data,lo, pivot - 1);
      quicksortH(data, pivot + 1, hi);
    }

    public static void main(String[] args){
      int[] array = new int[] {4,10,2,1,0};
      //System.out.println(partition(array, 0, 2));

      System.out.println(Arrays.toString(array));
      for (int i = 0; i < array.length; i++){
        System.out.println("term " + i + ": "+ quickselect(array, i));
      }

    }

}
