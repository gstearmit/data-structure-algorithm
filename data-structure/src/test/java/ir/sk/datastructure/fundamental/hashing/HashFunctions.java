package ir.sk.datastructure.fundamental.hashing;

/**
 * Created by sad.keyvanfar on 7/6/2020.
 */
public class HashFunctions {

    /**
     * @param key
     * @param tableSize
     * @return
     */
    public static int division(int key, int tableSize) {
        return key % tableSize;
    }

    /**
     * @param key
     * @param tableSize
     * @return
     */
    public static int multiplication(int key, int tableSize) {
        int k = 10;
        return (int) (tableSize * (k * key % 1));
    }
}
