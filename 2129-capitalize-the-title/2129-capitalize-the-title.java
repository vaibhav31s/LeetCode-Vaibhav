class Solution {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() <= 2) answer.append(words[i].toLowerCase()).append(" ");
            else  answer.append(Character.toUpperCase(words[i].charAt(0))).append(words[i].substring(1).toLowerCase()).append(" ");
        }
        answer.deleteCharAt(answer.length() - 1);
        
        return answer.toString();
    }
}