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

    }

    @Test
    void matrixReplacer() {
    }

    @Test
    void queryReplacer() {
    }

    @Test
    void grauSimRankingsBuilder() {
    }

    @Test
    void getGrauSimList() {
    }

    @Test
    void getTransformedMatrix() {
    }

    @Test
    void getQueryMatrix() {
    }

    @Test
    void getMatrix() {
    }

    @Test
    void getHelper() {
    }
}