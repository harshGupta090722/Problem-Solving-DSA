import java.util.*;

class LFUCache {
    private HashMap<Integer, Integer> keyToVal = new HashMap<>();
    private HashMap<Integer, Integer> keyToFreq = new HashMap<>();
    private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys = new HashMap<>();
    private int minFreq = 0;
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key))
            return -1;

        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        freqToKeys.get(freq).remove(key);
        freqToKeys.computeIfAbsent(freq + 1, f -> new LinkedHashSet<>()).add(key);

        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (minFreq == freq)
                minFreq++;
        }

        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key);
            return;
        }

        if (keyToVal.size() == capacity) {
            int keyToRemove = freqToKeys.get(minFreq).iterator().next();
            freqToKeys.get(minFreq).remove(keyToRemove);
            keyToVal.remove(keyToRemove);
            keyToFreq.remove(keyToRemove);
        }

        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.computeIfAbsent(1, f -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }

    public static void main(String args[]) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        System.out.println(lfu.get(1)); // returns 1
        lfu.put(3, 3); // removes key 2
        System.out.println(lfu.get(2)); // returns -1
        System.out.println(lfu.get(3)); // returns 3
        lfu.put(4, 4); // removes key 1
        System.out.println(lfu.get(1)); // returns -1
        System.out.println(lfu.get(3)); // returns 3
        System.out.println(lfu.get(4)); // returns 4
    }
}