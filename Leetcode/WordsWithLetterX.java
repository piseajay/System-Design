import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordsWithLetterX {

    public static void main(String[] args) {
        System.out.println(findWordsContaining(new String[]{"abc", "bcd", "aaaa", "cbc"}, 'a'));
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                list.add(i);
            }
        }
        return list;
    }
}
