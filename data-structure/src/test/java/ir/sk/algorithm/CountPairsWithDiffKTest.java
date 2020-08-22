package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 8/22/2020.
 */
public class CountPairsWithDiffKTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void countPairsWithDiffKNative() {
        int arr[] = { 1, 5, 3, 4, 2 };
        int expectedValue = 2;
        Assert.assertEquals(expectedValue, CountPairsWithDiffK.countPairsWithDiffKNative(arr, 3));
    }

    @Test
    public void countPairsWithDiffK() {
        int arr[] = { 1, 5, 3, 4, 2 };
        int expectedValue = 2;
        Assert.assertEquals(expectedValue, CountPairsWithDiffK.countPairsWithDiffKNative(arr, 3));
    }
}