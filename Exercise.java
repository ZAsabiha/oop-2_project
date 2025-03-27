import java.util.Scanner;

// Exercise Class
class Exercise {
    private double weight; // in kg
    private double height; // in meters
    private int workoutDuration; // in minutes

    public Exercise(double weight, double height, int workoutDuration) {
        this.weight = weight;
        this.height = height;
        this.workoutDuration = workoutDuration;
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
}