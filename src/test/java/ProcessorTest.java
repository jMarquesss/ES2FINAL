import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorTest {
    Processor p= new Processor();

    @Test
    void docMatrixBuilder() {
        assertThrows(IOException.class,
                () -> {
                    p.docMatrixBuilder(Paths.get("nonExistingFilePath.txt"));
                });
    }

    @Test
    void queryMatrixBuilder() {
        p.getWordsList().add("random");
        p.getWordsList().add("query");
        assertTrue(p.queryMatrixBuilder("random query"));
        p.getWordsList().clear();
        p.getQueryMatrix().clear();
        assertFalse(p.queryMatrixBuilder(""));

    }

    @Test
    void matrixReplacer() {
        try {
            p.docMatrixBuilder(Paths.get("test1New.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertFalse(p.matrixReplacer());
    }

    @Test
    void queryReplacer() {
        try {
            p.docMatrixBuilder(Paths.get("test1New.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.queryMatrixBuilder("ola");
        Integer cell = (int) p.getQueryMatrix().get(0);
        p.queryReplacer(p.getQueryMatrix());
        assertFalse(cell.equals(p.getQueryMatrix().get(0)));

    }

    @Test
    void grauSimRankingsBuilder() {
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