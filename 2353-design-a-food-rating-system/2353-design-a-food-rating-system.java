class FoodRatings {
    // HashMap<String, Pair> map 
    HashMap<String,Pair> set = new HashMap<>();
    HashMap<String, PriorityQueue<Pair>> map;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        for(int i = 0; i < ratings.length; i++){
            if(!map.containsKey(cuisines[i])){
                map.put(cuisines[i],new PriorityQueue<>((a,b)->
            b.rating-a.rating==0 ? a.food.compareTo(b.food) : b.rating-a.rating));
            }
            Pair  p = new Pair(foods[i],ratings[i],cuisines[i]);
            set.put(foods[i], p);
            map.get(cuisines[i]).add(p);
                
        }
        
    }
    
    public void changeRating(String food, int newRating) {
        Pair p = set.get(food);
        int rating = p.rating;
        if(rating == newRating) return;
        String cus = p.cuisine;
        map.get(cus).remove(p);
        p.rating = newRating;
        map.get(cus).add(p);
        
        
    }
    
    public String highestRated(String cuisine) {
        return map.get(cuisine).peek().food;
    }
}
class Pair{
    String food;
    int rating;
    String cuisine;
    Pair(String food, int rating, String cuisine){
        this.food = food;
        this.rating = rating;
        this.cuisine = cuisine;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */