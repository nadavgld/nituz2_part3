import java.util.HashMap;

public abstract class QuizStates implements ssState{
    protected StudentSystem studentSystem;

    private ssState currentState;

    public QuizStates(StudentSystem ss){
        this.studentSystem = ss;
    }

    public ssState getCurrentState() {
        return currentState;
    }

    public void setCurrent(ssState current){
        this.currentState = current;
        enterState();
    }


    public void answerQuiz() {
        HashMap<Integer, Integer> _quiz = this.studentSystem.get_quiz();
        int _week = this.studentSystem.get_week();

        if (_quiz.containsKey(_week)) {
            System.out.println("Already answered this questionnaire");
        } else {
            _quiz.put(_week, 1);
        }
        this.studentSystem.set_quiz(_quiz);

        this.currentState = this.studentSystem.getQuizDisabled();
        enterState();
    }


    @Override
    public String status(String text) {
        return this.currentState.status(text);
    }

    @Override
    public void enterState() {
        this.currentState.enterState();
    }

}
