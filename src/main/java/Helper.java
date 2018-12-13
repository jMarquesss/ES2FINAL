import java.io.*;

public class Helper {

    public static Boolean readerReplacerWriter(String filePath, String newFilePath) {
        return writer(replacer(reader(filePath)), newFilePath);
    }

    public static String replacer(String oldStr) {
        return oldStr.replaceAll("[0-9,.!?\\-_\n]", "");
    }

    public static String reader(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public static Boolean writer(String str, String filePath) {
        try (PrintWriter out = new PrintWriter(filePath)) {
            out.print(str);
        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }
}


