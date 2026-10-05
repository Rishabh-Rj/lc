class Solution {
    public int totalFruit(int[] s) {
         HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int k=2;
        int maxLength = 0;
        for (int right = 0; right < s.length; right++) {
            int num = s[right];
            map.put(num, map.getOrDefault(num, 0) + 1);
            while (map.size() > k) {
                int leftnum = s[left];
                map.put(leftnum, map.get(leftnum) - 1);
                if (map.get(leftnum) == 0) {
                    map.remove(leftnum);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}