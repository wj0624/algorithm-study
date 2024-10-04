class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        for(int[] card : sizes){
            int w = Math.max(card[0], card[1]);
            int h = Math.min(card[0], card[1]);
            
            maxW = Math.max(w, maxW);
            maxH = Math.max(h, maxH);
        }
        return maxW * maxH;
    }
}