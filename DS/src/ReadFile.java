import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;

public class ReadFile {
    private static String path;
    public ReadFile(String file_path){
        path = file_path;
    }

    public String[] OpenFile() throws IOException{
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);

        int numberOfLines = readLines();
        String[] textData = new String[numberOfLines];


        for ( int i = 0; i < numberOfLines; i++) {
            textData[i] = textReader.readLine();
        }
        textReader.close( );
        return textData;
    }

    public static int readLines() throws IOException{
        FileReader file_to_read = new FileReader(path);
        BufferedReader bf = new BufferedReader(file_to_read);

        String aline;
        int numberOfLines = 0;
        while ((aline = bf.readLine()) != null ){
            numberOfLines++;
        }
        bf.close();

        return numberOfLines;
    }
}
