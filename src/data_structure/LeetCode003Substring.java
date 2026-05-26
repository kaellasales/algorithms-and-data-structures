package data_structure;
import java.util.HashMap;
public class LeetCode003Substring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;

        HashMap<Character, Integer> window = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right); // charAt() retorna o caractere no índice especificado em uma string.
            while(window.containsKey(c)){
                window.remove(s.charAt(left));
                left++;
            }
            window.put(c, right);
            max = Math.max(max, window.size());
        }
        return max;
    }

    public static void main(String[] args) {

        LeetCode003Substring s = new LeetCode003Substring();

        int result = s.lengthOfLongestSubstring("abcabcbb");

        System.out.println(result);
    }
}
//complexidade O(n)

