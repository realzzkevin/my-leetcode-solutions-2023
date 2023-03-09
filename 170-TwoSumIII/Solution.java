class TwoSum {
    private Map<Integer, Integer> map;
    public TwoSum() {
        map = new HashMap<Integer, Integer>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int n = value - entry.getKey();
            if(n != entry.getKey()) {
                if(map.containsKey(n)){
                    return true;
                }
            } else {
                if(entry.getValue() > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}