package ir.sk.algorithm.array;

import ir.sk.helper.Stopwatch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sad.kayvanfar on 1/10/2021.
 */
public class ArrayAlgorithmsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findWord() {
        boolean result = ArrayAlgorithms.findWord(new char[][]{{'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'}}, "FOAM".toCharArray());
        System.out.println(result);
    }

    @Test
    public void loopExistsInCircularArray() {
        System.out.println(ArrayAlgorithms.loopExistsInCircularArray(new int[]{1, 2, -1, 2, 2}));
        System.out.println(ArrayAlgorithms.loopExistsInCircularArray(new int[]{2, 2, -1, 2}));
        System.out.println(ArrayAlgorithms.loopExistsInCircularArray(new int[]{2, 1, -1, -2}));
    }

    @Test
    public void makeSquaresSortedArray() {
        System.out.println(Arrays.toString(ArrayAlgorithms.makeSquaresSortedArray(new int[]{-2, -1, 0, 2, 3})));
    }

    @Test
    public void naiveCountWays() {
        int n = 4;
        System.out.println(ArrayAlgorithms.naiveCountWays(n));
    }

    @Test
    public void memoizedDPCountWaysByRecursive() {
        int n = 4;
        System.out.println(ArrayAlgorithms.memoizedDPCountWaysByRecursive(n));
    }

    @Test
    public void bottomUpCountWays() {
        int n = 4;
        System.out.println(ArrayAlgorithms.bottomUpCountWays(n));
    }

    @Test
    public void magicIndexNaive() {
        System.out.println(ArrayAlgorithms.magicIndexNaive(new int[]{8,9,2,3,4}));
    }

    @Test
    public void magicIndexBinarySearch() {
        System.out.println(ArrayAlgorithms.magicIndexBinarySearch(new int[]{8,9,2,3,4}));
    }

    @Test
    public void checkPossibility() {
        int[] arr = { 10, 5, 11, 3 };
        int n = arr.length;

        if (ArrayAlgorithms.checkPossibility(arr, n))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}