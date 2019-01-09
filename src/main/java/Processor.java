import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Processor {
    private Helper helper= new Helper();
    private ArrayList wordsList= new ArrayList();
    private ArrayList docLilst= new ArrayList();
    private ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
    

    public boolean docMatrixBuilder(Path myPath) throws IOException {
        String contents = new String(Files.readAllBytes(myPath), StandardCharsets.UTF_8);
        wordsList.addAll(Arrays.asList(contents.split("\\W+")));
        Map<String, Integer> docMatrix = new HashMap<>();
        for(int i=0;i<wordsList.size();i++) {
            if(!docMatrix.containsKey(wordsList.get(i).toString()))
                docMatrix.put(wordsList.get(i).toString(), 1);
            else
                docMatrix.put(wordsList.get(i).toString(), docMatrix.get(wordsList.get(i).toString()) + 1);
        }

        ArrayList OccurrencesArray= new ArrayList();
        for (Integer value: docMatrix.values()) {
            OccurrencesArray.add(value);
        }

        matrix.add(OccurrencesArray);
        return true;
    }

    public ArrayList getWordsList() {
        return wordsList;
    }

    public void setWordsList(ArrayList wordsList) {
        this.wordsList = wordsList;
    }

    public ArrayList getDocLilst() {
        return docLilst;
    }

    public void setDocLilst(ArrayList docLilst) {
        this.docLilst = docLilst;
    }

    public ArrayList<ArrayList<Integer>> getMatrix() {
        return matrix;
    }

    public void setMatrix(ArrayList<ArrayList<Integer>> matrix) {
        this.matrix = matrix;
    }

    public Helper getHelper() {
        return helper;
    }

    public void setHelper(Helper helper) {
        this.helper = helper;
    }
}
