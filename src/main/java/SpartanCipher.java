import java.util.Arrays;

public class SpartanCipher {

    public static String cipher(String message, int nSlide) {


        int nCol = getNumberOfColumns(message.length(), nSlide);

        char[][] roll = initializeRoll(nSlide, nCol);

        fillRoll(roll, message);

        StringBuilder cipherText = new StringBuilder();
        for(int i = 0; i < nCol; i++) {
            for(int j = 0; j < nSlide; j++) {
                cipherText.append(roll[j][i]);
            }
        }

        return cipherText.toString().trim();
    }

    public static int getNumberOfColumns(int textLength, int nSlide) {
        return Math.ceilDiv(textLength, nSlide);
    }

    public static char[][] initializeRoll(int rows, int cols) {
        char[][] roll = new char[rows][cols];
        for(char[] charArray: roll)
            Arrays.fill(charArray, ' ');
        return roll;
    }

    public static void fillRoll(char[][] roll, String message) {

        int n = roll.length;
        int m = roll[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i * m + j >= message.length()) break;
                roll[i][j] = message.charAt(i * m + j);
            }
        }
    }



    void main(String[] args) {
        System.out.println(cipher("Mubashir Scytale Code", 6));
        System.out.println(cipher("Tesh is the love of my life.", 4));
    }
}