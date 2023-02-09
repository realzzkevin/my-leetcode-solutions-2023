class Solution {
    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> ideasMap = new HashMap<>();
        for(String idea: ideas) {
            ideasMap.computeIfAbsent(idea.charAt(0), set -> new HashSet<String>()).add(idea.substring(1));
        }
        List<Set<String>> ideasList = new ArrayList<>(ideasMap.values());
        long answer = 0;
        for(int i = 0; i < ideasList.size() - 1; i++){
            for(int j = i+1; j < ideasList.size(); j++){
                long numOfMutual = 0;
                for(String ideaA: ideasList.get(i)){
                    if(ideasList.get(j).contains(ideaA)){
                        numOfMutual++;
                    }
                }
                answer += 2 * (ideasList.get(i).size() - numOfMutual) * (ideasList.get(j).size() - numOfMutual);
            }
        }
        return answer;
    }
}