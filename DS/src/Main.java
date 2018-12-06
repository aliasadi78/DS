import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
            String file_name = "C:\\Users\\Ali Asadi\\Desktop\\DS\\DS\\src\\test.txt";

            try {
                ReadFile file = new ReadFile(file_name);
                String[] aryLines = file.OpenFile();

                for (int i=0; i < aryLines.length; i++ ) {
                    System.out.println( aryLines[i] ) ;
                }
                System.out.println(ReadFile.readLines());
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
    }
}
