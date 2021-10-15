import java.util.ArrayList;
import java.util.Collections;

public class TwoListMerge {
    static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        if(a == null && b == null) return null;
        if(a == null) return b;
        if(b == null) return a;

        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        int i = 0, j = 0;
        while(i < a.size() && j < b.size()) {
            if(a.get(i) < b.get(j)) {
                mergedList.add(a.get(i));
                i++;
            } else {
                mergedList.add(b.get(j));
                j++;
            }
        }

        if(i < a.size())
            for(int idx = i; idx < a.size(); idx++)
                mergedList.add(a.get(idx));
            
        if(j < b.size())
            for(int idx = j; idx < b.size(); idx++)
                mergedList.add(b.get(idx));

        return mergedList;
    }

    public static void main(String... arg) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();

        for(int i = 0; i < 10; i++)
            a.add(10*(10 - i));
        
        for(int i = 0; i < 5; i++)
            b.add(11*(10 - i));


        Collections.sort(a);
        Collections.sort(b);
        
        // [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
        // [66, 77, 88, 99, 110]
        for(int items: merge(a, b))
            System.out.println(items);
    }
}
