package Sorting;

public class Benchmark {
    public static void main(String[] args) {
        int size = 50000;
        int range = 2000000;
        int[] unsorted = createBenchmarkValues(size,range);
        System.out.println("Quantity of numbers in array:"+size);
        System.out.println("Numbers ranging from 0 to:"+range);
        long currentTime = System.nanoTime();
        SortingAlgorithms.mergeSort(unsorted);
        System.out.println("Mergesort    :"+(System.nanoTime()-currentTime)/1000000.0 +"ms");
        unsorted = createBenchmarkValues(size,range);
        currentTime = System.nanoTime();
        SortingAlgorithms.selectionSort(unsorted);
        System.out.println("Selectionsort:"+(System.nanoTime()-currentTime)/1000000.0 +"ms");
        unsorted = createBenchmarkValues(size,range);
        currentTime = System.nanoTime();
        int[] a = SortingAlgorithms.insertionSort(unsorted);
        System.out.println("Insertionsort:"+(System.nanoTime()-currentTime)/1000000.0 +"ms");
        currentTime = System.nanoTime();

    }

    public static int[] createBenchmarkValues(int arraySize, int valueRange){
        int[] a = new int[arraySize];
        if(valueRange<2) throw new IllegalArgumentException();
        for(int i = 0; i<a.length; i++){
            a[i] = (int)(Math.random() * valueRange);
        }
        return a;
    }

    public static int[] createBenchmarkValues(int arraySize){
        int[] a = new int[arraySize];
        int valueRange = 10000;
        for(int i = 0; i<a.length; i++){
            a[i] = (int)(Math.random() * valueRange);
        }
        return a;
    }
}