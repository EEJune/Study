// 학번: 22112120 이름: 서이준
import java.util.*;

public class Solution {
    public static int[] solution(int [] numbers){
        ArrayList<Integer> arrayList=new ArrayList<>();
        for(int i=0;i<numbers.length-1;i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (!arrayList.contains(numbers[i] + numbers[j])) {
                    arrayList.add(numbers[i] + numbers[j]);
                }
            }
        }
        Collections.sort(arrayList);
        int []answer=new int[arrayList.size()];
        for(int i=0;i< arrayList.size();i++){
            answer[i]=arrayList.get(i);
        }
        return answer;
    }
}
