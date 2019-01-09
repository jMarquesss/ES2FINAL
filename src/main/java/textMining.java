import java.nio.file.Path;
import java.nio.file.Paths;

class textMining {
    public static void main(String[] args) throws Exception {
      Processor p = new Processor();
      p.getHelper().readerWriter("oi.txt");
      p.docMatrixBuilder(Paths.get("oiNew.txt"));
      p.getHelper().readerWriter("big.txt");
      p.docMatrixBuilder(Paths.get("ola.txt"));
      System.out.println(p.getMatrix().toString());
    }
}