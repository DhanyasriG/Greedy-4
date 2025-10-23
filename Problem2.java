//Time Complexity: O(N) where N is the length of tops or bottoms
//Space Complexity: O(1)

//We use a hashmap to count the occurrences of each number in both tops and bottoms arrays.
//We check if any number has occurrences equal to the length of the arrays, which means it can be the target number.
//If no such number exists, we return -1.
//If a target number is found, we call the helper function to calculate the minimum rotations needed
//to make all values in tops or bottoms equal to the target number.


class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int le=tops.length;
        int target=-1;
        for(int i=0;i<le;i++){
            map.put(tops[i],map.getOrDefault(tops[i],0)+1);
            if(map.get(tops[i])==le){
                target=tops[i];
                break;
            }
            map.put(bottoms[i],map.getOrDefault(bottoms[i],0)+1);
            if(map.get(bottoms[i])==le){
                target=bottoms[i];
                break;
            }
        }
        if(target==-1) return -1;
        return helper(tops,bottoms,target);
    }
    int helper(int tops[],int bottoms[],int target){
        int tp=0,bp=0;
        for(int i=0;i<tops.length;i++){
            if(tops[i]!=target&&bottoms[i]!=target) return -1;
            if(tops[i]==target&&bottoms[i]==target) continue;
            if(tops[i]!=target) tp++;
            if(bottoms[i]!=target)  bp++;
            
        }
        return Math.min(tp,bp);
    }
}