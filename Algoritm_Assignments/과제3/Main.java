//학번: 22112120 이름: 서이준
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String txt=br.readLine();
        Set<String>set=new HashSet<>();
        {
            for (int i = 1; i <=txt.length(); i++) {
                for (int j = 0; j <= txt.length()-i; j++) {
                    set.add(txt.substring(j,i+j));
                }
            }
            System.out.println(set.size());
        }
    }
}
