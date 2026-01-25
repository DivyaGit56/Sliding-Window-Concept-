class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> mp = new HashMap<>();

        // store frequency of t
        for (char ch : t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0;
        int count = mp.size();  // number of unique chars to match
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (j < s.length()) {
            char ch = s.charAt(j);

            if (mp.containsKey(ch)) {
                mp.put(ch, mp.get(ch) - 1);
                if (mp.get(ch) == 0)
                    count--;
            }

            // valid window
            while (count == 0) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }

                char left = s.charAt(i);
                if (mp.containsKey(left)) {
                    mp.put(left, mp.get(left) + 1);
                    if (mp.get(left) > 0)
                        count++;
                }
                i++;
            }
            j++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
