import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void DFS(ArrayList<ArrayList<Integer>> arr,int start){
        int v;
        int i=0;
        arr.get(0).set(start,1);
        while(arr.get(start).size()>i){
            v=arr.get(start).get(i);
            if(arr.get(0).get(v)!=1){
                arr.get(0).set(v,1);
                DFS(arr,v);
                arr.get(0).set(0,arr.get(0).get(0)+1);
                i++;
            }
            else i++;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int computer= scanner.nextInt();
        int ring=scanner.nextInt();
        ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>count=new ArrayList<Integer>();
        for(int i=0;i<computer+1;i++){
            arr.add(i,new ArrayList<Integer>());
            count.add(i,0);
        }
        arr.remove(0);
        arr.add(0,count);
        for(int i=0; i<ring;i++){
            int x=scanner.nextInt();
            int y= scanner.nextInt();
            arr.get(x).add(y);
            arr.get(y).add(x);
        }
        DFS(arr,1);
        int virus=arr.get(0).get(0);
        System.out.println(virus);
    }
}
