class Solution {
    public String predictPartyVictory(String senate) {
        boolean[] banned = new boolean[senate.length()];
        while (true) {
            for(int i = 0; i < senate.length(); i++) {
                if(!banned[i]) {
                    boolean otherPartyFound = false;
                    for(int j = i+1; j < senate.length(); j++ ){
                        if(senate.charAt(i) != senate.charAt(j) && !banned[j]){
                            banned[j] = true;
                            otherPartyFound = true;
                            break;
                        }
                    }
                    if(!otherPartyFound){
                        for( int j = 0; j < i; j++ ){
                            if(senate.charAt(i) != senate.charAt(j) && !banned[j]){
                                banned[j] = true;
                                otherPartyFound = true;
                                break;
                            }
                        }
                    }
                    if(!otherPartyFound){
                        if(senate.charAt(i) =='R'){
                            return "Radiant";
                        } else {
                            return "Dire";
                        }
                    }
                }
            }
        }
    }
}