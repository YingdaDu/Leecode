class solution{
public List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < num.length-2; i++){
            if(i>0&&num[i]==num[i-1])continue;
            int low=i+1,high=nums.length-1,sum=-num[i];
            while(low<high){
                if(num[low]+num[high]==sum){
                    res.add(Arrays.asList(num[i],num[low],num[high]));
                    while(low<high &&num[low]==num[low+1])low++;
                    while(low<high &&num[high]==num[high-1])high--;
                    low++;
                    high--;
                }else if(num[low]+num[high]<sum){
                    low++;
                }else{
                    high--;
                }
            }
        }
        return res;
    }
}
//K sum

public class Solution {
    int len = 0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }
    private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(index >= len) {
            return res;
        }
        if(k == 2) {
            int i = index, j = len - 1;
            while(i < j) {
                //find a pair
                if(target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(target-nums[i]);
                    res.add(temp);
                    //skip duplication
                    while(i<j && nums[i]==nums[i+1]) i++;
                    while(i<j && nums[j-1]==nums[j]) j--;
                    i++;
                    j--;
                    //move left bound
                } else if (target - nums[i] > nums[j]) {
                    i++;
                    //move right bound
                } else {
                    j--;
                }
            }
        } else{
            for (int i = index; i < len - k + 1; i++) {
                //use current number to reduce ksum into k-1sum
                ArrayList<List<Integer>> temp = kSum(nums, target-nums[i], k-1, i+1);
                if(temp != null){
                    for (List<Integer> l : temp) {
                        l.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len-1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
        return res;
    }
