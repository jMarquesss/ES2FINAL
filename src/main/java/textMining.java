import java.util.Scanner;

class textMining {
    public static void main(String[] args) {
        Processor p = new Processor();
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n\n### Text Mining App ###");
            System.out.println("\n=========================");
            System.out.println("1 - Inserir novo documento");
            System.out.println("2 - Inserir query de pesquisa");
            System.out.println("3 - Lista de todos os documentos ordenados por similaridade");
            System.out.println("4 - Lista de todos os documento com similaridade superior a um valor a inserir");
            System.out.println("5 - Lista dos documentos ordenador por similaridade com o numero de documentos demonstrados a inserir");
            System.out.println("0 - Sair");
            System.out.println("=========================\n");
            System.out.print("Opcao: ");
            System.out.print("\n");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    p.menuDocAdder();
                    break;
                case 2:
                    p.menuQueryAdder();
                    break;
                case 3:
                    p.grauSimRankingsBuilder();
                    System.out.println(p.getGrauSimList().toString());
                    break;
                case 4:
                    p.menuGrauSimRankingMinValue();
                    break;
                case 5:
                    p.menuGrauSimRankingMaxDoc();
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