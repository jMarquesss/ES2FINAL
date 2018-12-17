import java.io.*;
import java.io.File;
import java.io.FileReader;

class Helper {
    
    private static String replacer(String oldStr) {
            return oldStr.replaceAll("[0-9,.!?\\-_\n/]", "");
    }

    private static void fileReseter(String filePath){
        File f = new File(filePath);
        if(f.exists()) {
            f.delete();
        }
    }

    public static Boolean readerWriter(String oldFilePath, String newFilePath) {
        String tempFile="tempFile.txt";

        try {
            FileWriter writer = new FileWriter(tempFile, false);
            FileReader fileReader = new FileReader(oldFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            fileReseter(newFilePath);

            int lineNumber=0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String newLine =replacer(line);
                boolean isEmpty=newLine.isEmpty();
                if(!isEmpty) {
                    writer.write(newLine+"\r\n");
                }
                lineNumber++;
            }
            writer.write(Integer.toString(lineNumber));

            bufferedReader.close();
            writer.close();

            File tempoFile = new File(tempFile);
            File newFile = new File(newFilePath);
            tempoFile.renameTo(newFile);
            tempoFile.delete();

        }catch (Exception e){
            System.out.println("Falhou");
            return false;
        }
        return true;
    }
}


