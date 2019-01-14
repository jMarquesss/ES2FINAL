import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelperTest {
    private Helper h = new Helper();

    @Test
    void readerWriter() {
        assertEquals(false, h.readerWriter("nonExistingFile.txt"));
    }

    @Test
    void readerWriter2() {
        assertEquals(true, h.readerWriter("test1.txt"));
    }
}