import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class CountWords{

    public static void main(String... arg) {
        Map<String, Integer> newMap = new HashMap<String, Integer>();
        String str = "I love you! Love you! Love    you";

        StringTokenizer strTok = new StringTokenizer(str, " !");
        while (strTok.hasMoreTokens()) {
            str = strTok.nextToken();

            if(newMap.putIfAbsent(str, 1) != null)
                newMap.put(str, newMap.get(str) + 1);
            
        }

        System.out.println(newMap);
    }
}
