package Sorting; /**
 * @author Timo Karl Andreas Boomgaarden
 * @description This class contains different methods used to sort arrays.
 */

import java.util.Arrays;
import java.util.List;

public class SortingAlgorithms {

    /**
     * Sorts an array using Mergesort implemented with an array.
     * @param a the array that will be sorted
     * @return the sorted array
     */
    public static int[] mergeSort(int[] a){
        if(a.length>1){
            int[] left = Arrays.copyOfRange(a,0,a.length/2);
            int[] right = Arrays.copyOfRange(a,a.length/2,a.length);
            left = mergeSort(left);
            right = mergeSort(right);
            a = merge(left,right);
        }
        return a;
    }

    /**
     * Merges 2 sorted arrays in correct order.
     * @param left lefthand array
     * @param right righthand array
     * @return a merged array containing both input arrays in correct order.
     */
    private static int[] merge(int[] left, int[] right){
        int[] a = new int[left.length + right.length]; //CREATE NEW ARRAY FOR RESULT
        int ri = 0;
        int li = 0;

        while(ri<(right.length) && li<(left.length)){
            if(left[li]<right[ri]){
                a[ri+li] = left[li];
                li++;
            }
            else{
                a[ri+li] = right[ri];
                ri++;
            }
        }
        while(ri<(right.length)){
            a[ri+li] = right[ri];
            ri++;
        }
        while(li<(left.length)){
            a[ri+li] = left[li];
            li++;
        }
        return a;
    }

    /**
     * Sorts an array using Selectionsort implemented with an array.
     * @param a the array that will be sorted.
     * @return the sorted array
     */
    public static int[] selectionSort(int[] a){
        for(int startPos = 0; startPos<a.length; startPos++){
            //RESET BOTH PARAMETERS TO START VALUE
            int sni = startPos;
            int num = a[startPos];

            for(int j = startPos; j<a.length; j++){
                //FIND THE SMALLEST NUMBER INDEX "sni"
                if(num>a[j]){
                    num = a[j];
                    sni = j;
                }
            }
            //SWAP THE TWO NUMBERS
            int bre = a[startPos];
            a[startPos] = a[sni];
            a[sni] = bre;
        }
        return a;
    }

    /**
     * Sorts a List using Selectionsort implemented with a List type.
     * @param a the list to be sorted
     * @return the sorted List
     */

    public static List<Integer> selectionSort(List<Integer> a){
        int placeholder = 0;
        for(int i = 0; i<a.size(); i++){
            //FIND THE MIN VALUE
            for(int j = i; j<a.size(); j++){
                if(a.get(j)<a.get(placeholder)){
                    placeholder = j;
                }
            }
            int temp = a.get(i);
            a.set(i,a.get(placeholder));
            a.set(placeholder,temp);
            //a.set(i, a.get(i) + a.get(placeholder));
            //a.set(placeholder, a.get(i) - a.get(placeholder));
            //a.set(i, a.get(i) - a.get(placeholder));
        }
        return a;
    }

    /**
     * Sorts an array using Insertionsort implemented with an array.
     * @param a the array to be sorted.
     * @return the sorted array
     */

    public static int[] insertionSort(int[] a){
        for(int i = 1; i<a.length; i++){     //LOOP THROUGH EACH NUMBER
            int value = a[i];               //TAKE ONE NUMBER i = value
            int j = i;
            while(a[j-1] > value){    //COUNT DOWN FROM THAT INDEX UNTIL YOU FIND SMALLER VALUE AT INDEX j-1
                a[j] = a[j - 1];               //MOVE NUMBER AT j TO THE RIGHT TO MAKE SPACE FOR INSERTION
                j--;
                if(j==0) break; //safety
            }
            a[j] = value;                       //j IS CORRECT INDEX WITH ALL NUMBERS ABOVE MOVED RIGHTWARDS ALREADY
        }

        return a;
    }
}
