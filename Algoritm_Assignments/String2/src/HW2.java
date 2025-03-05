//학번: 22112120 이름: 서이준
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        List<String> result = new ArrayList<>();
        IP(0, ip, result, 0, "");
        for (String possible_ip : result) {
            System.out.println(possible_ip);
        }
    }

    static void IP(int start, String s, List<String> result, int segment, String current) {
        if (start == s.length() && segment == 4) {
            result.add(current.substring(1));
            return;
        }

        if (start == s.length() || segment == 4) {
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;
            String part = s.substring(start, start + len);
            int value = Integer.parseInt(part);
            if (value >= 0 && value <= 255 && (part.equals("0") || !part.startsWith("0"))) {
                IP(start + len, s, result, segment + 1, current + "." + part);
            }
        }
    }
}
