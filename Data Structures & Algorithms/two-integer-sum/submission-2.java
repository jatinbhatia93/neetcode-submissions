class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i=0; i< nums.length; i++) {
            int diff = target - nums[i];
            System.out.println(diff + " " + map.containsKey(diff));
            if (map.containsKey(diff) && map.get(diff) != i) {
                int a = i;
                int b = map.get(diff);
                return new int[]{Math.min(a,b), Math.max(a,b)};
            }
        }
        return new int[2];
    }
}
