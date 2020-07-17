package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/10/2020.
 */
public class MultiplicationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void nativeMultiply() {
        int[] a = new int[]{4, 3, 2, 1};
        int[] b = new int[]{1, 2, 3, 4};

        int[] expectedValue = new int[]{4,1,1,2,3,3,5,0};
        long startTime = System.nanoTime();
        int[] result = Multiplication.nativeMultiply(a, b, 10);
        long endTime = System.nanoTime();
        System.out.println("time duration for Multiplication.nativeMultiply by n: " + a.length + " m: " + b.length + " = " + (endTime - startTime) + " nano");
        Assert.assertArrayEquals(expectedValue, result);
    }

    @Test
    public void karatsubaMultiplyByBigInteger() {
        BigInteger n = new BigInteger("1234");
        BigInteger m = new BigInteger("4321");
        long expectedValue = 5332114;
        long startTime = System.nanoTime();
        BigInteger result = Multiplication.karatsubaMultiplyByBigInteger(n, m);
        long endTime = System.nanoTime();
        System.out.println("time duration for Multiplication.karatsubaMultiplyByBigInteger by n: " + n + " m: " + m + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result.longValue());
    }


    @Test
    public void karatsuba2ByBigInteger() {
        BigInteger n = new BigInteger("1234");
        BigInteger m = new BigInteger("4321");
        long expectedValue = 5332114;
        long startTime = System.nanoTime();
        BigInteger result = Multiplication.karatsuba2ByBigInteger(n, m);
        long endTime = System.nanoTime();
        System.out.println("time duration for Multiplication.karatsuba2ByBigInteger by n: " + n + " m: " + m + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result.longValue());
    }

    @Test
    public void karatsuba2() {
        long n = 1234;
        long m = 4321;
        long expectedValue = 5332114;
        long startTime = System.nanoTime();
        long result = Multiplication.karatsuba2(n, m);
        long endTime = System.nanoTime();
        System.out.println("time duration for Multiplication.karatsubaMultiplyByBigInteger by n: " + n + " m: " + m + " = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);
    }
}