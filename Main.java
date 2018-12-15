import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.ref.SoftReference;
public class Main {
    public static void main(String[] args) {
        Node t1=new Node(22);
        SoftReference<Node> softRef = new SoftReference<Node>(t1);
        t1=null;
        System.out.println(softRef.get().AscciChar);
//        Trie My=new Trie();
//        long t1=System.currentTimeMillis();
//        My.ReadFile("C:\\Users\\DS_Project100.txt");
//        long t2=System.currentTimeMillis();
//        System.out.println(t2-t1);
//        long t12=System.nanoTime();
//        My.Find("am");
//        long t22=System.nanoTime();
//        System.out.println(t22-t12);
//        My.Remove("amazeb");
//        My.Find("amaz");
//        System.out.println(My.list);
    }
}
class Node{
    int AscciChar;
    BST BstChild;
    //ArrayList Type;
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
class BST{
    Node Root;
    BST(){
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
                    q=null;
                    parent=null;
                    return;
                }
            }
            else if(NewNode.AscciChar>q.AscciChar){
                q=q.RightChild;
                if(q==null){
                    parent.RightChild=NewNode;
                    q=null;
                    parent=null;
                    return;
                }
            }
            else{
                q=null;
                parent=null;
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
//    public void Inorder(Node v){
//        if(v.LeftChild!=null){
//            Inorder(v.LeftChild);
//        }
//        System.out.print(v.AscciChar+" ");
//        if(v.RightChild!=null){
//            Inorder(v.RightChild);
//        }
//    }
}
class Trie{
    List list=new ArrayList();
    BST TrieBST=new BST();
    public void ReadFile(String path){
        //int counter=0;
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            String[] Line;
            while ((line = reader.readLine()) != null)
            {
//                if(counter%1000000==0){
//                    System.gc();
//                }
                Line=line.split(" ");
                if(Line[0]=="function"){
//                    ArrayList ArrayType=new ArrayList();
//                    ArrayType.add(Line[0]);
//                    ArrayType.add(Line[1]);
//                    ArrayType.add(Line[3]);
                    this.Insert(Line[2]);
                    line=null;
                    Line=null;
                }
                else {
//                    ArrayList ArrayType=new ArrayList();
//                    ArrayType.add(Line[0]);
//                    ArrayType.add(Line[1]);
                      this.Insert(Line[2]);
                    line=null;
                    Line=null;
                }
                //counter+=1;
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
        BST FocusBST=FocusNode.BstChild;
        for(int i=1;i<Word.length();i++){
            FocusNode=FocusBST.Search((int) Word.charAt(i));
            if(FocusNode==null){
                FocusNode=new Node((int) Word.charAt(i));
                FocusBST.Add(FocusNode);
            }
            FocusBST=FocusNode.BstChild;
        }
        FocusBST=null;
        FocusNode.End=true;
        //FocusNode.Type=ArrayType;
        FocusNode=null;
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
        FocusNode=null;
    }
    public void PreOrder(Node q,String Word){
        if(q.End){
            this.list.add(Word+(char) q.AscciChar);
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
        FocusNode=null;
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
        FocusBST=null;
        return FocusNode;
    }
}
