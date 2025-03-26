import java.util.Map;

class IngredientSubstitution {
    private static final Map<String, String> substitutions = Map.of(
            "Sugar", "Honey",
            "Butter", "Olive oil",
            "Salt", "Herbs for flavor"
    );

    public void suggestSubstitution(String ingredient) {
        System.out.println("Substitute " + ingredient + " with: " + substitutions.getOrDefault(ingredient, "No substitute available."));
    }
}
