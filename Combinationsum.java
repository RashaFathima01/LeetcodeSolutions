class Solution {
    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0)
            return output;
        findComb(candidates, new ArrayList<>(), 0, target);
        return output;
    }

    public void findComb(int[] candidates, List<Integer> tmp, int index, int sum) {
        if (index == candidates.length) {
            if (sum == 0) {
                output.add(new ArrayList<>(tmp));
            }
            return;
        }
        if (candidates[index] <= sum) {

            tmp.add(candidates[index]);
            findComb(candidates, tmp, index, sum - candidates[index]);
            tmp.remove(tmp.size() - 1);
        }

        findComb(candidates, tmp, index + 1, sum);
    }
}