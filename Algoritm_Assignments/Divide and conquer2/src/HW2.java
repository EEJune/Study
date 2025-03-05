//학번: 22112120 이름: 서이준
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,k;
        List<List<Integer>> result;

        System.out.print("정수 n과 k를 입력? ");
        n= scanner.nextInt();
        k=scanner.nextInt();

        result=Devide(n,k);
        for(List<Integer>show:result){
            System.out.print(show+" ");
        }
    }
    public static List<List<Integer>> Devide(int n, int k){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        Subset(n,k,1,result,arr);

        return result;
    }
    public static void Subset(int n,int k,int start,List<List<Integer>>result,List<Integer> arr){
        if(arr.size()==k){
            result.add(new ArrayList<>(arr));
            return;
        }

        for(int i=start;i<=n;i++){
            arr.add(i);
            Subset(n,k,i+1,result,arr);
            arr.remove(arr.size()-1);
        }
    }
}
