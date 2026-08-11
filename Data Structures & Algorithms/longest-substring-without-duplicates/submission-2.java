class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> posMap = new HashMap<>();
        int result = 0;

        while (r < s.length()) {
            if (posMap.containsKey(s.charAt(r))) {
                l = Math.max(l, posMap.get(s.charAt(r)) + 1);
            }

            result = Math.max(result, r-l+1);
            posMap.put(s.charAt(r), r);
            r++;
        }

        return result;        
    }
}
