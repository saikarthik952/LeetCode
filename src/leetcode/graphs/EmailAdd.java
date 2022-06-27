package leetcode.graphs;

import java.util.HashSet;

public class EmailAdd {
    public static void main(String[] args) {
        String[] strings = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        final HashSet<String> stringHashSet = new HashSet<>();
        for (int i = 0; i < strings.length; i++) {
            String[] split = strings[i].split("@");
            String x  = split[0].replaceAll("\\.", "");
            String[] index = x.split("\\+");
            stringHashSet.add(String.join("@", new String[]{index[0], split[1]}));
        }
        System.out.println(stringHashSet);
    }
}
