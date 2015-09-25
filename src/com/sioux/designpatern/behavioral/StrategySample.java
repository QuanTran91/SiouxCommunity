package com.sioux.designpatern.behavioral;

/**
 * Created by myrap_000 on 9/22/2015.
 */
public class StrategySample {
    public static void main(String[] args) {
        ISort sort = new QuickSort();
        sort.Sort();

    }
}


interface ISort {
    void Sort();
}

class HeapSort implements ISort {

    @Override
    public void Sort() {
        System.out.println("Heap Sort");
    }
}

class QuickSort implements ISort {
    @Override
    public void Sort() {
        System.out.println("Quick Sort");
    }
}