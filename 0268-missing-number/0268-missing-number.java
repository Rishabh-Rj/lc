class Solution {
    public int missingNumber(int[] nums) {

        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hmap.put(nums[i], i);

        }
        int temp=0;
        for(int i =0;i<=nums.length;i++){
            if (!hmap.containsKey(i)){
                temp= i;
            }
        } 
        
        return temp;
        }
       
    }
