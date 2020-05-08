class Solution {
    public int minMutation(String start, String end, String[] bank) {
     //make a queue and set. for bfs
     // for graph use chars as stringd and bank(string[]) as edges
        if(start.equals(end)) return 0;
        
        // store all the strings as unique keys
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        
        char[] charSet = new char[]{'A', 'C', 'G', 'T'}; // the routes or the base keys for map
        
        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- >0){
                //get the first key from the queue
                String curr = queue.poll();
                if(curr.equals(end)) return level;
                
                char[] currArray = curr.toCharArray();//travesre each character of the string[]
                
                for(int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for(char c: charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if(!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
            }
        return -1;
    }
}