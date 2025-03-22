import java.util.List;

public class RecipeApp {
    public static void main(String[] args) {
        RecipeManager manager = new RecipeManager();
        MealPlan mealPlan = new MealPlan();
        DietaryAnalysis analyzer = new DietaryAnalysis();

        Recipe salad = new Recipe("Salad",
                List.of("Lettuce", "Tomato", "Cucumber", "Olive oil"),
                "Mix ingredients and add dressing.",
                "Calories: 150kcal");

        Recipe smoothie = new Recipe("Smoothie",
                List.of("Banana", "Milk", "Honey"),
                "Blend all ingredients until smooth.",
                "Calories: 200kcal");

        // Adding recipes
        manager.addRecipe(salad);
        manager.addRecipe(smoothie);

        // Displaying recipes
        manager.displayRecipes();

        // Adding and displaying ingredients
        manager.addIngredient(new Ingredient("Banana", 10, "High in potassium"));
        manager.addIngredient(new Ingredient("Olive oil", 5, "Good for heart health"));
        manager.displayIngredients();

        // Recipe recommendations
        manager.recommendRecipes("Banana");

        // Meal Planning
        mealPlan.addMeal("Monday", salad);
        mealPlan.addMeal("Tuesday", smoothie);
        mealPlan.displayMealPlan();

        // Dietary Analysis
        analyzer.analyzeRecipe(smoothie);
    }
}