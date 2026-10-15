class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] n) {
        if(n.length==0)return res;
        findAllSubsets(n,0,new ArrayList<>());
        return res;
    }
    public void findAllSubsets(int[] num,int index,List<Integer>tmp){
        if(index==num.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(num[index]);
        findAllSubsets(num,index+1,tmp);
        tmp.remove(tmp.size()-1);
        findAllSubsets(num,index+1,tmp);
    }
}