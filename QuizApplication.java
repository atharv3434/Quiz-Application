import java.util.ArrayList;
import java.util.Scanner;

// Class representing a Quiz Question
class Question {
    private String question;
    private String[] options;
    private int correctAnswerIndex;

    // Constructor
    public Question(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    // Display the question and options
    public void displayQuestion() {
        System.out.println("\n" + question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    // Check if the user's answer is correct
    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctAnswerIndex + 1; // +1 because array index starts at 0
    }
}

// Main Quiz Class
public class QuizApplication {
    private static ArrayList<Question> questions = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeQuestions();
        System.out.println("\nWelcome to the Java Quiz!");
        System.out.println("Select the correct option (1-4) for each question.\n");

        int score = 0;

        for (Question q : questions) {
            q.displayQuestion();
            int userAnswer = getUserAnswer();
            if (q.isCorrect(userAnswer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Incorrect!\n");
            }
        }

        System.out.println("Quiz Completed! 🎉");
        System.out.println("Your final score: " + score + " out of " + questions.size());
    }

    // Method to get valid user input (1-4)
    private static int getUserAnswer() {
        int choice;
        while (true) {
            System.out.print("Your answer (1-4): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 4) {
                    return choice;
                }
            }
            System.out.println("Invalid input! Please enter a number between 1 and 4.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    // Initialize quiz questions
    private static void initializeQuestions() {
        questions.add(new Question("What is the capital of France?",
                new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 2));
        questions.add(new Question("Which programming language is used for Android development?",
                new String[]{"Swift", "Kotlin", "JavaScript", "C#"}, 1));
        questions.add(new Question("Which data structure follows LIFO (Last In, First Out)?",
                new String[]{"Queue", "Array", "Stack", "Linked List"}, 2));
        questions.add(new Question("Who developed Java?",
                new String[]{"Dennis Ritchie", "James Gosling", "Guido van Rossum", "Bjarne Stroustrup"}, 1));
        questions.add(new Question("Which keyword is used to define a constant variable in Java?",
                new String[]{"static", "final", "const", "var"}, 1));
    }
}
