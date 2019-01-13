import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;


public class Processor {
    private Helper helper = new Helper();
    private LinkedHashSet<String> wordsList = new LinkedHashSet<>();
    private int docList;
    private ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    private ArrayList<ArrayList<Double>> transformedMatrix = new ArrayList<>();
    private ArrayList queryMatrix;
    private Map<String, Double> grauSimList = new HashMap<>();

    public Processor() {
        queryMatrix = new ArrayList();
    }

    void docMatrixBuilder(Path myPath) throws IOException {
        String contents = new String(Files.readAllBytes(myPath), StandardCharsets.UTF_8);
        ArrayList<Celula> docMatrix = new ArrayList<>();
        ArrayList<String> docWordsList = new ArrayList<>(Arrays.asList(contents.split("\\W+")));
        wordsList.addAll(Arrays.asList(contents.split("\\W+")));
        for (int i = 0; i < wordsList.size(); i++) {
            docMatrix.add(new Celula((String) wordsList.toArray()[i]));
        }
        occurrencesArrayBuilder(docMatrix, docWordsList);
        ArrayList<Integer> OccurrencesArray = new ArrayList<>();
        for (Celula temp : docMatrix) OccurrencesArray.add(temp.getNumber());
        matrix.add(OccurrencesArray);
        docList = matrix.size();
    }

    private void occurrencesArrayBuilder(ArrayList<Celula> docMatrix, ArrayList<String> docWordsList) {
        for (int i = 0; i < wordsList.size(); i++)
            for (String aDocWordsList : docWordsList) {
                Celula temp = docMatrix.get(i);
                if (temp.getWord().equals(aDocWordsList)) {
                    temp.setNumber(temp.getNumber() + 1);
                }
            }
    }


    boolean queryMatrixBuilder(String query) {
        ArrayList<Celula> queryArray = new ArrayList<>();
        ArrayList<String> queryWordsList = new ArrayList<>(Arrays.asList(query.split("\\W+")));
        for (int i = 0; i < wordsList.size(); i++) {
            queryArray.add(new Celula((String) wordsList.toArray()[i]));
        }
        occurrencesArrayBuilder(queryArray, queryWordsList);

        for (Celula temp : queryArray) {
            queryMatrix.add(temp.getNumber());
        }
        return queryMatrix.size() > 0;
    }

    boolean matrixReplacer() {
        for (ArrayList<Integer> aMatrix : matrix) {
            ArrayList<Double> line = new ArrayList<>();
            for (int i = 0; i < aMatrix.size(); i++) line.add(i, valueTransformer(aMatrix.get(i), i));
            transformedMatrix.add(line);
        }
        return transformedMatrix.get(0).get(0).equals(matrix.get(0).get(0));
    }

    private double valueTransformer(int startValue, int column) {
        int contador = 0;
        for (ArrayList<Integer> aMatrix : matrix) {
            try {
                if (aMatrix.get(column) != null && aMatrix.get(column) != 0) {
                    contador++;
                }
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
        return ((double) startValue * 1 + Math.log10((double) docList / (double) contador));
    }

    void queryReplacer(ArrayList list) {
        for (int i = 0; i < list.size(); i++) list.set(i, valueTransformer((Integer) list.get(i), i));
    }

    private double grauSimCalculator(int linha) {
        double grauSim, somatorio1 = 0, somatorio2 = 0, somatorio3 = 0;
        for (int i = 0; i < transformedMatrix.get(linha).size(); i++) {
            double temp1 = transformedMatrix.get(linha).get(i);
            double temp2 = (double) queryMatrix.get(i);
            somatorio1 = somatorio1 + (temp1 * temp2);
            somatorio2 = somatorio2 + (temp1 * temp1);
            somatorio3 = somatorio3 + (temp2 * temp2);
        }
        grauSim = somatorio1 / (Math.sqrt(somatorio2) * Math.sqrt(somatorio3));
        return grauSim;
    }

    void grauSimRankingsBuilder() {
        for (int i = 0; i < docList; i++) grauSimList.put("Documento " + (i + 1), grauSimCalculator(i));
        grauSimList = grauSimList.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    LinkedHashSet<String> getWordsList() { return wordsList; }

    Map<String, Double> getGrauSimList() {
        return grauSimList;
    }

    ArrayList<ArrayList<Double>> getTransformedMatrix() {
        return transformedMatrix;
    }

    ArrayList getQueryMatrix() {
        return queryMatrix;
    }


    ArrayList<ArrayList<Integer>> getMatrix() {
        return matrix;
    }

    Helper getHelper() {
        return helper;
    }

}
