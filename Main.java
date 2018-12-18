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
                new String[]{"English"},
                null);
        if (la == 0) {
            int result = JOptionPane.showOptionDialog(
                    null,
                    "Do you want read file?",
                    "Read File",
                    0,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"Start", "Exit"},
                    "Start");
            if (result == 1) {
                T = false;
            }
            if (result == -1) {
                T = false;
            }
            if (result == 0) {
                if (result == -1) {
                    T = false;
                }
                if (result == 0) {
//                  C:\\Users\\Ali Asadi\\Desktop\\DS\\DS\\src\\test.txt
                    String Re = JOptionPane.showInputDialog(null, "Please enter path file", "Path File", JOptionPane.QUESTION_MESSAGE);
                    if (Re == null) {
                        T = false;
                    } else {
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
                                new String[]{"Show Option", "Exit"},
                                "Show Option");
                        if (res == 1 || res == -1) {
                            T = false;
                        }
                    }
                }
            }
            while (T) {
                result1 = JOptionPane.showOptionDialog(
                        null,
                        "What do you want?",
                        "Menu",
                        0,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new String[]{"Search", "Add", "Remove", "Exit"},
                        "Search");
                if (result1 == -1) {
                    break;
                }
                if (result1 == 0) {
                    String Se = JOptionPane.showInputDialog(null, "Please enter your word", "Search", JOptionPane.QUESTION_MESSAGE);
                    long t223 = System.nanoTime();
                    My.Find(Se);
                    long t224 = System.nanoTime();
                    String lisst = new String();
                    for (int i=0; i<My.list.size() ;i++){
                        lisst += My.list.get(i)+ "\n";

                    }

                    int B = JOptionPane.showOptionDialog(
                            null,

                             lisst + "\n" + "Time of find word" + "\n" + (t224 - t223),
                            "Result Search",
                            0,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            new String[]{"Back", "Exit"},
                            "Back");
                    My.list.clear();
                    lisst=null;
                    if (B == 1) {
                        T = false;
                    }
                } else if (result1 == 1) {
                    String w = JOptionPane.showInputDialog(
                            null,
                            "Please enter your word",
                            "Add Word",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (w == null) {
                        break;
                    }
                    String[] Line = w.split(" ");
                    if (Line[0].equals("function")) {
                        String ArrayType = "";
                        ArrayType += "(F ";
                        ArrayType += Line[1] + ",";
                        ArrayType += Line[3] + ")";
                        My.Insert(Line[2], ArrayType);
                    } else {
                        String ArrayType = "(V ";
                        ArrayType += Line[1] + ")";
                        My.Insert(Line[2], ArrayType);
                    }
                } else if (result1 == 2) {

                } else if (result1 == 3) {
                    T = false;
                }
            }

        }
    }

}

class Node{
    int AscciChar;
    BST BstChild;
    String Type;
    //boolean UpperCase;
    //boolean LowerCase;
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
class BST {
    Node Root;

    BST() {
        this.Root = null;
    }
    public void Add(Node NewNode) {
        if (this.Root == null) {
            this.Root = NewNode;
            return;
        }
        Node parent;
        Node q = this.Root;
        while (true) {
            parent = q;
            if (NewNode.AscciChar < q.AscciChar) {
                q = q.LeftChild;
                if (q == null) {
                    parent.LeftChild = NewNode;
                    return;
                }
            } else if (NewNode.AscciChar > q.AscciChar) {
                q = q.RightChild;
                if (q == null) {
                    parent.RightChild = NewNode;
                    return;
                }
            } else {
                break;
            }
        }
    }

    public Node Search(int Key) {
        if (this.Root == null) {
            return null;
        }
        Node q = this.Root;
        while (q != null) {
            if (Key > q.AscciChar) {
                q = q.RightChild;
            } else if (Key < q.AscciChar) {
                q = q.LeftChild;
            } else {
                return q;
            }
        }
        return null;
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
            String[] Line;
            while ((line = reader.readLine()) != null)
            {
                Line=line.split(" ");
                if(Line[0].equals("function")){
                    String ArrayType="";
                    ArrayType+="(F ";
                    ArrayType+=Line[1]+",";
                    ArrayType+=Line[3]+")";
                    this.Insert(Line[2],ArrayType);
                }
                else {
                    String ArrayType="(V ";
                    ArrayType+=Line[1]+")";
                    this.Insert(Line[2],ArrayType);
                }
            }
            reader.close();
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", path);
            e.printStackTrace();
        }
    }
    public void Insert(String Word,String ArrayType){
        Node FocusNode=this.TrieBST.Search((int) Word.charAt(0));
        if(FocusNode==null) {
            FocusNode=new Node((int) Word.charAt(0));
            TrieBST.Add(FocusNode);
        }
        BST FocusBST=FocusNode.BstChild;
        for(int i=1;i<Word.length();i++){
            FocusNode=FocusBST.Search((int) Word.charAt(i));
            if(FocusNode==null){
                FocusNode=new Node((int) Word.charAt(i));
                FocusBST.Add(FocusNode);
            }
            FocusBST=FocusNode.BstChild;
        }
        FocusNode.End=true;
        FocusNode.Type=ArrayType;
    }
    public void Find(String Word){
        Node FocusNode=this.TrieBST.Search((int) Word.charAt(0));
        if(FocusNode==null){
            return;
        }
        FocusNode=this.Move(FocusNode,Word);
        if(FocusNode!=null) {
            if (FocusNode.End) {
                this.list.add(Word);
            }
            FocusNode = FocusNode.BstChild.Root;
            if (FocusNode != null) {
                this.PreOrder(FocusNode, Word);
            }
        }
    }
    public void PreOrder(Node q,String Word){
        if(q.End){
            this.list.add(Word+(char) q.AscciChar+" "+q.Type);
        }
        Node Child=q.BstChild.Root;
        if(Child!=null){
            this.PreOrder(Child,Word+(char) q.AscciChar);
            Child=null;
        }
        if(q.RightChild!=null){
            this.PreOrder(q.RightChild,Word);
        }
        if(q.LeftChild!=null){
            this.PreOrder(q.LeftChild,Word);
        }
    }
    public void Remove(String Word){
        Node FocusNode=this.TrieBST.Search((int) Word.charAt(0));
        if(FocusNode==null){
            return;
        }
        FocusNode=this.Move(FocusNode,Word);
        if(FocusNode!=null) {
            FocusNode.End = false;
        }
    }
    public Node Move(Node FocusNode,String Word){
        BST FocusBST=FocusNode.BstChild;
        for(int i=1;i<Word.length();i++){
            FocusNode=FocusBST.Search((int) Word.charAt(i));
            if(FocusNode==null){
                return null;
            }
            FocusBST=FocusNode.BstChild;
        }
        return FocusNode;
    }
}