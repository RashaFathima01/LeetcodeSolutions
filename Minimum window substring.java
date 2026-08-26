//3.Minimum window substring 

class Solution {
    public  String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[256];
        int[] have = new int[256];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0, right = 0, count = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            have[r]++;
            if (need[r] > 0 && have[r] <= need[r]) {
                count++;
            }

            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char l = s.charAt(left);
                have[l]--;
                if (need[l] > 0 && have[l] < need[l]) {
                    count--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        Solution M = new Solution();
        M.minWindow(s,t);
        sc.close();
    }
}


