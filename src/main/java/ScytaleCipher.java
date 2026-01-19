import java.util.Arrays;

public class ScytaleCipher {

    public static String cipher(String message, int nSlide) {

        int nCol = getNumberOfColumns(message.length(), nSlide);

        char[][] grid = initializeGrid(nSlide, nCol);

        fillGrid(grid, message);

        return extractCipherFromGrid(grid);
    }

    public static int getNumberOfColumns(int textLength, int nSlide) {
        return Math.ceilDiv(textLength, nSlide);
    }

    public static char[][] initializeGrid(int rows, int cols) {
        char[][] roll = new char[rows][cols];
        for(char[] charArray: roll)
            Arrays.fill(charArray, ' ');
        return roll;
    }

    public static void fillGrid(char[][] roll, String message) {

        int n = roll.length;
        int m = roll[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i * m + j >= message.length()) break;
                roll[i][j] = message.charAt(i * m + j);
            }
        }
    }

    public static String extractCipherFromGrid(char[][] roll) {

        int n = roll[0].length;

        StringBuilder cipherText = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for (char[] chars : roll) {
                cipherText.append(chars[i]);
            }
        }

        return cipherText.toString().trim();
    }
}