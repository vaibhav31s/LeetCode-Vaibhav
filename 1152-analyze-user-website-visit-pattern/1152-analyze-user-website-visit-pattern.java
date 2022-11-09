class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i< username.length; i++){
            // System.out.println(username[i] + " " +  timestamp[i] + " " +  website[i]);
            list.add(new Pair(username[i], timestamp[i], website[i]));
        }
        
        Collections.sort(list,(a,b)-> a.time - b.time);
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(Pair p : list){
            map.putIfAbsent(p.user, new ArrayList<>());
            map.get(p.user).add(p.web);
        }
        System.out.println(map);
        TreeMap<String, Integer> map1 = new TreeMap<>();
        for(String key: map.keySet()){
            Set<String> set = new HashSet<>();
            List<String>  l = map.get(key);
            for(int i = 0; i < l.size() - 2; i++){
                for(int j = i+1; j < l.size() - 1; j++){

                    for(int k = j + 1; k < l.size(); k++){
                            String seq = l.get(i) + " " + 
                            l.get(j) + " " + l.get(k);
                      set.add(seq);
                    }
                }
          
            }
            
            for(String seq:  set)
              map1.put(seq, map1.getOrDefault(seq,0)+1);
        }
        
        // System.out.println(map1);
        int max = 0;
        String k = "";
        for(String key : map1.keySet()){
            if(max < map1.get(key)){
                max = map1.get(key);
                k = key;
            }
        }
        String[] ans = k.split(" ");
        
        
        return new ArrayList<>(Arrays.asList(ans));
    }
}
class Pair{
    String user;
    int time;
    String web;
    Pair(String u,int t, String w){
        user = u;
        time = t;
        web = w;
    }
}