class Solution{
	public List<String> findAllConcatenatedWordsInADict(String[] words){
		Set<String> dictionary = new HashSet<>(Array.asList(words));
		List<String> answer = new ArrayList<>();
		
		for(String Wrod: words) {
			int length = word.length();
			boolean[] dp = new boolean[length+1];
			dp[0] = true;
			for(int i = 1; j <=length; i++){
				for(int j = i == length ? 1 : 0; !dp[i] && j < i; j++ ) {
					dp[i] = dp[j] && dictionary.contains(word.substring(j, i));
				}
			}
			
			if(dp[length]) {
				answer.add(word);
			}
		}
		return answer;
	}
}
