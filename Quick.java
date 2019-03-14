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
      if (start >= end) return start;
      // picking median pivot at index
      int[] tempA = new int[] {data[start], data[end], data[data.length/2]};
      Arrays.sort(tempA); // sorting the array
      int pivot = tempA[1]; // median of this array
      int index = data.length/2;
      // checking to see if start and end has the pivot
      if (data[start] == pivot){
        index = start;
      }
      else if (data[end] == pivot){
        index = end;
      }
     //  int pivot = data[index]; // setting the pivot
      data[index] = data[start];
      data[start] = pivot;
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

    // STILL BROKEN OOPS
    public static void quicksort(int[] data){
      int low  = 0;
      int high = data.length - 1;
      quicksortH(data, low, high);
    }

    public static void quicksortH(int[] data, int lo, int hi){
      if (lo >= hi){
        return;
      }
      int pivot = partition(data, lo, hi);
      quicksortH(data,lo, pivot - 1);
      quicksortH(data, pivot + 1, hi);
    }

    public static void main(String[] args){
      int[] ary = new int[50000];

       for(int i = 0; i < ary.length;i++){
         ary[i] = (int)(Math.random() * 10 );
       }
          // System.out.println(Arrays.toString(ary));
          /*
           for (int i = 0; i < ary.length; i++){
             System.out.println("T"+ i + ": "+ quickselect(ary, i));
           }
          */
           //System.out.println(Arrays.toString(ary));

           quicksort(ary);
           //Arrays.sort(ary);
           System.out.println(Arrays.toString(ary));
    }

}
