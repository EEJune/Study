import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int min=routes[0][1];
        answer++;
        for(int i=1;i<routes.length;i++){
            if(routes[i][0]>min){
                answer++;
                min=routes[i][1];
            }
        }
        return answer;
    }

}