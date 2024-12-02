import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void testIsMagicSquare_ValidMagicSquare() {
        int[][] magicSquare = {
            {8, 1, 6},
            {3, 5, 7},
            {4, 9, 2}
        };
        assertTrue(Utils.isMagicSquare(magicSquare));
    }

    @Test
    void testIsMagicSquare_InvalidMagicSquare() {
        int[][] notMagicSquare = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        assertFalse(Utils.isMagicSquare(notMagicSquare));
    }

    @Test
    void testIsMagicSquare_NullMatrix() {
        assertFalse(Utils.isMagicSquare(null));
    }

    @Test
    void testCountUniqueSubarrays_TargetSum() {
        int[] array = {1, 2, 3, 4, 2};
        assertEquals(2, Utils.countUniqueSubarrays(array, 5));
    }

    @Test
    void testCountUniqueSubarrays_NoSubarrays() {
        int[] array = {1, 1, 1};
        assertEquals(0, Utils.countUniqueSubarrays(array, 10));
    }

    @Test
    void testCountUniqueSubarrays_EmptyArray() {
        int[] array = {};
        assertEquals(0, Utils.countUniqueSubarrays(array, 5));
    }

    @Test
    void testLongestPalindromicSubstring() {
        assertEquals("aba", Utils.longestPalindromicSubstring("abacdfgdcaba"));
        assertEquals("a", Utils.longestPalindromicSubstring("abc"));
        assertEquals("", Utils.longestPalindromicSubstring(""));
    }
}
