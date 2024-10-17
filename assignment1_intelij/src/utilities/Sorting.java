package utilities;

import shapes.Shape3D;

import java.util.Comparator;

public class Sorting {

    // Bubble Sort
    public static void bubbleSort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
        for (int i = 0; i < shapes.length - 1; i++) {
            for (int j = 0; j < shapes.length - i - 1; j++) {
                if (comparator.compare(shapes[j], shapes[j + 1]) > 0) {
                    swap(shapes, j, j + 1);
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
        for (int i = 0; i < shapes.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < shapes.length; j++) {
                if (comparator.compare(shapes[j], shapes[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            swap(shapes, i, minIdx);
        }
    }

    // Insertion Sort
    public static void insertionSort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
        for (int i = 1; i < shapes.length; i++) {
            Shape3D key = shapes[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare(shapes[j], key) > 0) {
                shapes[j + 1] = shapes[j];
                j--;
            }
            shapes[j + 1] = key;
        }
    }

    // Merge Sort
    public static void mergeSort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
        if (shapes.length > 1) {
            int mid = shapes.length / 2;
            Shape3D[] left = new Shape3D[mid];
            Shape3D[] right = new Shape3D[shapes.length - mid];

            System.arraycopy(shapes, 0, left, 0, mid);
            System.arraycopy(shapes, mid, right, 0, shapes.length - mid);

            mergeSort(left, comparator);
            mergeSort(right, comparator);

            merge(shapes, left, right, comparator);
        }
    }

    private static void merge(Shape3D[] shapes, Shape3D[] left, Shape3D[] right, Comparator<Shape3D> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) {
                shapes[k++] = left[i++];
            } else {
                shapes[k++] = right[j++];
            }
        }
        while (i < left.length) {
            shapes[k++] = left[i++];
        }
        while (j < right.length) {
            shapes[k++] = right[j++];
        }
    }

    // Quick Sort
    public static void quickSort(Shape3D[] shapes, Comparator<Shape3D> comparator, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(shapes, comparator, low, high);
            quickSort(shapes, comparator, low, pivotIndex - 1);
            quickSort(shapes, comparator, pivotIndex + 1, high);
        }
    }

    private static int partition(Shape3D[] shapes, Comparator<Shape3D> comparator, int low, int high) {
        Shape3D pivot = shapes[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(shapes[j], pivot) < 0) {
                i++;
                swap(shapes, i, j);
            }
        }
        swap(shapes, i + 1, high);
        return i + 1;
    }

    // Utility function to swap elements
    private static void swap(Shape3D[] shapes, int i, int j) {
        Shape3D temp = shapes[i];
        shapes[i] = shapes[j];
        shapes[j] = temp;
    }
}
