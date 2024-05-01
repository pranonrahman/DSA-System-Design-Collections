package leetcodeProblems;

/**
 * @author raian.rahman
 * @since 5/1/24
 */
public class ReversePrefixOfWord {

    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder("");

        for(char character: word.toCharArray()) {
            sb.insert(0, character);

            if(character == ch) {
                return sb.toString() + word.substring(sb.length());
            }
        }

        return word;
    }
}
