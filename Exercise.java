import java.util.*;

class Exercise {
    private double weight; 
    private double height; 
    private int workoutDuration; 
    private int age; 

    public Exercise() {
      
    }

    public void takeInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your weight (in kg): ");
        this.weight = scanner.nextDouble();

        System.out.print("Enter your height (in meters): ");
        this.height = scanner.nextDouble();

        System.out.print("Enter your age (in years): ");
        this.age = scanner.nextInt();

        System.out.print("Enter your workout duration (in minutes): ");
        this.workoutDuration = scanner.nextInt();
    }

    public double calculateBMI() {
        return weight / (height * height);
    }

    public String assessHealth() {
        double bmi = calculateBMI();
        if (bmi < 18.5) {
            return "Weak - Consider gaining weight with a balanced diet and strength exercises.";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Healthy - Maintain your current lifestyle.";
        } else {
            return "Strong - Focus on cardio and a balanced diet to improve fitness.";
        }
    }

    public void suggestWorkout() {
        if (workoutDuration < 30) {
            System.out.println("Try increasing your workout duration to at least 30 minutes for better results.");
        } else if (workoutDuration <= 60) {
            System.out.println("Great job! Continue with your workout routine.");
        } else {
            System.out.println("Ensure to stay hydrated and avoid over-exercising.");
        }
    }


public void suggestFoodBasedOnBMI(List<Recipe> recipes) {
    double bmi = calculateBMI();
    System.out.println("\nFood Suggestions Based on Your BMI:");

    if (bmi < 18.5) {
        System.out.println("You are underweight. Consider these recipes to gain weight healthily:");
        for (Recipe recipe : recipes) {
            if (recipe.getCaloriesAsInt() > 400) { 
                System.out.println("- " + recipe.getName() + " (" + recipe.getNutritionalInfo() + ")");
            }
        }
    } else if (bmi >= 18.5 && bmi <= 24.9) {
        System.out.println("You have a healthy BMI. Maintain it with these recipes:");
        for (Recipe recipe : recipes) {
            if (recipe.getCaloriesAsInt() >= 200 && recipe.getCaloriesAsInt() <= 400) { 
                System.out.println("- " + recipe.getName() + " (" + recipe.getNutritionalInfo() + ")");
            }
        }
    } else {
        System.out.println("You are overweight. Focus on these recipes to manage weight:");
        for (Recipe recipe : recipes) {
            if (recipe.getCaloriesAsInt() < 200) { 
                System.out.println("- " + recipe.getName() + " (" + recipe.getNutritionalInfo() + ")");
            }
        }
    }
}

}
