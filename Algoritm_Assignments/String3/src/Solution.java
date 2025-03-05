//학번: 22112120 이름: 서이준
import java.util.Stack;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Integer>score=new Stack<>();
        String[] dart=dartResult.split("");
        for(int i=0;i< dart.length;i++){
            if(dart[i].matches("[1]")&& dart[i+1].matches("[0]")){
                score.push(10);
                i++;
            }
            else if(dart[i].matches("[0-9]")){
                score.push(Integer.parseInt(dart[i]));
            }
            switch (dart[i]){
                case "D":
                    int num=score.pop();
                    score.push(num*num);
                    break;
                case "T":
                    num=score.pop();
                    score.push(num*num*num);
                    break;
                case "*":
                    if(score.size()>1){
                        num=score.pop();
                        int prenum=score.pop();
                        score.push(prenum*2);
                        score.push(num*2);
                    }
                    else{
                        num=score.pop();
                        score.push(num*2);
                    }
                    break;
                case "#":
                    num=score.pop();
                    score.push(-num);
                    break;
            }
        }
        for(int i=0;i<score.size();i++){
            answer+=score.get(i);
        }
        return answer;
    }
}