class TimeMap {

    private Map<String, List<ValueTimestamp>> keyToValueMap;

    public TimeMap() {
        this.keyToValueMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.keyToValueMap.computeIfAbsent(key, k -> new ArrayList<>());

        this.keyToValueMap.get(key).add(new ValueTimestamp(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<ValueTimestamp> list = this.keyToValueMap.get(key);

        if (list == null) {
            return "";
        }

        int index = bs(list, timestamp, 0, list.size()-1);

        return index < 0 ? "" : list.get(index).value();
    }

    private int bs(List<ValueTimestamp> list, int timestamp, int left, int right) {
        if (right < left) {
            return right;
        }

        int pivot = left + (right-left)/2;

        if(list.get(pivot).timestamp() == timestamp) {
            return pivot;
        } else if (timestamp < list.get(pivot).timestamp()) {
            return bs(list, timestamp, left, pivot-1);
        }
         else {
            return bs(list, timestamp, pivot+1, right);
         }

    }

    private record ValueTimestamp(String value, int timestamp){}
}
