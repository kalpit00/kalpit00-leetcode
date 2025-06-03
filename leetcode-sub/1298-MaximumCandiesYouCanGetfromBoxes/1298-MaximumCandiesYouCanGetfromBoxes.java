// Last updated: 6/2/2025, 9:37:09 PM
class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> queue= new LinkedList<>();
        for(int i: initialBoxes){
            queue.add(i);
        }
        int result=0;
        while(!queue.isEmpty()){
            int box=queue.remove();
            if(status[box]==0){
                if(queue.isEmpty()){
                    return result;
                }
                queue.add(box);
            }else{
                result+=candies[box];
                for(int key: keys[box]){
                    status[key]=1;
                }
                for(int containedBox: containedBoxes[box]){
                    queue.add(containedBox);
                }
            }
        }
        return result;
    }
}