import java.io.*;
import java.util.*;

/*
Given two sorted arrays list1 and list2 of size m and n respectively, return the median of the two sorted arrays.
*/
class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        //17
        int[] array1 = new int[]{1,3,3,5,7,12,16,18,24,25,29,35,39,41};
        int[] array2 = new int[]{3,5,9,10,10,10,25,28,34,37,43,45};
        System.out.println(returnMedian(array1,array2));
    }
    //Returns the median in O(n) time using O(n) space
    public static double returnMedian(int[] array1,int[] array2){
        int[] holdSortedValues = new int[array1.length+array2.length];
        System.out.println("holdSorted Len:" + holdSortedValues.length);
        int array1Pointer = 0;
        int array2Pointer = 0;
        for(int x=0;x<holdSortedValues.length;x++){
            if(array1Pointer >= array1.length){
                System.out.println("Value added:" + array2[array2Pointer]);
                holdSortedValues[x] = array2[array2Pointer];
                array2Pointer++;
            }else if(array2Pointer >= array2.length){
                System.out.println("Value added:" + array1[array1Pointer]);
                holdSortedValues[x] = array1[array1Pointer];
                array1Pointer++;

            }else if(array1[array1Pointer] < array2[array2Pointer]){
                System.out.println("Value added:" + array1[array1Pointer]);
                holdSortedValues[x] = array1[array1Pointer];
                array1Pointer++;

            }else /*if(array2[array2Pointer] < array1[array1Pointer])*/{
                System.out.println("Value added:" + array2[array2Pointer]);
                holdSortedValues[x] = array2[array2Pointer];
                array2Pointer++;
            }

        }
        System.out.println(Arrays.toString(holdSortedValues));
        if(holdSortedValues.length % 2 == 0){
            return (holdSortedValues[(holdSortedValues.length-2)/2] + holdSortedValues[(holdSortedValues.length-2)/2 + 1])/2;
        }else{
            return holdSortedValues[(holdSortedValues.length-1)/2];
        }
    }
}
