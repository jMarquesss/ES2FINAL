import java.io.*;
import java.io.File;
import java.io.FileReader;

public final class Helper {
    
    private String replacer(String oldStr) {
            return oldStr.replaceAll("[0-9,.!?\\-_\n/]", "");
    }

    private boolean fileReseter(String filePath){
        File f = new File(filePath);
        if(f.exists()) {
            return f.delete();
        }
        return true;
    }

    public Boolean readerWriter(String oldFilePath) {
        try {
            FileWriter writer = new FileWriter("tempFile.txt", false);
            FileReader fileReader = new FileReader(oldFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String newLine = this.replacer(line);
                if(!newLine.isEmpty()) {
                    writer.write(newLine+"\r\n");
                }
            }

            bufferedReader.close();
            writer.close();


            String newPath=oldFilePath.substring(0,oldFilePath.lastIndexOf("."));
            newPath= newPath + "New.txt";
            fileReseter(newPath);
            File tempFile = new File("tempFile.txt");
            File newFile = new File(newPath);
            tempFile.renameTo(newFile);
            tempFile.delete();

        }catch (IOException e){
            System.out.println("File not found.");
            return false;
        }
        return true;
    }
}