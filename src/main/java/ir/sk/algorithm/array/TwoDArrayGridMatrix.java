package ir.sk.algorithm.array;

import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.BruteForce;

/**
 * 2D Array-Grid-Matrix algorithms
 * Created by sad.kayvanfar on 7/25/2021.
 */
public class TwoDArrayGridMatrix {

    /**
     * Given a 2D matrix of characters and a target word, write a function
     * that returns whether the word can be found in the matrix by going left-to-right, or up-to-down.
     * <p>
     * String str = 'FOAM'
     * const matrix = [
     * ['F', 'A', 'C', 'I'],
     * ['O', 'B', 'Q', 'P'],
     * ['A', 'N', 'O', 'B'],
     * ['M', 'A', 'S', 'S']
     * ]
     *
     * @param matrix
     * @param world
     * @return
     */
    @BruteForce
    @TimeComplexity("O(n^2)")
    public static boolean findWord(char[][] matrix, char[] world) {
        for (int i = 0; i < matrix.length; i++) {
            boolean founded = true;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != world[j]) {
                    founded = false;
                    break;
                }
            }
            if (founded)
                return founded;
        }

        for (int j = 0; j < matrix[0].length; j++) {
            boolean founded = true;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] != world[i]) {
                    founded = false;
                    break;
                }
            }
            if (founded)
                return founded;
        }

        return false;
    }
}
