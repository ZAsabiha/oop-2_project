import java.util.*;

class NutritionProfile {
    private String dietaryPreference;

    public void setPreference(String preference) {
        this.dietaryPreference = preference;
    }

    public String getPreference() {
        return dietaryPreference;
    }

    public void provideDietaryInformation(String preference) {
        switch (preference.toLowerCase()) {
            case "vegan":
                displayVeganDiet();
                break;
            case "vegetarian":
                displayVegetarianDiet();
                break;
            case "gluten-free":
                displayGlutenFreeDiet();
                break;
            case "keto":
                displayKetoDiet();
                break;
            default:
                displayUnknownDiet(preference);
                break;
        }
    }

    private void displayVeganDiet() {
        System.out.println("Vegan diet: Focuses on plant-based foods, excluding all animal products.");
        System.out.println("Consider recipes rich in legumes, grains, and vegetables.");
    }

    private void displayVegetarianDiet() {
        System.out.println("Vegetarian diet: Excludes meat but may include dairy and eggs.");
        System.out.println("Focus on a balanced diet with vegetables, fruits, grains, and dairy or eggs.");
    }

    private void displayGlutenFreeDiet() {
        System.out.println("Gluten-free diet: Excludes foods containing gluten (wheat, barley, rye).");
        System.out.println("Choose gluten-free grains like rice, quinoa, and corn.");
    }

    private void displayKetoDiet() {
        System.out.println("Ketogenic diet: High-fat, moderate-protein, low-carb diet.");
        System.out.println("Focus on foods high in fats and low in carbohydrates.");
    }

    private void displayUnknownDiet(String preference) {
        System.out.println("Information for '" + preference + "' not available.");
    }
}
