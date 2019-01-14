import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class IntegrationTest {
    @Test
    public static void main(String[] args) throws IOException {
        Processor p= new Processor();
        p.getHelper().readerWriter("test1.txt");
        p.docMatrixBuilder(Paths.get("test1New.txt"));
        p.getHelper().readerWriter("test2.txt");
        p.docMatrixBuilder(Paths.get("test2New.txt"));
        p.getHelper().readerWriter("test3.txt");
        p.docMatrixBuilder(Paths.get("test3New.txt"));
        System.out.println(p.getMatrix().toString());
        p.matrixReplacer();
        System.out.println(p.getTransformedMatrix().toString());
        p.queryMatrixBuilder("ola amigos");
        System.out.println(p.getQueryMatrix());
        p.queryReplacer(p.getQueryMatrix());
        System.out.println((p.getQueryMatrix()));
        p.grauSimRankingsBuilder();
        System.out.println(p.getGrauSimList().toString());
        //System.out.println(p.grauSimRankingMaxDoc());
        System.out.println(p.graSimRankingMinValue());

    }
}
