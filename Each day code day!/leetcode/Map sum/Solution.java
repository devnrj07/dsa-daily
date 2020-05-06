import java.util.HashMap;
import java.util.Map;

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