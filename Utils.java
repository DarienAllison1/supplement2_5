
import java.util.HashSet;

public class Utils {

    /**
     * Determines if a 2D matrix is a magic square.
     *
     * @param matrix The 2D matrix to check.
     * @return true if the matrix is a magic square; false otherwise.
     */
    public static boolean isMagicSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }

        int n = matrix.length;
        int magicSum = 0;
        for (int num : matrix[0]) {
            magicSum += num;
        }

        // Check rows
        for (int[] row : matrix) {
            int rowSum = 0;
            for (int num : row) {
                rowSum += num;
            }
            if (rowSum != magicSum) return false;
        }

        // Check columns
        for (int col = 0; col < n; col++) {
            int colSum = 0;
            for (int row = 0; row < n; row++) {
                colSum += matrix[row][col];
            }
            if (colSum != magicSum) return false;
        }

        // Check diagonals
        int diagonal1 = 0, diagonal2 = 0;
        for (int i = 0; i < n; i++) {
            diagonal1 += matrix[i][i];
            diagonal2 += matrix[i][n - i - 1];
        }
        return diagonal1 == magicSum && diagonal2 == magicSum;
    }

    /**
     * Counts the number of unique subarrays with a given target sum.
     *
     * @param array     The array to search.
     * @param targetSum The target sum for subarrays.
     * @return The number of unique subarrays with the given sum.
     */
    public static int countUniqueSubarrays(int[] array, int targetSum) {
        if (array == null || array.length == 0) return 0;

        HashSet<String> uniqueSubarrays = new HashSet<>();
        int n = array.length;

        for (int start = 0; start < n; start++) {
            int sum = 0;
            StringBuilder subarray = new StringBuilder();
            for (int end = start; end < n; end++) {
                sum += array[end];
                subarray.append(array[end]).append(",");
                if (sum == targetSum) {
                    uniqueSubarrays.add(subarray.toString());
                }
            }
        }
        return uniqueSubarrays.size();
    }

    /**
     * Finds the longest palindromic substring in a string.
     *
     * @param s The input string.
     * @return The longest palindromic substring.
     */
    public static String longestPalindromicSubstring(String s) {
        if (s == null || s.isEmpty()) return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
