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
      index = start;
      start++; // pivot found now search through the rest of the data
      // while it doesn't meet in the middle
      // random number generator
      Random r = new Random();
      while (start != end){
        // if the number is greater than pivot
        if (data[start] > pivot || (data[start] == pivot && r.nextInt() % 2 == 0)){
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
        data[index] = data[start];
        data[start] = pivot;
        return start;
      } else {
        // if the current start is equal than the pivot
        data[index] = data[start - 1]; // set the pivot to start - 1
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
      public static void main(String[]args){
        System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
        int[]MAX_LIST = {1000000000,500,10};
        for(int MAX : MAX_LIST){
          for(int size = 31250; size < 2000001; size*=2){
            long qtime=0;
            long btime=0;
            //average of 5 sorts.
            for(int trial = 0 ; trial <=5; trial++){
              int []data1 = new int[size];
              int []data2 = new int[size];
              for(int i = 0; i < data1.length; i++){
                data1[i] = (int)(Math.random()*MAX);
                data2[i] = data1[i];
              }
              long t1,t2;
              t1 = System.currentTimeMillis();
              Quick.quicksort(data2);
              t2 = System.currentTimeMillis();
              qtime += t2 - t1;
              t1 = System.currentTimeMillis();
              Arrays.sort(data1);
              t2 = System.currentTimeMillis();
              btime+= t2 - t1;
              if(!Arrays.equals(data1,data2)){
                System.out.println("FAIL TO SORT!");
                System.exit(0);
              }
            }
            System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
          }
          System.out.println();
        }
      }


}
