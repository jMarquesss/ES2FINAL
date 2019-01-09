import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelperTest {

    @Test
    void readerWriter() {
        String oldPath="big.txt";
        String newPath="newFile.txt";
        boolean expectedResult = true;
        boolean actualResult = true;
        assertNotEquals(expectedResult, actualResult);
    }
}