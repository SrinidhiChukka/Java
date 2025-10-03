import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    private int correctOption;
    private String difficulty;

    public Question(String questionText, List<String> options, int correctOption, String difficulty) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
        this.difficulty = difficulty;
    }

    // Getters
    public String getQuestionText() { return questionText; }
    public List<String> getOptions() { return options; }
    public int getCorrectOption() { return correctOption; }
    public String getDifficulty() { return difficulty; }
}
