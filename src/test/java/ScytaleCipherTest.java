import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScytaleCipherTest {

    @Test
    void getNumberOfColumns_givenValidTextLengths_returnsRoundedUpQuotient() {
        assertEquals(4, ScytaleCipher.getNumberOfColumns(21, 6));
        assertEquals(7, ScytaleCipher.getNumberOfColumns(28, 4));
        assertEquals(1, ScytaleCipher.getNumberOfColumns(5, 10));
    }

    @Test
    void initializeRoll_givenPositiveAmountsNumRowsAndColumns_initializesWithWhiteSpaces() {
        int rows = 3;
        int cols = 4;
        char[][] roll = ScytaleCipher.initializeRoll(rows, cols);

        assertEquals(rows, roll.length);
        assertEquals(cols, roll[0].length);
        
        for (char[] row : roll) {
            for (char c : row) {
                assertEquals(' ', c, "Roll should be initialized with spaces");
            }
        }
    }

    @Test
    void fillRoll_givenValidMessage_fillsRollWithCharacters() {
        char[][] roll = new char[2][3];
        String message = "ABCDE";
        ScytaleCipher.fillRoll(roll, message);

        assertEquals('A', roll[0][0]);
        assertEquals('B', roll[0][1]);
        assertEquals('C', roll[0][2]);
        assertEquals('D', roll[1][0]);
        assertEquals('E', roll[1][1]);
    }

    @Test
    void extractCipherFromRoll_givenFilledRoll_returnsCipherString() {
        char[][] roll = {
            {'A', 'B', 'C'},
            {'D', 'E', ' '}
        };

        String result = ScytaleCipher.extractCipherFromRoll(roll);
        assertEquals("ADBEC", result);
    }

    @Test
    void cipherIntegration_givenValidInput_returnsCipherText() {
        assertAll("Cipher should correctly encrypt various messages",
            () -> assertEquals("IOOIEAIVTSMNEHHSLWTA", ScytaleCipher.cipher("IAMSOINLOVEWITHTESHA", 5)),
            () -> assertEquals("T vyete sh lheoi  ffil esom.", ScytaleCipher.cipher("Tesh is the love of my life.", 4)),
            () -> assertEquals("Mrt eTytsn e   obshbf uheeoot.aarn", ScytaleCipher.cipher("My heart beats for no one but Tesh.", 6)),
            () -> assertEquals("Ms t euhSaC biclo aryed", ScytaleCipher.cipher("Mubashir Scytale Code", 6)),
            () -> assertEquals("M  baai aaEirmn tndteag tda  z", ScytaleCipher.cipher("Matt and Edabit are amazing", 8)),
            () -> assertEquals("", ScytaleCipher.cipher("", 54))
        );
    }
}
