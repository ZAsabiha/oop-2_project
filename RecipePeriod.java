import java.util.*;

class RecipePeriod {
    // Method to suggest the period based on recipe ingredients
    public String suggestRecipePeriod(Recipe recipe) {
        List<String> ingredients = recipe.getIngredients();
        String period = "";

        // Check for ingredients that are typically associated with certain periods
        if (ingredients.contains("Eggs") || ingredients.contains("Oats") || ingredients.contains("Banana")) {
            period = "Breakfast";
        } else if (ingredients.contains("Chicken") || ingredients.contains("Rice") || ingredients.contains("Lentils")) {
            period = "Lunch";
        } else if (ingredients.contains("Fish") || ingredients.contains("Salad") || ingredients.contains("Olive oil")) {
            period = "Dinner";
        } else {
            period = "Any time - Flexible meal!";
        }

        return period;
    }

    // Method to suggest a period based on mood or energy level
    public String suggestRecipeByMood(String mood) {
        String period = "";

        // Mood-based suggestion
        switch (mood.toLowerCase()) {
            case "energetic":
                period = "A protein-packed recipe like a Smoothie or Oats for a boost in the morning!";
                break;
            case "relaxed":
                period = "A light salad or veggie stir-fry to unwind in the evening!";
                break;
            case "focused":
                period = "A balanced meal like Chicken and Rice to fuel your day!";
                break;
            case "stressed":
                period = "Try a soothing recipe like a Banana Smoothie or Herbal Tea!";
                break;
            default:
                period = "No mood detected! Try any meal!";
        }

        return period;
    }
}
