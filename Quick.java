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
    private static int partition(int[] data, int start, int end){
       if (start == end) return start;
       // if start and end are the same (meaning nothing is to be sorted), return start
       int[] tempAry = new int[] {data[start], data[end], data[data.length/2]};
       // make int array of the start, end, and middle value
       Arrays.sort(tempAry);
       // sort the array
       int pivot = tempAry[1];
       // pivot is set to the medium
       int index = data.length/2;
       if (data[start] == pivot){
         index = start;
       }
       else if (data[end] == pivot){
         index = end;
       }
       data[index] = data[start];
       data[start] = pivot;
       // pivot swaps places with the value at index start of data
       index = start;
       start++;
       // start is increased by one
       Random rand = new Random();
       // initialize random number generator
       while (start != end){
         // while start is not equal to end
         if (data[start] > pivot || (data[start] == pivot && rand.nextInt() % 2 == 0)){
           // if the value at start is greater than pivot or
           // the value at start is equal to pivot and the randomly generated int is multiple of 2 (50% chance)
           int temp = data[start];
           // value at index start is stored in a temp variable
           data[start] = data[end];
           data[end] = temp;
           // value at start switch places with value at end
           end--;
           // end is decreased by one
         }
         else start++;
         // else if value at start is less than pivot, increase start by one
       }
       //System.out.println(start);
       //System.out.println(pivot);
       //System.out.println(Arrays.toString(data));
       if (data[start] < pivot){
         // if value at start is less than or equal to pivot
         data[index] = data[start];
         data[start] = pivot;
         // pivot and the value at start swap places

         //System.out.println(Arrays.toString(data));
         //System.out.println("pivot:" + pivot);
         return start;
         // return start, the index of pivot
       }
       else{
         // else
         data[index] = data[start - 1];
         data[start - 1] = pivot;
         // pivot and the value at index (start - 1) swap places

         //System.out.println(Arrays.toString(data));
         //System.out.println("pivot:" + pivot);
         return start - 1;
         // return start - 1, the index of pivot
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
