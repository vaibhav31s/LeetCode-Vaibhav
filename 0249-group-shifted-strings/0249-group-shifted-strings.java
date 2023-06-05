class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
		for(String s : strings){
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < s.length()-1; i++){
				int a= (s.charAt(i)-s.charAt(i+1)+26) % 26;
				sb.append(a).append(",");
			}
			map.putIfAbsent(sb.toString(), new ArrayList<>());
			map.get(sb.toString()).add(s);
		}

		List<List<String>> answer = new ArrayList<>();
		
		for(List<String> a : map.values()){
			answer.add(a);
		}
        
        return answer;
        
    }
}

// az
// ba
// 1,25
    
// abc
// bcd
// 1-1-1

// abc 1-1-1
// xyz 1-1-1
    

// az 1 1
// ba 1 1

