class Solution {
    public int lengthOfLongestSubstring(String s) {   
    int left = 0  , right = 0; 
    int maxLen = 0;
    HashSet<Character> set =new HashSet<>();
    while(right<s.length()){
        char c = s.charAt(right);
        if(set.add(c)){ // first time character add in set -->true
            maxLen = Math.max(maxLen , right-left+1);
            right++;
        }else{
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
        }
    }
    return maxLen;
    }
}