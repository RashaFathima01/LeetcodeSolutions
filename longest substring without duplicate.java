//2.longest substring without duplicate characters.

 import java.util.Scanner;
class Solution {
    public static int lengthOfLongestSubstring(String s)  {
        int[] lastIndex = new int[256];
        for (int i = 0; i < 256; i++) lastIndex[i] = -1;

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if (lastIndex[current] >= left) {
                left = lastIndex[current] + 1;
            }
            lastIndex[current] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
        sc.close();
    }
}

