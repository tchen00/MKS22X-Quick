// DRIVER FROM GEORGE !

import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

public class Driver {

    public static boolean test(int[] data, int k) {
        for (int i = 0; i < data.length; i++) {
            if (i < k) {
                if (data[i] > data[k]) {
                    return false;
                }
            } else if (i > k) {
                if (data[i] < data[k]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] data1 = {10, 80, 30, 90, 40, 50, 70};
        //System.out.println(Arrays.toString(data1));
        System.out.println("1a: " + test(data1, Partition.partition(data1, 0, 6)));
        //System.out.println(Arrays.toString(data1) + "\n");
        //System.out.println(Arrays.toString(data1));
        System.out.println("1b: " + test(data1, Partition.partition(data1, 2, 5)));
        //System.out.println(Arrays.toString(data1) + "\n");

        int[] data2 = {6, 3, 7, -1, 7, 4, 10, -21};
        //System.out.println(Arrays.toString(data2));
        System.out.println("2a: " + test(data2, Partition.partition(data2, 2, 7)));
        //System.out.println(Arrays.toString(data2) + "\n");
        //System.out.println(Arrays.toString(data2));
        System.out.println("2b: " + test(data2, Partition.partition(data2, 1, 4)));
        //System.out.println(Arrays.toString(data2) + "\n");

        int[] data3 = {78};
        //System.out.println(Arrays.toString(data3));
        System.out.println("3: " + test(data3, Partition.partition(data3, 0, 0)));
        //System.out.println(Arrays.toString(data3) + "\n");

        int[] data4 = {3, 1};
        //System.out.println(Arrays.toString(data4));
        System.out.println("4: " + test(data4, Partition.partition(data4, 0, 1)));
        //System.out.println(Arrays.toString(data4) + "\n");

        for (int i = 0; i < 100; i++) {
            try {
                Random gen = new Random();
                int[] test = new int[i * 1000 + 1];
                for (int j = 0; j < test.length; j++) {
                    test[j] = gen.nextInt();
                }
                int start = Math.abs(gen.nextInt()) % test.length;
                int end = start + Math.abs(gen.nextInt()) % (test.length - start);
                //System.out.println(start + ", " + end);
                //System.out.println(Arrays.toString(test));
                if (!test(test, Partition.partition(test, start, end))) {
                    System.out.print("FAILURE ON LENGTH " + i);
                    System.exit(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.print("FAILURE ON LENGTH " + i);
                System.exit(1);
            }
        }
        System.out.println("R: SUCCESS"); //R for random
    }
}
