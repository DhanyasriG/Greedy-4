//Time Complexity: O(M log N) where M is the length of target and N is the length of source
//Space Complexity: O(N)

//We use a hashmap to store the indices of each character in the source string.
//Then we iterate through the target string and for each character, we use binary search to find
//the next occurrence of that character in the source string. If we reach the end of the source string,
//we increment the count of subsequences and start from the beginning of the source string again.
//If at any point a character in the target string is not found in the source string, we return -1.
//If we successfully iterate through the target string, we return the count of subsequences used.

class Solution {
    public int shortestWay(String source, String target) {
       
        HashMap<Character, List<Integer>> map = new HashMap<>();

        for(int i=0; i<source.length(); i++){
            char c = source.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }

        int i = 0, j = 0;
        int count = 0;

        while(j < target.length()){
            char tChar = target.charAt(j);

            if(!map.containsKey(tChar)) return -1;
            
            List<Integer> list = map.get(tChar);
            int idx = binarySearch(list, i);
            if(idx == list.size()){
                i = list.get(0);
                count++;
            }else{
                i = list.get(idx);
                i++; j++;
                if(j == target.length()) return count+1;
            }
        
            if(i == source.length()){
                i = 0;
                count++;
            }
        }

        return -1;
    }

    private int binarySearch(List<Integer> list, int target){
        int low = 0, high = list.size() - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(list.get(mid) == target) return mid;
            else if(list.get(mid) > target) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }   
}
