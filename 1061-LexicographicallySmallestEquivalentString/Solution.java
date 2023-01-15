class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Dsu set = new Dsu();

        for(int i = 0; i < s1.length(); i++) {
            int x = s1.charAt(i) - 'a';
            int y = s2.charAt(i) - 'a';
            set.unionSet(x, y);

        }

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++){
            char z = (char)(set.findSet(baseStr.charAt(i)-'a') + 'a');
            str.append(z);
        }
        return str.toString();

    }

}

class Dsu{
    int[] lexicoTable;

    Dsu(){
        lexicoTable = new int[26];
        for(int i = 0; i < 26; i++) {
            lexicoTable[i] = i;
        }
    }

    public int findSet(int a){
        if( a == lexicoTable[a]){
            return a;
        } else {
            return lexicoTable[a] = findSet(lexicoTable[a]);
        }
    }

    public void unionSet(int a, int b){
        int x = findSet(a);
        int y = findSet(b);

        if( x < y) {
            lexicoTable[y] = x;
        } else if(x > y) {
            lexicoTable[x] = y;
        }
    }


}