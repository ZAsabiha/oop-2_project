import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class ExerciseTest {

    @Test
    void testCalculateBMI() {
        Exercise exercise = new Exercise();
        exercise.takeInputForTest(70, 1.75, 30, 25);  
        assertEquals(22.86, exercise.calculateBMI(), 0.01); 
    }

    @Test
    void testAssessHealthWeak() {
        Exercise exercise = new Exercise();
        exercise.takeInputForTest(50, 1.75, 30, 25);
        assertEquals("Weak - Consider gaining weight with a balanced diet and strength exercises.", exercise.assessHealth());
    }

    @Test
    void testAssessHealthHealthy() {
        Exercise exercise = new Exercise();
        exercise.takeInputForTest(70, 1.75, 30, 25);
        assertEquals("Healthy - Maintain your current lifestyle.", exercise.assessHealth());
    }

    @Test
    void testAssessHealthStrong() {
        Exercise exercise = new Exercise();
        exercise.takeInputForTest(95, 1.75, 30, 25);
        assertEquals("Strong - Focus on cardio and a balanced diet to improve fitness.", exercise.assessHealth());
    }

    @Test
    void testSuggestWorkoutShortDuration() {
        Exercise exercise = new Exercise();
        exercise.takeInputForTest(70, 1.75, 20, 25);
        exercise.suggestWorkout();
    }

    @Test
    void testSuggestWorkoutIdealDuration() {
        Exercise exercise = new Exercise();
        exercise.takeInputForTest(70, 1.75, 45, 25);
        exercise.suggestWorkout();
    }

    @Test
    void testSuggestWorkoutLongDuration() {
        Exercise exercise = new Exercise();
        exercise.takeInputForTest(70, 1.75, 70, 25);
        exercise.suggestWorkout();
    }

    @Test
    void testSuggestFoodBasedOnBMI() {
        Exercise exercise = new Exercise();
        exercise.takeInputForTest(70, 1.75, 30, 25);

        List<Recipe> sampleRecipes = new ArrayList<>();
        sampleRecipes.add(new Recipe("Salad", "Calories: 150"));
        sampleRecipes.add(new Recipe("Smoothie", "Calories: 350"));
        sampleRecipes.add(new Recipe("Pasta", "Calories: 500"));

        exercise.suggestFoodBasedOnBMI(sampleRecipes);
    }
}