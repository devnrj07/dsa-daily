import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution{
    public static void main(String[] args) {
        
    }


}

//O(n) basic
class MapSum{
    private Map<String,Integer> mapSum;
    MapSum(){
       mapSum = new HashMap<>(); 
    }

    public void insert(String key, int value){
        mapSum.put(key, value);
    }

    public int sum(String prefix){
        int result = 0;
        
        for(String key : mapSum.keySet()){
            if(key != null && key.startsWith(prefix)){
                result += mapSum.get(key);
            }
        }

        return result;
    }
}

class MapSum {
    TreeMap<String, Integer> map;
    
        public MapSum() {
            map = new TreeMap<String, Integer>();
        }
    
        public void insert(String key, int val) {
            map.put(key, val);
        }
    
        public int sum(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return 0;
            }
            int sum = 0;
            String key = map.ceilingKey(prefix);
             while(key != null && key.startsWith(prefix)) {
                sum += map.get(key);
                key = map.higherKey(key);
            }
            return sum;
        }
    }