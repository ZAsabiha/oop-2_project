import java.util.*;

public class RecipeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeManager manager = new RecipeManager();
        MealPlan mealPlan = new MealPlan();
        DietaryAnalysis analyzer = new DietaryAnalysis();
        NutritionProfile profile = new NutritionProfile();
        MoodBasedRecommendation moodRecommender = new MoodBasedRecommendation();
        FoodWasteTracker wasteTracker = new FoodWasteTracker();
        RecipePeriod recipePeriod = new RecipePeriod();
        Exercise exercise = new Exercise();
        DisplayTitle displaytitle = new DisplayTitle();

        displaytitle.display();

        while (true) {
            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addRecipe(scanner, manager);
                    break;
                case 2:
                    displayRecipes(manager);
                    break;
                case 3:
                    planMeal(scanner, manager, mealPlan);
                    break;
                case 4:
                    analyzeRecipe(scanner, manager, analyzer);
                    break;
                case 5:
                    setDietaryPreference(scanner, profile);
                    break;
                case 6:
                    suggestFoodsForCondition(scanner, manager);
                    break;
                case 7:
                    recommendByMood(scanner, moodRecommender);
                    break;
                case 8:
                    trackFoodWaste(scanner, wasteTracker, manager);
                    break;
                case 9:
                    suggestRecipePeriod(scanner, manager, recipePeriod);
                    break;
                case 10:
                    calculateBMIAndSuggestFood(scanner, exercise, manager);
                    break;
                case 11:
                    suggestDailyCaloricIntake(scanner);
                    break;
                case 0:
                    System.out.println("Exiting application. Stay healthy!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addRecipe(Scanner scanner, RecipeManager manager) {
        System.out.print("Enter recipe name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ingredients (comma-separated): ");
        List<String> ingredients = List.of(scanner.nextLine().split(", "));
        System.out.print("Enter steps: ");
        String steps = scanner.nextLine();
        System.out.print("Enter nutritional info: ");
        String nutrition = scanner.nextLine();
        manager.addRecipe(new Recipe(name, ingredients, steps, nutrition));
    }

    private static void displayRecipes(RecipeManager manager) {
        manager.displayRecipes();
    }

    private static void planMeal(Scanner scanner, RecipeManager manager, MealPlan mealPlan) {
        System.out.print("Enter day of the week: ");
        String day = scanner.nextLine();
        System.out.print("Enter recipe name: ");
        String mealName = scanner.nextLine();
        Recipe mealRecipe = manager.findRecipe(mealName);
        if (mealRecipe != null) {
            mealPlan.addMeal(day, mealRecipe);
        } else {
            System.out.println("Recipe not found.");
        }
    }

    private static void analyzeRecipe(Scanner scanner, RecipeManager manager, DietaryAnalysis analyzer) {
        System.out.print("Enter recipe name for analysis: ");
        String analyzeName = scanner.nextLine();
        Recipe analyzedRecipe = manager.findRecipe(analyzeName);
        if (analyzedRecipe != null) {
            analyzer.analyzeRecipe(analyzedRecipe);
        } else {
            System.out.println("Recipe not found.");
        }
    }

    private static void setDietaryPreference(Scanner scanner, NutritionProfile profile) {
        System.out.print("Enter dietary preference (e.g., Vegan, Gluten-Free): ");
        String preference = scanner.nextLine();
        profile.setPreference(preference);
        System.out.println("User dietary preference set to: " + profile.getPreference());
    }

    private static void suggestFoodsForCondition(Scanner scanner, RecipeManager manager) {
        System.out.print("Enter health condition (e.g., Diabetes, Hypertension, Anemia): ");
        String condition = scanner.nextLine();
        manager.suggestFoodsForCondition(condition);
    }

    private static void recommendByMood(Scanner scanner, MoodBasedRecommendation moodRecommender) {
        System.out.print("Enter mood for recommendation (e.g., Energetic, Relaxed): ");
        String mood = scanner.nextLine();
        moodRecommender.recommendByMood(mood);
    }

    private static void trackFoodWaste(Scanner scanner, FoodWasteTracker wasteTracker, RecipeManager manager) {
        System.out.print("Enter ingredient name: ");
        String ingredientName = scanner.nextLine();
        System.out.print("Enter days left before expiration: ");
        int daysLeft = scanner.nextInt();
        scanner.nextLine();
        wasteTracker.addExpiringIngredient(ingredientName, daysLeft);
        System.out.println(ingredientName + " added to expiring ingredients list.");
        wasteTracker.suggestRecipesForExpiringIngredients(manager);
    }

    private static void suggestRecipePeriod(Scanner scanner, RecipeManager manager, RecipePeriod recipePeriod) {
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
    }

    private static void calculateBMIAndSuggestFood(Scanner scanner, Exercise exercise, RecipeManager manager) {
        exercise.takeInput();
        double bmi = exercise.calculateBMI();
        System.out.println("Your BMI is: " + bmi);
        System.out.println("Health Status: " + exercise.assessHealth());
        exercise.suggestWorkout();
        List<Recipe> recipes = manager.getRecipes();
        exercise.suggestFoodBasedOnBMI(recipes);
    }

    private static void suggestDailyCaloricIntake(Scanner scanner) {
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your gender (Male/Female): ");
        String gender = scanner.nextLine();
        BodyRequirements bodyRequirements = new BodyRequirements(age, gender);
        bodyRequirements.suggestDailyIntake();
    }
}
