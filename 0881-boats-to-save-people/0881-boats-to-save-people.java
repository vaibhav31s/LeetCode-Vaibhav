class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        while (i <= j) {
            if (i == j) {
                i++;
                j--;
            } else if (people[i] + people[j] <= limit) {
                j--;
                i++;
            } else {
                j--;
            }
              boatCount++;
        }
        return   boatCount++;
    }
}