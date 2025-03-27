import java.util.HashMap;
import java.util.Map;

class MealPlan {
    private Map<String, Recipe> dailyMeals = new HashMap<>();

    public void addMeal(String day, Recipe recipe) {
        dailyMeals.put(day.toLowerCase(), recipe);
        System.out.println("Meal added for " + day + ": " + recipe.getName());
    }

    public void displayMealPlan() {
        if (dailyMeals.isEmpty()) {
            System.out.println("No meals planned yet.");
        } else {
            for (var entry : dailyMeals.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().getName());
            }
        }
    }
   
}
