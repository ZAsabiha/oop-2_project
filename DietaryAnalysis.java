class DietaryAnalysis implements Analyzable {
    public void analyzeRecipe(Recipe recipe) {
        System.out.println("Analyzing recipe: " + recipe.getName());
        System.out.println("Nutritional Info: " + recipe.getNutritionalInfo());

        int calories = recipe.getCaloriesAsInt();
        if (calories != -1) {
            if (calories > 400) {
                System.out.println("This recipe is high in calories.");
                System.out.println("Suggestion: Consume this recipe if you are underweight or need extra energy for intense physical activity.");
            } else if (calories >= 200) {
                System.out.println("This recipe has a moderate calorie count.");
                System.out.println("Suggestion: This is a balanced option for maintaining your current weight.");
            } else {
                System.out.println("This recipe is low in calories.");
                System.out.println("Suggestion: Ideal for weight loss or as a light meal/snack.");
            }
        } else {
            System.out.println("Unable to analyze calorie content due to invalid format.");
            System.out.println("Suggestion: Please verify the calorie information for this recipe.");
        }
    }
}
