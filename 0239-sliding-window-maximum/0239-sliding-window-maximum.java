class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<>();
        int l = 0,r = 0;
        for(int i = 0;i < k;i++){
            if(deq.size() == 0){
                deq.addLast(i);
            }
            else{
                while(deq.size() > 0 && nums[i] > nums[deq.peekLast()]){
                    deq.removeLast();
                }
                deq.addLast(i);
            }
            r = i;
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[deq.peekFirst()]);
        while(r < nums.length-1){
            l++;
            if(!deq.isEmpty() && deq.peekFirst() < l){
                deq.removeFirst();
            }
            r++;
            while(deq.size() > 0 && nums[r] > nums[deq.peekLast()]){
                    deq.removeLast();
                }
            deq.addLast(r);
            list.add(nums[deq.peekFirst()]);
        }
        int[] arr = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}