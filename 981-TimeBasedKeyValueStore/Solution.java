class TimeMap {
    Map<String, TreeMap<Integer, String>> keyTimeMap;

    public TimeMap() {
        keyTimeMap = new HashMap<String, TreeMap<Integer, String>>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> timeValueMap = new TreeMap<Integer, String>();
        if(!keyTimeMap.containsKey(key)){
            keyTimeMap.put(key, timeValueMap);
        }
        keyTimeMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        String str = "";
        if(keyTimeMap.containsKey(key)){
            Integer floorKey = keyTimeMap.get(key).floorKey(timestamp);
            if(floorKey != null){
                str = keyTimeMap.get(key).get(floorKey);
            }

        }
        return str;
    }
}