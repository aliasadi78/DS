import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        String file_name = "C:\\Users\\Ali Asadi\\Desktop\\DS\\DS\\src\\test.txt";
//        long t1 = System.currentTimeMillis();
//        long t11 = System.nanoTime();
        try {
            ReadFile file = new ReadFile(file_name);
//            String[] aryLines = file.OpenFile();
//
//            for (int i=0; i < aryLines.length; i++ ) {
//                System.out.println( aryLines[i] ) ;
//            }
            ReadFile.readLines();
//            System.out.println(ReadFile.readLines());

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
//        long t2 = System.currentTimeMillis();
//        long t22 = System.nanoTime();
//        System.out.println(t2 - t1);
//        System.out.println(t22 - t11);
    }
}
