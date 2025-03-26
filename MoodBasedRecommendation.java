import java.util.List;
import java.util.Map;

class MoodBasedRecommendation {
    private Map<String, List<String>> moodMeals = Map.of(
            "Energetic", List.of("Smoothie", "Fruit Salad"),
            "Relaxed", List.of("Herbal Tea", "Soup"),
            "Comfort Food", List.of("Pasta", "Brownies")
    );

    public void recommendByMood(String mood) {
        System.out.println("For a " + mood + " mood, try these: " + moodMeals.getOrDefault(mood, List.of("No suggestions available.")));
    }
}
