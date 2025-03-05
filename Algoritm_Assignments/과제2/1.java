//학번: 22112120 이름: 서이준
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static class Node{
        int num;
        Node left,right;

        Node(int num){
            this.num=num;
        }
        Node(int num,Node left,Node right){
            this.num=num;
            this.left=left;
            this.right=right;
        }
        void insert(int n){
            if(n<this.num){
                if(this.left==null){
                    this.left=new Node(n);
                }
                else this.left.insert(n);
            } else{
                if(this.right==null){
                    this.right=new Node(n);
                }
                else this.right.insert(n);
            }
        }
    }
    static void postOrder(Node root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.num);
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num;
        try {
            Node root = new Node(Integer.parseInt(br.readLine()));
            while (true) {
                num=br.readLine();
                if(num==null || num.equals("")) break;
                root.insert(Integer.parseInt(num));
            }
            postOrder(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}