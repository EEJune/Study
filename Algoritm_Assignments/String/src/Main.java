//학번: 22112120 이름: 서이준
import java.io.*;
import java.util.Comparator;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Integer.parseInt(br.readLine());
        String[] text=new String[n];

        for(int i=0;i<n;i++){
            text[i]=br.readLine();
        }
        Arrays.sort(text, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }
                else{
                    return o1.length()-o2.length();
                }
            }
        });
        bw.write(text[0]);
        bw.newLine();
        for(int i=1;i<n;i++){
            if(!text[i].equals(text[i-1])){
                bw.write(text[i]);
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}