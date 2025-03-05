import java.util.ArrayList;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        ArrayList<Character> arr = new ArrayList<>(number.length()-k);
        StringBuilder max = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            while (!arr.isEmpty() && arr.get(arr.size() - 1) < number.charAt(i) && k > 0) {
                arr.remove(arr.size() - 1);
                k--;
            }
            arr.add(number.charAt(i));
        }

        while (k > 0) {
            arr.remove(arr.size() - 1);
            k--;
        }

        for (char ch : arr) {
            max.append(ch);
        }

        answer = max.toString();
        return answer;
    }

}
