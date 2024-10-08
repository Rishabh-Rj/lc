class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        findSubsets(nums, 0, new ArrayList<>());
        return res;
    }

    public void findSubsets(int nums[], int index, List<Integer> sublist) {
        // Base case
        if (index == nums.length) {
            res.add(new ArrayList<>(sublist));
            return;
        }

        // Pick
        sublist.add(nums[index]);
        findSubsets(nums, index + 1, sublist);

        // Backtrack: remove the last added element
        sublist.remove(sublist.size() - 1);

        // No pick
        findSubsets(nums, index + 1, sublist);
    }
}