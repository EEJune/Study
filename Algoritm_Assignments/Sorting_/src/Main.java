import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(reader.readLine());
        ArrayList<Integer> coordinate=new ArrayList<>();
        Set<Integer> sort=new TreeSet<>();
        Map<Integer,Integer> save=new HashMap<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(st.nextToken());
            coordinate.add(num);
            sort.add(coordinate.get(i));
        }
        Iterator<Integer> itr = sort.iterator();
        int idx=0;
        while(itr.hasNext()){
            save.put(itr.next(),idx++);
        }
        for(int i=0;i<size;i++){
            sb.append(save.get(coordinate.get(i)));
            sb.append(" ");
        }
        System.out.println(sb);
    }
}