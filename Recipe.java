import java.util.*;

// Recipe class to represent individual recipes
class Recipe {
    private String name;
    private List<String> ingredients;
    private String steps;
    private String nutritionalInfo;

    public Recipe(String name, List<String> ingredients, String steps, String nutritionalInfo) {
        this.name = name;
        this.ingredients = new ArrayList<>(ingredients);
        this.steps = steps;
        this.nutritionalInfo = nutritionalInfo;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getIngredients() { return ingredients; }
    public void setIngredients(List<String> ingredients) { this.ingredients = new ArrayList<>(ingredients); }

    public String getSteps() { return steps; }
    public void setSteps(String steps) { this.steps = steps; }

    public String getNutritionalInfo() { return nutritionalInfo; }
    public void setNutritionalInfo(String nutritionalInfo) { this.nutritionalInfo = nutritionalInfo; }

    @Override
    public String toString() {
        return "Recipe: " + name + "\nIngredients: " + ingredients + "\nSteps: " + steps + "\nNutritional Info: " + nutritionalInfo;
    }
}

