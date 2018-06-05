import java.util.HashMap;

public abstract class ArticleStates implements ssState{
    protected StudentSystem studentSystem;

    private ssState currentState;

    public ArticleStates(StudentSystem ss){
        this.studentSystem = ss;
    }

    public ssState getCurrentState() {
        return currentState;
    }

    public void setCurrent(ssState current){
        this.currentState = current;
        enterState();
    }

    protected void readArticle() {
        int articles = this.studentSystem.get_articles();

        if(articles < 10){
            this.studentSystem.set_articles(articles + 1);
        }else{
            System.out.println("No more articles to read");
        }

        articles++;

        if (articles > 7) {
            this.currentState = this.studentSystem.getResearcher();
        } else if (this.studentSystem.get_articles() >= 3)
            this.currentState = this.studentSystem.getDiligent();
        else
            this.currentState = this.studentSystem.getRegular();

        enterState();
    }
//
//    @Override
//    public void answerQuiz() {
//        HashMap<Integer, Integer> _quiz = this.studentSystem.get_quiz();
//        int _week = this.studentSystem.get_week();
//
//        if (_quiz.containsKey(_week)) {
//            System.out.println("Already answered this questionnaire");
//        } else {
//            _quiz.put(_week, 1);
//        }
//
//        this.studentSystem.set_quiz(_quiz);
//
////        this.studentSystem.setState(this.studentSystem.getQuizAnswerState());
//    }
//

    @Override
    public String status(String text) {
        return this.currentState.status(text);
    }

    @Override
    public void enterState() {
        this.currentState.enterState();
    }

}
