class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        boolean isSameWords = word1.equals(word2);
        int prevIndex = -1;

        for( int i = 0; i < wordsDict.length; i++) {
            if(wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
                if(prevIndex >= 0) {
                    if( isSameWords || !wordsDict[i].equals(wordsDict[prevIndex])) {
                        minDistance = Math.min(minDistance, i - prevIndex);
                    }
                }
                prevIndex = i;
            }
        }

        return minDistance;
    }
}