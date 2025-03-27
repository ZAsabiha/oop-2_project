import java.util.*;

public class RecipeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeManager manager = new RecipeManager();
        MealPlan mealPlan = new MealPlan();
        DietaryAnalysis analyzer = new DietaryAnalysis();
        NutritionProfile profile = new NutritionProfile();
        IngredientSubstitution substitution = new IngredientSubstitution();
        MoodBasedRecommendation moodRecommender = new MoodBasedRecommendation();
        FoodWasteTracker wasteTracker = new FoodWasteTracker();
        RecipePeriod recipePeriod = new RecipePeriod();
        Exercise exercise = new Exercise();
        BodyRequirements bodyReq = new BodyRequirements();


        // Sample Recipes
        Recipe salad = new Recipe("Salad",
                List.of("Lettuce", "Tomato", "Cucumber", "Olive oil"),
                "Mix ingredients and add dressing.",
                "Calories: 150kcal");

        Recipe smoothie = new Recipe("Smoothie",
                List.of("Banana", "Milk", "Honey"),
                "Blend all ingredients until smooth.",
                "Calories: 200kcal");

        manager.addRecipe(salad);
        manager.addRecipe(smoothie);

        // Display menu only once
        System.out.println("\n--- Savour the Flavours of Health ---");
        System.out.println("1. Add Recipe");
        System.out.println("2. Display Recipes");
        System.out.println("3. Add Ingredient");
        System.out.println("4. Display Ingredients");
        System.out.println("5. Recommend Recipes");
        System.out.println("6. Meal Planning");
        System.out.println("7. Dietary Analysis");
        System.out.println("8. Nutrition Profile");
        System.out.println("9. Ingredient Substitution");
        System.out.println("10. Mood-Based Recommendations");
        System.out.println("11. Food Waste Tracker");
        System.out.println("12. Recipe Period Suggestions");
        System.out.println("13. Calculate BMI and Assess Health");
        System.out.println("14. Body Requirements Suggestions");
        System.out.println("0. Exit");

        while (true) {
            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter recipe name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ingredients (comma-separated): ");
                    List<String> ingredients = List.of(scanner.nextLine().split(", "));
                    System.out.print("Enter steps: ");
                    String steps = scanner.nextLine();
                    System.out.print("Enter nutritional info: ");
                    String nutrition = scanner.nextLine();
                    manager.addRecipe(new Recipe(name, ingredients, steps, nutrition));
                    break;
                case 2:
                    manager.displayRecipes();
                    break;
                case 3:
                    System.out.print("Enter ingredient name: ");
                    String ingName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter health benefits: ");
                    String benefits = scanner.nextLine();
                    manager.addIngredient(new Ingredient(ingName, quantity, benefits));
                    break;
                case 4:
                    manager.displayIngredients();
                    break;
                case 5:
                    System.out.print("Enter an ingredient for recommendations: ");
                    String recommendIngredient = scanner.nextLine();
                    manager.recommendRecipes(recommendIngredient);
                    break;
//                case 6:
//                    mealPlan.displayMealPlan();
//                    break;
                case 6:
                    System.out.print("Enter day of the week: ");
                    String day = scanner.nextLine();

                    System.out.print("Enter recipe name: ");
                    String mealName = scanner.nextLine();

                    Recipe mealRecipe = manager.findRecipe(mealName); // Assuming you have a method to find a recipe

                    if (mealRecipe != null) {
                        mealPlan.addMeal(day, mealRecipe);
                    } else {
                        System.out.println("Recipe not found.");
                    }
                    break;

                case 7:
                    System.out.print("Enter recipe name for analysis: ");
                    String analyzeName = scanner.nextLine();
                    Recipe analyzedRecipe = manager.findRecipe(analyzeName);
                    if (analyzedRecipe != null) {
                        analyzer.analyzeRecipe(analyzedRecipe);
                    } else {
                        System.out.println("Recipe not found.");
                    }
                    break;
                case 8:
                    System.out.print("Enter dietary preference (e.g., Vegan, Gluten-Free): ");
                    String preference = scanner.nextLine();
                    profile.setPreference(preference);
                    System.out.println("User dietary preference set to: " + profile.getPreference());
                    break;
                case 9:
                    System.out.print("Enter ingredient to substitute: ");
                    String subIngredient = scanner.nextLine();
                    substitution.suggestSubstitution(subIngredient);
                    break;
                case 10:
                    System.out.print("Enter mood for recommendation (e.g., Energetic, Relaxed): ");
                    String mood = scanner.nextLine();
                    moodRecommender.recommendByMood(mood);
                    break;
                case 11:
                    wasteTracker.displayExpiringIngredients(manager.getIngredients());
                    wasteTracker.suggestRecipesForExpiringIngredients(manager);
                    break;
                case 12:
                    System.out.print("Enter recipe name to suggest period for: ");
                    String recipeName = scanner.nextLine();
                    Recipe recipeToCheck = manager.findRecipe(recipeName);
                    if (recipeToCheck != null) {
                        System.out.println("Suggested period for " + recipeName + ": " + recipePeriod.suggestRecipePeriod(recipeToCheck));
                    } else {
                        System.out.println("Recipe not found.");
                    }
                    System.out.print("Enter your current mood (Energetic, Relaxed, Focused, Stressed): ");
                    String moodForPeriod = scanner.nextLine();
                    System.out.println("Mood-based suggestion: " + recipePeriod.suggestRecipeByMood(moodForPeriod));
                    break;
                    case 13:
                    System.out.print("Enter your weight (kg): ");
                    double weight = scanner.nextDouble();
                    System.out.print("Enter your height (m): ");
                    double height = scanner.nextDouble();
                    double bmi = exercise.calculateBMI(weight, height);
                    System.out.println("Your BMI is: " + bmi);
                    System.out.println("Health Status: " + exercise.getHealthStatus(bmi));
                    break;
                case 14:
                    System.out.print("Enter your age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter your gender (Male/Female): ");
                    String gender = scanner.nextLine();
                    bodyReq.suggestNutrition(age, gender);
                    break;
                case 0:
                    System.out.println("Exiting application. Stay healthy!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
