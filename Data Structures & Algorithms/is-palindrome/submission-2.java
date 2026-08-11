class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int l = 0;
        int r = n-1;
        int a = 'a';
        int nine = '9';
        while (l < r) {
            if (!Character.isLetterOrDigit(arr[l])) {
                l++;
                continue;
            } 
            if (!Character.isLetterOrDigit(arr[r])) {
                r--;
                continue;
            }
            if (Character.toLowerCase(arr[l]) != Character.toLowerCase(arr[r])) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
