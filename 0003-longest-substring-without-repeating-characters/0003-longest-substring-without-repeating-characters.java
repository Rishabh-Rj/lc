class Solution {
    public int lengthOfLongestSubstring(String st) {
        Set<Character> s = new HashSet<>();
        
        int count = 0;
        int max = 0;
        int left = 0 ,right=0;
        
        while(right<st.length() ){
            
            if(s.add(st.charAt(right))){
                 count++;
                right++;
                
            }else{
                count--;
                s.remove(st.charAt(left));
                left++;
            }
            
            if(count>max){
                max=count;
            }
            
        }
        
        return max;
    }
}