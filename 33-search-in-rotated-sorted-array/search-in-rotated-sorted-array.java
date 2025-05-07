class Solution {
    public int search(int[] nums, int target) {
        return bsearch(nums,target,0,nums.length-1);
    }
    public static int bsearch(int[] nums, int target, int si,int ei){
        //si : starting index
        //ei : ending index
        if(si>ei){
            return -1;  //base case
        }
        int mid= si+(ei-si)/2; //another way of writing (si+ei)/2
        if(nums[mid] == target){
            return mid;
        }
        //mid on ARR1
        if(nums[si]<=nums[mid]){
            //case 1:left
            if((nums[si] <= target) && (target <= nums[mid])){
                return bsearch(nums,target,si,mid-1);
            }
            //case 2:right
            else{
                return bsearch(nums,target,mid+1,ei);
            }
        }
        //mid on ARR2
        else{
            //case 1:right
            if((nums[mid] <= target) && (target <= nums[ei])){
                return bsearch(nums,target,mid+1,ei);
            }
            //case 2:left
            else{
                return bsearch(nums,target,si,mid-1);
            }
        }
        
    }
}