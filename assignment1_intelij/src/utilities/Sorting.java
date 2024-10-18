package utilities;

import shapes.Shape3D;

import java.util.Comparator;
import java.util.List;

import static java.util.Collections.shuffle;

/**
 * The Sorting class provides static methods for sorting arrays of Comparables in descending order.
 */
public class Sorting {

    /**
     * Bubble sort for an array of Comparables in descending order.
     *
     * @param arr
     * @param comparator
     */
    public static void bubbleSort(Comparable[] arr, Comparator<Shape3D> comparator) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                // If a comparator is provided, use it for comparison
                int comparisonResult;
                if (comparator != null) {
                    comparisonResult = comparator.compare((Shape3D) arr[j], (Shape3D) arr[j + 1]);
                } else {
                    // Natural ordering if no comparator is provided
                    comparisonResult = arr[j].compareTo(arr[j + 1]);
                }

                // Sorting in descending order, so swap if the first is smaller
                if (comparisonResult < 0) {
                    // Swap arr[j] and arr[j + 1]
                    Comparable temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no elements were swapped, break (array is already sorted)
            if (!swapped) break;
        }
    }

    /**
     * Overloaded method to sort using natural ordering.
     *
     * @param arr
     */
    public static void bubbleSort(Comparable[] arr) {
        bubbleSort(arr, null);
    }

    /**
     * Selection sort for an array of Comparables in descending order.
     *
     * @param arr
     * @param comparator
     */
    public static void selectionSort(Comparable[] arr, Comparator<Shape3D> comparator) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                int comparisonResult;
                if (comparator != null) {
                    comparisonResult = comparator.compare((Shape3D) arr[j], (Shape3D) arr[maxIdx]);
                } else {
                    comparisonResult = arr[j].compareTo(arr[maxIdx]);
                }
                // Find the maximum element for descending order
                if (comparisonResult > 0) {
                    maxIdx = j;
                }
            }
            // Swap the found maximum element with the first element
            Comparable temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Overloaded method to sort using natural ordering.
     *
     * @param arr
     */
    public static void selectionSort(Comparable[] arr) {
        selectionSort(arr, null);
    }

    /**
     * Insertion sort for an array of Comparables in descending order.
     *
     * @param arr
     * @param comparator
     */
    public static void insertionSort(Comparable[] arr, Comparator<Shape3D> comparator) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            Comparable key = arr[i];
            int j = i - 1;

            // Compare using either comparator or natural ordering
            while (j >= 0 && (comparator != null ? comparator.compare((Shape3D) arr[j], (Shape3D) key) < 0 : arr[j].compareTo(key) < 0)) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
    }

    /**
     * Overloaded method to sort using natural ordering.
     *
     * @param arr
     */
    public static void insertionSort(Comparable[] arr) {
        insertionSort(arr, null);
    }

    /**
     * Merge sort for an array of Comparables in descending order.
     *
     * @param arr
     * @param comparator
     */
    public static void mergeSort(Comparable[] arr, Comparator<Shape3D> comparator) {
        if (arr.length < 2) return;

        int mid = arr.length / 2;
        Comparable[] left = new Comparable[mid];
        Comparable[] right = new Comparable[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(arr, left, right, comparator);
    }

    /**
     * Overloaded method to sort using natural ordering.
     *
     * @param arr
     */
    public static void mergeSort(Comparable[] arr) {
        mergeSort(arr, null);
    }

    /**
     * Utility function to merge two arrays.
     *
     * @param arr
     * @param left
     * @param right
     * @param comparator
     */
    private static void merge(Comparable[] arr, Comparable[] left, Comparable[] right, Comparator<Shape3D> comparator) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            int comparisonResult;
            if (comparator != null) {
                comparisonResult = comparator.compare((Shape3D) left[i], (Shape3D) right[j]);
            } else {
                comparisonResult = left[i].compareTo(right[j]);
            }

            // For descending order, place the larger element
            if (comparisonResult >= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    /**
     * Quick sort for an array of Comparables in descending order.
     *
     * @param arr
     * @param comparator
     */
    public static void quickSort(Comparable[] arr, Comparator<Shape3D> comparator) {
        quickSortHelper(arr, 0, arr.length - 1, comparator);
    }

    /**
     * Overloaded method to sort using natural ordering.
     *
     * @param arr
     */
    public static void quickSort(Comparable[] arr) {
        quickSort(arr, null);
    }

    /**
     * Utility function to perform quick sort.
     *
     * @param arr
     * @param low
     * @param high
     * @param comparator
     */
    private static void quickSortHelper(Comparable[] arr, int low, int high, Comparator<Shape3D> comparator) {
        if (low < high) {
            int pi = partition(arr, low, high, comparator);

            quickSortHelper(arr, low, pi - 1, comparator);
            quickSortHelper(arr, pi + 1, high, comparator);
        }
    }

    /**
     * Utility function to partition the array.
     *
     * @param arr
     * @param low
     * @param high
     * @param comparator
     * @return
     */
    private static int partition(Comparable[] arr, int low, int high, Comparator<Shape3D> comparator) {
        Comparable pivot = arr[high];
        int i = (low - 1);  // Index of smaller element

        for (int j = low; j < high; j++) {
            int comparisonResult;
            if (comparator != null) {
                comparisonResult = comparator.compare((Shape3D) arr[j], (Shape3D) pivot);
            } else {
                comparisonResult = arr[j].compareTo(pivot);
            }

            // For descending order, place the larger element before the pivot
            if (comparisonResult >= 0) {
                i++;
                Comparable temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Comparable temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
