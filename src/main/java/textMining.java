import java.nio.file.Paths;
import java.util.Scanner;

class textMining {
    public static void main(String[] args) throws Exception {
        Processor p = new Processor();
        Scanner sc= new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("\n\n### Text Mining App ###");
            System.out.println("\n =========================");
            System.out.println("1 - Inserir novo documento");
            System.out.println("2 - Inserir query de pesquisa");
            System.out.println("0 - Sair");
            System.out.println("=========================\n");
            opcao = sc.nextInt();
            System.out.print("\n");
            switch (opcao) {
                case 1:
                    String path= sc.nextLine();
                    p.docMatrixBuilder(Paths.get(path));
                    break;
                case 2:
                    String query= sc.nextLine();
                    p.queryMatrixBuilder(query);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 0);
    }
}