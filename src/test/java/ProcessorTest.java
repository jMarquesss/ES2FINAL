import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorTest {
    private Processor p = new Processor();

    @Test
    void test3() {
        assertThrows(IOException.class,
                () -> p.docMatrixBuilder(Paths.get("nonExistingFilePath.txt")));
    }

    @Test
    void test4() {
        try {
            assertTrue(p.docMatrixBuilder(Paths.get("test1.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test5() {
        assertFalse(p.queryMatrixBuilder(""));

    }

    @Test
    void test6() {
        p.getWordsList().add("random");
        p.getWordsList().add("query");
        assertTrue(p.queryMatrixBuilder("random query"));
    }

    @Test
    void test7() {
        try {
            p.docMatrixBuilder(Paths.get("test1New.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer cell = p.getMatrix().get(0).get(0);
        p.matrixReplacer();
        assertNotEquals(cell, p.getTransformedMatrix().get(0).get(0));
    }

    @Test
    void test8() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> p.matrixReplacer());
    }

    @Test
    void test9() {
        try {
            p.docMatrixBuilder(Paths.get("test1New.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.queryMatrixBuilder("ola");
        Integer cell = (int) p.getQueryMatrix().get(0);
        p.queryReplacer(p.getQueryMatrix());
        assertNotEquals(cell, p.getQueryMatrix().get(0));
    }


    @Test
    void test10() {
        try {
            p.docMatrixBuilder(Paths.get("test1New.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.queryMatrixBuilder("ola");
        p.queryReplacer(p.getQueryMatrix());
        p.matrixReplacer();
        int size = p.getGrauSimList().size();
        p.grauSimRankingsBuilder();
        assertNotEquals(size, p.getGrauSimList().size());
    }
}