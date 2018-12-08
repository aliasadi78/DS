import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
public class Main {
    public static void main(String[] args) {
        Trie My=new Trie();
        My.ReadFile("C:\\Users\\Ali Asadi\\Desktop\\DS\\DS\\src\\test.txt");
        My.Insert("amazing");
        My.Insert("amazon");
        My.Insert("amazer");
        My.Insert("amazeb");
        My.Find("sal");
        System.out.println(My.list);
    }
}
class Node{
    int AscciChar;
    BST BstChild;
    // boolean UpperCase;
    // boolean LowerCase;
    //boolean EndUpper;
    //boolean EndLower;
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
