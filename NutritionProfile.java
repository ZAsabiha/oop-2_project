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
                System.out.println("Vegan diet: Focuses on plant-based foods, excluding all animal products.");
                System.out.println("Consider recipes rich in legumes, grains, and vegetables.");
                break;
            case "vegetarian":
                System.out.println("Vegetarian diet: Excludes meat but may include dairy and eggs.");
                System.out.println("Focus on a balanced diet with vegetables, fruits, grains, and dairy or eggs.");
                break;
            case "gluten-free":
                System.out.println("Gluten-free diet: Excludes foods containing gluten (wheat, barley, rye).");
                System.out.println("Choose gluten-free grains like rice, quinoa, and corn.");
                break;
            case "keto":
                System.out.println("Ketogenic diet: High-fat, moderate-protein, low-carb diet.");
                System.out.println("Focus on foods high in fats and low in carbohydrates.");
                break;
            default:
                System.out.println("Information for '" + preference + "' not available.");
                break;
        }
    }  
}
