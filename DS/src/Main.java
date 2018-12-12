import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.BufferedReader;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        Trie My = new Trie();
        boolean T = true;
        boolean R = true;
        int result1 = 0;
        int la = JOptionPane.showOptionDialog(
                null,
                "",
                "Menu",
                0,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"English", "فارسی"},
                null);
        if(la == 0){
            int result = JOptionPane.showOptionDialog(
                    null,
                    "Do you want read file?",
                    "Read File",
                    0,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"Start", "Exit"},
                    "Start");
            if (result == 1){
                T = false;
            }if (result == -1){
                T = false;
            }
            if (result == 0){
                if (result == -1){
                    T = false;
                }
                if (result == 0) {
//                  C:\\Users\\Ali Asadi\\Desktop\\DS\\DS\\src\\test.txt
                    String Re = JOptionPane.showInputDialog(null, "Please enter path file", "Path File", JOptionPane.QUESTION_MESSAGE);
                    if (Re == null){
                        T = false;
                    }
                    else {
                        long t1 = System.nanoTime();
                        My.ReadFile(Re);
                        long t2 = System.nanoTime();
                        int res = JOptionPane.showOptionDialog(
                                null,
                                "Time of read file: \n" + (t2 - t1),
                                "Time of read file",
                                0,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                new String[] {"Show Option" , "Exit"},
                                "Show Option");
                        if (res == 1 || res == -1){
                            T = false;
                        }
                    }
                }
            }
            while ( T ) {
                result1 = JOptionPane.showOptionDialog(
                        null,
                        "What do you want?",
                        "Menu",
                        0,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new String[]{"Search", "Add", "Remove", "Exit"},
                        "Search");
                if (result1 == -1){
                    break;
                }
                if (result1 == 0) {
                    long t223 = System.nanoTime();
                    My.Find(JOptionPane.showInputDialog(null, "Please enter your word", "Search", JOptionPane.QUESTION_MESSAGE));
                    long t224 = System.nanoTime();
                    int B = JOptionPane.showOptionDialog(
                            null,
                            My.list + "\n" + "Time of find word" + "\n" + (t224 - t223),
                            "Result Search",
                            0,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            new String[] {"Back", "Exit"},
                            "Back");
                    My.list.clear();
                    if (B == 1){
                        T = false;
                    }
                }
                else if (result1 == 1){
                    String w =JOptionPane.showInputDialog(
                            null,
                            "Please enter your word",
                            "Add Word",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (w == null){
                        break;
                    }
                    My.Insert(w);

                }
                else if (result1 == 2){

                }
                else if (result1 == 3){
                    T = false;
                }
            }
        }
        else if (la == 1){
            int result = JOptionPane.showOptionDialog(
                    null,
                    "آیا می خواهید برنامه فایل را بخواند؟ \n برای شروع کلیلک کنید.",
                    "خواندن فایل",
                    0,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"شروع", "خروج"},
                    "شروع");
            if (result == 1){
                T = false;
            }if (result == -1){
                T = false;
            }
            if (result == 0){
                if (result == -1){
                    T = false;
                }
                if (result == 0) {
//                  c
                    String Re = JOptionPane.showInputDialog(null, "لطفا مسیر فایل مورد نظر خود را وارد کنید", "مسیر فایل", JOptionPane.QUESTION_MESSAGE);
                    if (Re == null){
                        T = false;
                    }
                    else {
                        long t1 = System.nanoTime();
                        My.ReadFile(Re);
                        long t2 = System.nanoTime();
                        int res = JOptionPane.showOptionDialog(
                                null,
                                "مدت زمان خواندن فایل: \n" + (t2 - t1),
                                "مدت زمان خواندن فایل",
                                0,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                new String[] {"نمایش گزینه های برنامه" , "خروج"},
                                "نمایش گزینه های برنامه");
                        if (res == 1 || res == -1){
                            T = false;
                        }
                    }
                }
            }
            while ( T ) {
                result1 = JOptionPane.showOptionDialog(
                        null,
                        "عملیات مورد نظر خود را انتخاب کنید.",
                        "منو",
                        0,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new String[]{"جست و جو", "اضافه کردن", "حذف کردن", "خروج"},
                        "جست و جو");
                if (result1 == -1){
                    break;
                }
                if (result1 == 0) {
                    String A = JOptionPane.showInputDialog(null, "لطقا کلمه مورد نظر خود را وارد کنید.", "جست و جو", JOptionPane.QUESTION_MESSAGE);
                    long t1 = System.nanoTime();
                    My.Find(A);
                    long t2 = System.nanoTime();
                    int B = JOptionPane.showOptionDialog(
                            null,
                            My.list + "\n" + "مدت زمان پیدا کردن کلمه" + "\n" + (t2 - t1),
                            "نتایج جست و جو",
                            0,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            new String[] {"برگشت", "خروج"},
                            "برگشت");
                    My.list.clear();
                    if (B == 1){
                        T = false;
                    }
                }
                else if (result1 == 1){
                    String w =JOptionPane.showInputDialog(
                            null,
                            "لطفا کلمه مورد نظر خود را وارد کنید",
                            "افزودن کلمه",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (w == null){
                        break;
                    }
                    My.Insert(w);

                }
                else if (result1 == 2){

                }
                else if (result1 == 3){
                    T = false;
                }
            }
        }
    }
}

class Node{
    int AscciChar;
    BST BstChild;
    boolean UpperCase;
    boolean LowerCase;
    boolean EndUpper;
//    boolean EndLower;
    boolean End;
    Node LeftChild;
    Node RightChild;
    Node(int Key){
        this.AscciChar=Key;
        this.End=false;
        this.BstChild=new BST();
    }
}
class BST{
    Node Root;
    int Size;
    BST(){
        this.Size=0;
        this.Root=null;
    }
    public void Add(Node NewNode){
        if(this.Root==null){
            this.Root=NewNode;
            return;
        }
        Node parent;
        Node q=this.Root;
        while (true){
            parent=q;
            if(NewNode.AscciChar<q.AscciChar){
                q=q.LeftChild;
                if(q==null){
                    parent.LeftChild=NewNode;
                    this.Size+=1;
                    return;
                }
            }
            else if(NewNode.AscciChar>q.AscciChar){
                q=q.RightChild;
                if(q==null){
                    parent.RightChild=NewNode;
                    this.Size+=1;
                    return;
                }
            }
            else{
                break;
            }
        }
    }
    public Node Search(int Key){
        if(this.Root==null){
            return null;
        }
        Node q=this.Root;
        while (q!=null){
            if(Key>q.AscciChar){
                q=q.RightChild;
            }
            else if(Key< q.AscciChar){
                q=q.LeftChild;
            }
            else {
                return q;
            }
        }
        return null;
    }
    public void Inorder(Node v){
        if(v.LeftChild!=null){
            Inorder(v.LeftChild);
        }
        System.out.print(v.AscciChar+" ");
        if(v.RightChild!=null){
            Inorder(v.RightChild);
        }
    }
}
class Trie{
    List list=new ArrayList();
    BST TrieBST=new BST();
    public void ReadFile(String path){
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null)
            {
                this.Insert(line);
            }
            reader.close();
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", path);
            e.printStackTrace();
        }
    }
    public void Insert(String Word){
        Node FocusNode=this.TrieBST.Search((int) Word.charAt(0));
        if(FocusNode==null) {
            FocusNode=new Node((int) Word.charAt(0));
            TrieBST.Add(FocusNode);
        }
        for(int i=1;i<Word.length();i++){
            BST FocusBST=FocusNode.BstChild;
            // if(FocusBST==null){ }
            FocusNode=FocusBST.Search((int) Word.charAt(i));
            if(FocusNode==null){
                FocusNode=new Node((int) Word.charAt(i));
                FocusBST.Add(FocusNode);
            }
        }
        FocusNode.End=true;
    }
    public void Find(String Word){
        Node FocusNode=this.TrieBST.Search((int) Word.charAt(0));
        if(FocusNode==null){
            return;
        }
        for(int i=1;i<Word.length();i++){
            BST FocusBST=FocusNode.BstChild;
            FocusNode=FocusBST.Search((int) Word.charAt(i));
            if(FocusNode==null){
                return;
            }
        }
        if(FocusNode.End){
            this.list.add(Word);
        }
        FocusNode=FocusNode.BstChild.Root;
        if(FocusNode!=null) {
            this.PreOrder(FocusNode, Word);
        }
    }
    public void PreOrder(Node q,String Word){
        if(q.End){
            this.list.add(Word+(char) q.AscciChar);
        }
        Node Child=q.BstChild.Root;
        if(Child!=null){
            this.PreOrder(Child,Word+(char) q.AscciChar);
        }
        if(q.RightChild!=null){
            this.PreOrder(q.RightChild,Word);
        }
        if(q.LeftChild!=null){
            this.PreOrder(q.LeftChild,Word);
        }
    }
}

//import java.io.*;
//import java.awt.*;
//import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//public class Main {
//
////    public static class PanelExample {
////        PanelExample() {
////            JFrame f = new JFrame("Panel Example");
////            JPanel panel = new JPanel();
////            panel.setBounds(5, 5, 475, 40);
////            panel.setBackground(Color.BLUE);
////            JButton b1 = new JButton("Read File");
////            b1.setBounds(50, 50, 100, 400);
////            b1.setBackground(Color.white);
////            JDialog d1 = new JDialog();
////            panel.add(b1);
////
////
////            f.add(panel);
////
////            f.setSize(500, 500);
////            f.setLayout(null);
////            f.setVisible(true);
////        }
////    }
//
//    public static void main(String[] args) throws IOException {
////        new PanelExample();
//        String file_name = "C:\\Users\\Ali Asadi\\Desktop\\DS\\DS\\src\\test.txt";
//        long t1 = System.currentTimeMillis();
//        long t11 = System.nanoTime();
//        try {
//            ReadFile file = new ReadFile(file_name);
//            String[] aryLines = file.OpenFile();
//
//            for (int i=0; i < aryLines.length; i++ ) {
//                System.out.println( aryLines[i] ) ;
//            }
//            ReadFile.readLines();
//            System.out.println(ReadFile.readLines());
//
//        }
//        catch(IOException e){
//            System.out.println(e.getMessage());
//        }
//        long t2 = System.currentTimeMillis();
//        long t22 = System.nanoTime();
//        System.out.println(t2 - t1);
//        System.out.println(t22 - t11);
//    }
//}
//