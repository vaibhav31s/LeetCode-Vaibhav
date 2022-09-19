class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String , List<String>> map = new HashMap<>();
        
        for(String path  : paths){
            String[] arr = path.split(" ");
            String main = arr[0]+"/";
            
            for(int i = 1; i < arr.length; i++){
                
                // String a = patha[0];
                // String b = patha[1].substring(0,patha[1].length()-1);
                for(int j = arr[i].length()-1;j > 0; j--){
                    if(arr[i].charAt(j) == '('){
                        String name = arr[i].substring(j+1,arr[i].length()-1);
                        String pa = arr[i].substring(0,j);
                        map.putIfAbsent(name,new ArrayList<>());
                        map.get(name).add(main+pa);
                        break;
                    }
                }
            }
        }
                // System.out.println(map);
        List<List<String>> answer = new ArrayList<>();
        for(String x : map.keySet()){
            if(map.get(x).size() > 1)
            answer.add(map.get(x));
        }
        return answer;
    }
}



// Input: 
// abcd = root/a/1.txt, root/c/3.txt
// efgh = root/a/2.txt, root/c/d/4.txt
 
// paths = 
//     [
//     "root/a 1.txt(abcd) 2.txt(efgh)",
//     "root/c 3.txt(abcd)",
//     "root/c/d 4.txt(efgh)"
// ]
// Output: [
//     ["root/a/2.txt","root/c/d/4.txt"],
//     ["root/a/1.txt","root/c/3.txt"]
//     ]