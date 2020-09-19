package ir.sk.algorithm;

/**
 * Created by sad.kayvanfar on 9/6/2020.
 */
public class BitManipulation {

    public static int repeatedArithmeticShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>= 1; // Arithmetic shift by 1
        }
        return x;
    }

    public static int repeatedLogicalShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>>= 1; // Logical shift by 1
        }
        return x;
    }

    /**
     * This method shifts 1 over by i bits, creating a value that looks like 00010000. By performing an AND with
     * num, we clear all bits other than the bit at bit i. Finally, we compare that to 0. If that new value is not zero,
     * then bit i must have a 1. Otherwise, bit is a 0.
     *
     * @param num
     * @param i
     * @return boolean value of selected bit
     */
    public static boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }

    /**
     * Set Bit shifts 1 over byi bits, creating a value like 00010000. By performing an OR with num, only the
     * value at bit i will change. All other bits of the mask are zero and will not affect num.
     *
     * @param num
     * @param i
     * @return set boolean value in selected bit
     */
    public static int setBit(int num, int i) {
        return num | (1 << i);
    }

    /**
     * This method operates in almost the reverse of setBi t. First, we create a number like 11101111 by creating
     * the reverse of it (00010000) and negating it. Then, we perform an AND with num. This will clear the ith bit
     * and leave the remainder unchanged.
     *
     * @param num
     * @param i
     * @return
     */
    public static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    /**
     * To clear all bits from the most significant bit through i (inclusive), we create a mask with a 1 at the ith bit (1
     * << i). Then, we subtract 1 from it, giving us a sequence of 0s followed by i ls. We then AND our number
     * with this mask to leave just the last i bits.
     *
     * @param num
     * @param i
     * @return
     */
    public static int clearBitsMSBthroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    /**
     * To clear all bits from i through 0 (inclusive), we take a sequence of all ls (which is -1) and shift it left by i
     * + 1 bits. This gives us a sequence of 1 s (in the most significant bits) followed by i 0 bits.
     *
     * @param num
     * @param i
     * @return
     */
    public static int clearBitsithrough0(int num, int i) {
        int mask = (-1 << (i + 1));
        return num & mask;
    }

    /**
     * To set the ith bit to a valuev, we first clear the bit at position i by using a mask that looks like 11101111.
     * Then, we shift the intended value, v, left by i bits. This will create a number with bit i equal to v and all
     * other bits equal to 0. Finally, we OR these two numbers, updating the ith bit if v is 1 and leaving it as 0
     * otherwise.
     *
     * @param num
     * @param i
     * @param bitisl
     * @return
     */
    public static int updateBit(int num, int i, boolean bitisl) {
        int value = bitisl ? 1 : 0;
        int mask = ~(1 << i);
        return (num & mask) | (value << i);
    }
}
