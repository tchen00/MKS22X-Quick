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
      int index = (int)(Math.random() * (end - start + 1)) + start;
      int pivot = data[index]; // setting the pivot
      data[index] = data[0];
      data[0] = pivot;
      start++; // pivot found now search through the rest of the data
      // while it doesn't meet in the middle
      while (start != end){
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
      }
      else{
        // if the current start is equal than the pivot 
        data[0] = data[start - 1]; // set the pivot to start - 1
        data[start - 1] = pivot; // swaps the pivot and the start
        return start - 1;
      }
    }


}
