public class Main {
    public static void main(String[] args) {
        // Example usage of Utils methods
        int[][] magicSquare = {
            {9, 3, 7},
            {4, 2, 8},
            {4, 9, 2}
        };
        System.out.println("Is magic square: " + Utils.isMagicSquare(magicSquare));

        int[] array = {1, 2, 3, 4, 2};
        System.out.println("Count of unique subarrays: " + Utils.countUniqueSubarrays(array, 5));

        String str = "abacdfgdcaba";
        System.out.println("Longest palindromic substring: " + Utils.longestPalindromicSubstring(str));
    }
}
 
