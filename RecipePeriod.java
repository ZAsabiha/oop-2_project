import java.util.*;

class RecipePeriod {

    public String suggestRecipePeriod(Recipe recipe) {
        List<String> ingredients = recipe.getIngredients();
        String period = "";


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


    public String suggestRecipeByMood(String mood) {
        String period = "";


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
