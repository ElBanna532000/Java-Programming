package checkAlphabets;

import java.lang.Character;
public class main {
    public static void main(String[] args) {
        checkString check = (str) -> {
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isLetter(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        };
        if(check.checkStr("FallFree")){
            System.out.println("Contains only alphabets");
        }else{
            System.out.println("Contains non alphabets");
        }

        if(check.checkStr("FallFree123")){
            System.out.println("Contains only alphabets");
        }else{
            System.out.println("Contains non alphabets");
        }
    }
}
