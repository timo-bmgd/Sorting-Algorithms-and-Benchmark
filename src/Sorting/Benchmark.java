package Sorting;

public class Benchmark {
    public static void main(String[] args) {
        int[] unsorted = createBenchmarkValues(500,10000);
        long currentTime = System.nanoTime();
        SortingAlgorithms.mergeSort(unsorted);
        System.out.println("Mergesort    :"+(System.nanoTime()-currentTime)/1000000.0 +"ms");
        currentTime = System.nanoTime();
        SortingAlgorithms.selectionSort(unsorted);
        System.out.println("Selectionsort:"+(System.nanoTime()-currentTime)/1000000.0 +"ms");
        currentTime = System.nanoTime();
        SortingAlgorithms.insertionSort(unsorted);
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