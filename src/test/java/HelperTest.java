import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelperTest {
    private Helper h = new Helper();

    @Test
    void test1() {
        assertEquals(false, h.readerWriter("nonExistingFile.txt"));
    }

    @Test
    void test2() {
        assertEquals(true, h.readerWriter("test1.txt"));
    }
}