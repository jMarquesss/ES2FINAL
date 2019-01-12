import java.nio.file.Paths;

class textMining {
    public static void main(String[] args) throws Exception {
        Processor p = new Processor();
        p.getHelper().readerWriter("test1.txt");
        p.docMatrixBuilder(Paths.get("test1New.txt"));
        p.getHelper().readerWriter("test2.txt");
        p.docMatrixBuilder(Paths.get("test2New.txt"));
        p.getHelper().readerWriter ("test3.txt");
        p.docMatrixBuilder(Paths.get("test3New.txt"));
        System.out.println("linha doc 1: " + p.getMatrix().get(0).toString());
        System.out.println("linha doc 2: " + p.getMatrix().get(1).toString());
        System.out.println("linha doc 3: " + p.getMatrix().get(2).toString());
        p.matrixReplacer();
        System.out.println("linha doc 1 depois tranformaçao: " +p.getTransformedMatrix().get(0).toString());
        System.out.println("linha doc 2 depois tranformaçao: " +p.getTransformedMatrix().get(1).toString());
        System.out.println("linha doc 3 depois tranformaçao: " +p.getTransformedMatrix().get(2).toString());
        p.queryMatrixBuilder("ola amigos tudo bem convosco");
        System.out.println("linha do query: " + p.getQueryMatrix().toString());
        p.queryReplacer(p.getQueryMatrix());
        System.out.println("linha do query depois tranformaçao: " +p.getQueryMatrix().toString());
        p.grauSimRankingsBuilder();
        System.out.println(p.getGrauSimList().toString());

    }
}