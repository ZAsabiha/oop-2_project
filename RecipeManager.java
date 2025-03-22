import java.util.*;

class RecipeManager {
    private List<Recipe> recipes = new ArrayList<>();
    private Map<String, Ingredient> ingredients = new HashMap<>();

    // Create Recipe
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        System.out.println("Recipe added: " + recipe.getName());
    }

    // Display Recipes
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

    // Update Recipe
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

    // Delete Recipe
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

    // Ingredient Management
    public void addIngredient(Ingredient ingredient) {
        ingredients.put(ingredient.getName().toLowerCase(), ingredient);
    }

    public void displayIngredients() {
        for (Ingredient ingredient : ingredients.values()) {
            System.out.println(ingredient);
        }
    }

    // Recipe Recommendations
    public void recommendRecipes(String ingredient) {
        System.out.println("Recommended recipes using: " + ingredient);
        for (Recipe recipe : recipes) {
            if (recipe.getIngredients().contains(ingredient)) {
                System.out.println(recipe.getName());
            }
        }
    }
}
