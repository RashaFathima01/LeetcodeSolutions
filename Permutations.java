class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        if (num.length == 1) {
            List<Integer> singleList = new ArrayList<>();
            singleList.add(num[0]);
            result.add(singleList);
            return result;
        }

        for (int i = 0; i < num.length; i++) {
            int n = num[i];
            int[] remainingNums = new int[num.length - 1];
            int index = 0;
            for (int j = 0; j < num.length; j++) {
                if (j != i) {
                    remainingNums[index] = num[j];
                    index++;
                }
            }
            
            List<List<Integer>> perms = permute(remainingNums);
            for (List<Integer> p : perms) {
                p.add(n);
            }
            
            result.addAll(perms);
        }
        
        return result;        
    }
}