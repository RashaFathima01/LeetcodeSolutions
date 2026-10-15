class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[n + 1];
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {

            int num = entry.getKey();
            int count = entry.getValue();

            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }

            bucket[count].add(num);
        }

        int[] result = new int[k];
        int index = 0;
        for (int frequency = n;
             frequency >= 1 && index < k;
             frequency--) {

            if (bucket[frequency] == null) {
                continue;
            }

            for (int num : bucket[frequency]) {

                result[index++] = num;

                if (index == k) {
                    break;
                }
            }
        }

        return result;
    }
}