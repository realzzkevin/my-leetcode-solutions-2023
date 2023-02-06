class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length) {
            return false;
        }
        Set<String> pairs = new HashSet<String>();
        for(List<String> pair : similarPairs){
            pairs.add(pair.get(0)+","+pair.get(1));
            pairs.add(pair.get(1)+","+pair.get(0));
        }
        for(int i = 0; i < sentence1.length; i++) {
            String s1 = sentence1[i];
            String s2 = sentence2[i];
            if(!s1.equals(s2) && !pairs.contains(s1 + ","+ s2)){
                return false;
            }
        }
        return true;
    }
}