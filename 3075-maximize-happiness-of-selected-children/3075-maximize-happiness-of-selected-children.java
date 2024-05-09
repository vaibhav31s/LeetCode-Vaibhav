class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int limit = 0;
        Arrays.sort(happiness);
        int end = happiness.length - 1;
        long answer = 0;
        while (k-- > 0) {
            int last = happiness[end--];
            if (limit > last) break;
            answer += (last - limit);
            limit++;
        }
        return answer;
    }
}