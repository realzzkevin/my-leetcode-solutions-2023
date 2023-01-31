class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] players = new int[n][2];
        for(int i = 0; i < n; i++) {
            players[i][0] = ages[i];
            players[i][1] = scores[i];
        }

        Arrays.sort(players, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        Integer[][] dp = new Integer[n][n];
        return findMaxScore(dp, players, -1, 0);

    }

    private int findMaxScore(Integer[][] dp, int[][] players, int prev, int index) {
        if(index >= players.length){
            return 0;
        }

        if(dp[prev + 1][index] != null){
            return dp[prev + 1][index];
        }

        if(prev == -1 || players[index][1] >= players[prev][1]){
            return dp[prev + 1][index] = Math.max(findMaxScore(dp, players, prev, index + 1),
                    players[index][1] + findMaxScore(dp, players, index, index + 1 ));
        }

        return dp[prev + 1][index] = findMaxScore(dp, players, prev, index + 1);
    }
}