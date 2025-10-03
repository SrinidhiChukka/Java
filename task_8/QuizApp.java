
import java.util.*;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        // Sample questions
        questions.add(new Question("Java is a ___ language?", Arrays.asList("A. Programming", "B. Markup", "C. Database", "D. OS"), 1, "easy"));
        questions.add(new Question("OOP stands for?", Arrays.asList("A. Object Oriented Programming","B. Open Office Program","C. Online Operation Protocol","D. None"), 1, "easy"));
        questions.add(new Question("Which of these is a valid Java identifier?", Arrays.asList("A. 1variable","B. var_name","C. @name","D. #value"), 2, "medium"));

        int score = 0;
        String currentDifficulty = "easy";

        for(int i = 0; i < questions.size(); i++){
            Question q = questions.get(i);
            if(!q.getDifficulty().equals(currentDifficulty)) continue;

            System.out.println(q.getQuestionText());
            for(String option : q.getOptions()) System.out.println(option);

            System.out.print("Enter your choice: ");
            String input = sc.next().toUpperCase();
            int ans = 0;
            
            // Convert letter choice to number (A=1, B=2, C=3, D=4)
            switch(input) {
                case "A": ans = 1; break;
                case "B": ans = 2; break;
                case "C": ans = 3; break;
                case "D": ans = 4; break;
                default:
                    try {
                        ans = Integer.parseInt(input);
                    } catch(NumberFormatException e) {
                        ans = 0; // Invalid choice
                    }
            }

            if(ans == q.getCorrectOption()){
                System.out.println("Correct!\n");
                score += 10;
                if(currentDifficulty.equals("easy")) currentDifficulty = "medium";
                else if(currentDifficulty.equals("medium")) currentDifficulty = "hard";
            } else {
                System.out.println("Wrong! Correct answer: " + q.getCorrectOption() + "\n");
                if(currentDifficulty.equals("hard")) currentDifficulty = "medium";
                else if(currentDifficulty.equals("medium")) currentDifficulty = "easy";
            }
        }

        System.out.println("Quiz Over! Your Score: " + score);
        sc.close();
    }
}
