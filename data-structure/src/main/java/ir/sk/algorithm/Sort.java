package ir.sk.algorithm;

import ir.sk.algorithm.basic.Rotation;
import ir.sk.algorithm.basic.Utils;
import ir.sk.datastructure.fundamental.tree.binarytree.MaxBinaryHeap;
import ir.sk.datastructure.fundamental.tree.binarytree.binarysearchtree.BinarySearchTree;
import ir.sk.helper.*;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/7/2017.
 */
public class Sort {

    /**
     * In bubble sort, we start at the beginning of the array and swap the first two elements if the first is greater
     * than the second. Then, we go to the next pair, and so on, continuously making sweeps of the array until it is
     * sorted. In doing so, the smaller items slowly"bubble" up to the beginning of the list.
     * <p>
     * compare and swap
     *
     * @param array
     */
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(1)")
    @InPlace
    @Stability
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int out = 0; out < n; out++) {
            for (int in = 1; in < (n - out); in++)
                if (array[in - 1] > array[in])
                    array[in] = Utils.gSwap(array[in - 1], array[in - 1] = array[in]); // swap them A[j], A[j - 1]
        }
    }


    /**
     * Selection sort is a simple sorting algorithm. This sorting algorithm is
     * an in-place comparison-based algorithm in which the list is divided into two parts,
     * the sorted part at the left end and the unsorted part at the right end. Initially,
     * the sorted part is empty and the unsorted part is the entire list.
     * The smallest element is selected from the unsorted array and swapped with the leftmost element,
     * and that element becomes a part of the sorted array.
     * This process continues moving unsorted array boundary by one element to the right.
     * <p>
     * compare and swap
     * The selection sort performs the same number of comparisons as the bubble sort.
     * but lower swap
     *
     * @param array
     */
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(1)")
    @InPlace
    @Stability(value = false)
    public static void selectionSort(int[] array) {
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < array.length - 1; i++) {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[min])
                    min = j;
            // Swap the found minimum element with the first element
            array[i] = Utils.gSwap(array[min], array[min] = array[i]); // swap them
        }
    }

    /**
     * compare and copy
     * <p>
     * an in-place comparison-based algorithm in which the list is divided into two parts,
     * the partly sorted part at the left end and the unsorted part at the right end.
     * <p>
     * a few advantages: simple implementation, efficient for small data sets,
     * more efficient than selection sort or bubble sort, does not need much memory.
     * <p>
     * Insertion sort: inserts the next element at the correct position;
     * <p>
     * Selection sort: selects the smallest element and exchange it with the current item;
     *
     * @param array
     */
    @TimeComplexity("O(n ^ 2)")
    @SpaceComplexity("O(1)")
    @InPlace
    @Stability
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            int key = array[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j] > key) {
                // using rotate by condition(array[j] > key), no swap, since shifting has better performance than swap
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    /**
     * better performance when comparing is costly for example for record data
     * using binary search instead of comparing fro finding the place of an item
     *
     * @param array
     */
    @TimeComplexity("O(n * 2)")
    @SpaceComplexity("O(1)")
    public static void binaryInsertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];

            // Find location to insert using binary search
            int loc = Math.abs(Arrays.binarySearch(array, 0, i, key) + 1);

            // Move all elements after location to create space
            // Shifting array to one location right
            Rotation.rightRotate(array, loc, i);
            // System.arraycopy(array, loc, array, loc + 1, i - loc);
            // Placing element at its correct location
            // array[loc] = key;
        }
    }

    /**
     * T(n) = 2T(n/2) + O(n)
     * Stable: Yes
     * Sorting In Place: No
     *
     * @param a
     * @param n
     */
    @TimeComplexity("O(n * Log n)")
    @SpaceComplexity("O(n)")
    public static void mergeSort(int[] a, int n) {

        // base case
        if (n < 2)
            return;

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    /**
     * @param a
     * @param l
     * @param r
     * @param left
     * @param right
     */
    private static void merge(
            int[] a, int[] l, int[] r, int left, int right) {
        IntersectionAndUnionOfTwoSortedArrays.mergeByTwoFinger(a, l, r, left, right);
    }

    /**
     * Divide-and-conquer algorithm and recursive
     * <p>
     * Sorting In Place: Yes
     *
     * @param array
     */
    @TimeComplexity("O(n * Log n)")
    @SpaceComplexity("O(1) improved over normal merge sort O(n)")
    public static void inPlaceMergeSort(int[] array) {
        // provides workspace
        int[] workSpace = new int[array.length];
        recMergeSort(array, workSpace, 0, array.length - 1);
    }

    private static void recMergeSort(int[] array, int[] workSpace, int lowerBound,
                                     int upperBound) {
        if (lowerBound == upperBound)            // if range is 1,
            return;                              // no use sorting
        else {                                    // find midpoint
            int mid = (lowerBound + upperBound) / 2;
            // sort low half
            recMergeSort(array, workSpace, lowerBound, mid);
            // sort high half
            recMergeSort(array, workSpace, mid + 1, upperBound);
            // merge them
            merge(array, workSpace, lowerBound, mid + 1, upperBound);
        }  // end else
    }  // end recMergeSort()

    //-----------------------------------------------------------
    private static void merge(int[] array, int[] workSpace, int lowPtr,
                              int highPtr, int upperBound) {
        int j = 0;                             // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;       // # of items

        while (lowPtr <= mid && highPtr <= upperBound)
            if (array[lowPtr] < array[highPtr])
                workSpace[j++] = array[lowPtr++];
            else
                workSpace[j++] = array[highPtr++];

        while (lowPtr <= mid)
            workSpace[j++] = array[lowPtr++];

        while (highPtr <= upperBound)
            workSpace[j++] = array[highPtr++];

        for (j = 0; j < n; j++)
            array[lowerBound + j] = workSpace[j];
    }

    /**
     * In quick sort we pick a random element and partition the array, such that all numbers that are less than the
     * partitioning element come before all elements that are greater than it. The partitioning can be performed
     * efficiently through a series of swaps
     *
     * @param arr
     * @param left
     * @param right
     */
    @TimeComplexity("O(n * Log n)")
    @SpaceComplexity("O(1)")
    @InPlace
    @Stability(false)
    @DivideAndConquer
    public static void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) { // Sort left half
            quickSort(arr, left, index - 1);
        }
        if (index < right) { // Sort right half
            quickSort(arr, index, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2]; // Pick pivot point
        while (left <= right) {
            // Find element on left that should be on right
            while (arr[left] < pivot) left++;

            // Find element on right that should be on left
            while (arr[right] > pivot) right--;

            // Swap elements, and move left and right indices
            if (left <= right) {
                Utils.gSwap(arr[left], arr[left] = arr[right]); // swaps elements
                left++;
                right--;
            }
        }
        return left;
    }

    /**
     * 1. Build Max Heap from unordered array;
     * 2. Find maximum element A[1];
     * 3. Swap elements A[n] and A[1]:
     * now max element is at the end of the array!
     * 4. Discard node n from heap
     * (by decrementing heap-size variable)
     * 5. New root may violate max heap property, but its
     * children are max heaps. Run max_heapify to fix this.
     * 6. Go to Step 2 unless heap is empty
     * <p>
     * Sorting In Place: Yes
     *
     * @param array
     */
    @TimeComplexity("O(n * Log n)")
    @SpaceComplexity("O(1)")
    @InPlace
    public static void heapSort(int[] array) {

        // Build heap (rearrange array)
        MaxBinaryHeap heap = new MaxBinaryHeap(array);
        heap.buildMaxHeap();

        // One by one extract an element from heap
        for (int i = heap.getHeapSize(); i > 0; i--) {
            // Move current root to end, swap
            array[0] = Utils.gSwap(array[i], array[i] = array[0]);
            heap.setHeapSize(heap.getHeapSize() - 1);
            // call max heapify on the reduced heap
            heap.heapifyDown(0);
        }
    }

    /**
     * Tree sort is a sorting algorithm that is based on Binary Search Tree data structure
     * It first creates a binary search tree from the elements of the input list or array
     * and then performs an in-order traversal on the created binary search tree to get the elements in sorted order.
     * <p>
     * Sorting In Place: No
     *
     * @param array
     */
    @TimeComplexity("O(n * log h) - h is height o tree and if tree is balanced(AVL,Red Black Tree,...), h = Log n")
    @SpaceComplexity("O(n) heapsort is better")
    public static void treeSort(int[] array) {
        // Build BST
        BinarySearchTree bst = new BinarySearchTree();

        // fill it
        for (int value : array) {
            bst.add(value);
        }

        // traverse in-order
        bst.traverseInOrder(bst.getRoot());
    }

    /**
     * It works by counting the number of objects having distinct key values (kind of hashing).
     * Then doing some arithmetic to calculate the position of each object in the output sequence.
     * <p>
     * we could not sort the elements if we have negative numbers in it. Because there are no negative array indices.
     * <p>
     * Time Complexity: O(n + k) + O(n) = O(2n + k) = O(n + k) where n is the number of elements in input array and k is the range of input.
     * Auxiliary Space: O(n+k)
     * <p>
     * Counting sort is efficient if the range of input data is not significantly greater than the number of objects to be sorted. Consider the situation where the input sequence is between range 1 to 10K and the data is 10, 5, 10K, 5K.
     * It is not a comparison based sorting. It running time complexity is O(n) with space proportional to the range of data.
     * It is often used as a sub-routine to another sorting algorithm like radix sort.
     * Counting sort uses a partial hashing to count the occurrence of the data object in O(1).
     * Counting sort can be extended to work for negative inputs also.
     *
     * @param array
     */
    @TimeComplexity("O(n + k) + O(n) = O(2n + k) = O(n + k) where n is the number of elements in input array and k is the range of input.")
    @SpaceComplexity("nO(n + k)")
    public static void countingSort(int[] array) {
        int n = array.length;
        int max = Arrays.stream(array).max().getAsInt();

        // The output character array that will have sorted arr
        int output[] = new int[n];

        // Create a count array to store count of inidividul
        // items and initialize count array as 0
        // Frequency Array
        int count[] = new int[max + 1];

        // store count of each character
        for (int i = 0; i < n; ++i)
            ++count[array[i]];

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i <= max; ++i)
            count[i] += count[i - 1];

        // Build the output array
        // To make it stable we are operating in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            --count[array[i]];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; ++i)
            array[i] = output[i];
    }

    /**
     * Counting sort which takes negative numbers as well
     * We find the minimum element and we will store count of that minimum element at zero index.
     *
     * @param arr
     */
    @TimeComplexity("O(n + k) + O(n) = O(2n + k) = O(n + k) where n is the number of elements in input array and k is the range of input.")
    @SpaceComplexity("nO(n + k)")
    public static void countingSortWithNegative(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        int range = max - min + 1;

        int count[] = new int[range];
        int output[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    /**
     * @param input
     * @param k
     */
    private static void verifyPreconditions(int[] input, int k) {
        if (input == null) {
            throw new IllegalArgumentException("Input is required");
        }

        int min = IntStream.of(input).min().getAsInt();
        int max = IntStream.of(input).max().getAsInt();

        if (min < 0 || max > k) {
            throw new IllegalArgumentException("The input numbers should be between zero and " + k);
        }
    }

    /**
     * The radix sorting algorithm is an integer sorting algorithm, that sorts by grouping numbers by their individual digits (or by their radix).
     * It uses each radix/digit as a key, and implements counting sort or bucket sort under the hood in order to do the work of sorting.
     *
     * @param numbers
     */
    @TimeComplexity("O(kn) where n is the number of elements in input array and k represented this number of digits of maximum value.")
    @SpaceComplexity("nO(n + k)")
    @Stability
    public static void radixSort(int numbers[]) {
        int maximumNumber = findMaximumNumberIn(numbers);

        int numberOfDigits = calculateNumberOfDigitsIn(maximumNumber);

        int placeValue = 1;

        while (numberOfDigits-- > 0) {
            applyCountingSortOn(numbers, placeValue);
            placeValue *= 10;
        }
    }

    private static void applyCountingSortOn(int[] numbers, int placeValue) {
        int range = 10; // radix or the base

        int length = numbers.length;
        // Using count sort
        int[] frequency = new int[range];
        int[] sortedValues = new int[length];

        for (int i = 0; i < length; i++) {
            int digit = (numbers[i] / placeValue) % range;
            frequency[digit]++;
        }

        for (int i = 1; i < range; i++) {
            frequency[i] += frequency[i - 1];
        }

        for (int i = length - 1; i >= 0; i--) {
            int digit = (numbers[i] / placeValue) % range;
            sortedValues[frequency[digit] - 1] = numbers[i];
            frequency[digit]--;
        }

        System.arraycopy(sortedValues, 0, numbers, 0, length);
    }

    private static int calculateNumberOfDigitsIn(int number) {
        return (int) Math.log10(number) + 1; // valid only if number > 0
    }

    private static int findMaximumNumberIn(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }
}
