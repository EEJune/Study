//학번: 22112120 이름: 서이준
import java.util.Scanner;
public class Solution {
    static int[] answer = new int[2];
    public void divide(int[][]arr,int start_x, int start_y,int dividePoint){
        if(check(arr,start_x,start_y,dividePoint,arr[start_x][start_y])){
            answer[arr[start_x][start_y]]++;
            return;
        }
        divide(arr,start_x,start_y,dividePoint/2);
        divide(arr,start_x+(dividePoint/2),start_y,dividePoint/2);
        divide(arr,start_x,start_y+(dividePoint/2),dividePoint/2);
        divide(arr,start_x+(dividePoint/2),start_y+(dividePoint/2),dividePoint/2);

    }
    public boolean check(int[][]arr,int start_x,int start_y,int dividePoint,int checking){
        for(int i=start_x;i<start_x+dividePoint;i++){
            for(int j=start_y;j<start_y+dividePoint;j++){
                if(arr[i][j]!=checking) return false;
            }
        }
        return true;
    }
    public int[] solution(int[][] arr) {
        int dividePoint=arr[0].length;
        divide(arr,0,0,dividePoint);
        return answer;
    }
}