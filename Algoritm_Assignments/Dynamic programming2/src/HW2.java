//학번: 22112120 이름: 서이준
import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        char [] X=scanner.nextLine().toCharArray();
        char [] Y=scanner.nextLine().toCharArray();

        findLCS(X,Y);
    }

    public static void findLCS(char[] X, char[] Y) {
        int[][] arr = new int[X.length + 1][Y.length + 1];
        for(int i=0;i<arr.length;i++){
            arr[i][0]=0;
            arr[0][i]=0;
        }
        for (int i = 1; i <=X.length ; i++) {
            for (int j = 1; j <=Y.length; j++) {
                if (X[i-1] == Y[j-1]) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
                }
            }
        }
        int index = arr[X.length][Y.length];
        char[] lcs = new char[index];
        int i = X.length;
        int j = Y.length;
        while (i > 0 && j > 0) {
            if (X[i-1] == Y[j-1]) {
                lcs[index - 1] = X[i-1];
                i--;
                j--;
                index--;
            } else if (arr[i - 1][j] >=arr[i][j - 1]) {
                i--;
            } else {
                j--;
            }

        }
        System.out.println(new String(lcs).trim());
        System.out.println(arr[X.length][Y.length]);
    }
}