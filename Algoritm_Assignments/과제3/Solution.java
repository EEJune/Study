//학번: 22112120 이름: 서이준
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i< phone_book.length;i++){
            map.put(phone_book[i],i);
        }
        for(int i=0;i<phone_book.length && answer;i++){
            for(int j=1;j<phone_book[i].length();j++){
                if(map.containsKey(phone_book[i].substring(0,j))){
                    answer=false;
                    break;
                }
            }
        }
        return answer;
    }
}