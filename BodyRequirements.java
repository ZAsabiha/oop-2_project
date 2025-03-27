class BodyRequirements {
    private int age;
    private String gender;

    public BodyRequirements(int age, String gender) {
        this.age = age;
        this.gender = gender;
    }

    public void suggestDailyIntake() {
        if (age < 18) {
            System.out.println("Recommended intake: Balanced diet rich in protein, vitamins, and minerals.");
        } else if (age >= 18 && age <= 50) {
            System.out.println("Recommended intake: Include carbs, protein, healthy fats, and fiber.");
        } else {
            System.out.println("Recommended intake: Focus on calcium, fiber, and heart-healthy foods.");
        }
    }
}