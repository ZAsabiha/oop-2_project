import java.util.*;

class RecipeManager extends RecipeHandler{
    private List<Recipe> recipes = new ArrayList<>();
    private Map<String, Ingredient> ingredients = new HashMap<>();

  
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        System.out.println("Recipe added: " + recipe.getName());
    }

   
    public void displayRecipes() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
        } else {
            for (Recipe recipe : recipes) {
                System.out.println(recipe);
                System.out.println("------------------------");
            }
        }
    }

    public Recipe findRecipe(String name) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equalsIgnoreCase(name)) {
                return recipe;
            }
        }
        System.out.println("Recipe not found.");
        return null;
    }

    public Map<String, Ingredient> getIngredients() {
        return ingredients;
    }
        private static final Map<String, List<String>> healthBasedFoods = new HashMap<>();

    static {
    
        healthBasedFoods.put("high pressure", List.of(
            "Bananas", "Spinach", "Garlic", "Salmon", "Oats", "Avocados"
        ));

        healthBasedFoods.put("low pressure", List.of(
            "Salted Nuts", "Cheese", "Olives", "Chicken Soup", "Dark Chocolate", "Coffee"
        ));

        healthBasedFoods.put("diabetes", List.of(
            "Leafy Greens", "Whole Grains", "Beans", "Berries", "Nuts", "Greek Yogurt"
        ));

        healthBasedFoods.put("normal", List.of(
            "Chicken", "Eggs", "Fruits", "Vegetables", "Lean Meat", "Dairy"
        ));
    }

    public void suggestFoodsForCondition(String condition) {
        condition = condition.toLowerCase(); 

        if (healthBasedFoods.containsKey(condition)) {
            System.out.println("\nRecommended Foods for " + condition + ":");
            for (String food : healthBasedFoods.get(condition)) {
                System.out.println("- " + food);
            }
        } else {
            System.out.println("No specific recommendations found for this condition.");
        }
    }


    public boolean updateRecipe(String name, Recipe updatedRecipe) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equalsIgnoreCase(name)) {
                recipe.setName(updatedRecipe.getName());
                recipe.setIngredients(updatedRecipe.getIngredients());
                recipe.setSteps(updatedRecipe.getSteps());
                recipe.setNutritionalInfo(updatedRecipe.getNutritionalInfo());
                System.out.println("Recipe updated successfully!");
                return true;
            }
        }
        System.out.println("Recipe not found.");
        return false;
    }


    public boolean deleteRecipe(String name) {
        Iterator<Recipe> iterator = recipes.iterator();
        while (iterator.hasNext()) {
            Recipe recipe = iterator.next();
            if (recipe.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Recipe deleted successfully!");
                return true;
            }
        }
        System.out.println("Recipe not found.");
        return false;
    }


    public void addIngredient(Ingredient ingredient) {
        ingredients.put(ingredient.getName().toLowerCase(), ingredient);
    }

    public void displayIngredients() {
        for (Ingredient ingredient : ingredients.values()) {
            System.out.println(ingredient);
        }
    }


    public void recommendRecipes(String ingredient) {
        System.out.println("Recommended recipes using: " + ingredient);
        for (Recipe recipe : recipes) {
            if (recipe.getIngredients().contains(ingredient)) {
                System.out.println(recipe.getName());
            }
        }
    }
    public List<String> getRecipeNames() {
    List<String> recipeNames = new ArrayList<>();
    for (Recipe recipe : recipes) {
        recipeNames.add(recipe.getName());
    }
    return recipeNames;
}

public List<Recipe> getRecipes() {
    return recipes;
}
}

