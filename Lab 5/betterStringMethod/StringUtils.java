@FunctionalInterface
interface TwoStringPredicate {
    boolean isBetter(String s1, String s2);
}

public class StringUtils {
    public static String betterString(String s1, String s2, TwoStringPredicate predicate) {
        return predicate.isBetter(s1, s2) ? s1 : s2;
    }

    public static void main(String[] args) {
        String string1 = "Mahmoud";
        String string2 = "Free";

        String longer = betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
        System.out.println("Longer String: " + longer);

        String first = betterString(string1, string2, (s1, s2) -> true);
        System.out.println("First String: " + first);
    }
}