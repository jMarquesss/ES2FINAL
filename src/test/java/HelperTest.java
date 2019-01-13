import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HelperTest {
    Helper h= new Helper();

    @Test
    void readerWriter() {
        assertEquals(false, h.readerWriter("nonExistingFile.txt"));
    }

    @Test
    void readerWriter2() {
        assertEquals(true, h.readerWriter("test1.txt"));}
}