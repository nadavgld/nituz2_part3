import java.util.HashMap;

public abstract class ssStateClass implements ssState{
    protected StudentSystem studentSystem;

    public ssStateClass(StudentSystem system){
        this.studentSystem = system;
    }

    @Override
    public void exam(int score) {
        this.studentSystem.set_exam(score);

        this.studentSystem.setState(this.studentSystem.getExamSubmitState());
    }

    @Override
    public void readArticle() {
        int articles = this.studentSystem.get_articles();

        if(articles < 12){
            this.studentSystem.set_articles(articles + 1);
        }

        this.studentSystem.setState(this.studentSystem.getReadArticleState());
    }

    @Override
    public void post(String text) {
        HashMap<Integer, Integer> _forum = this.studentSystem.get_forum();
        int _week = this.studentSystem.get_week();

        if (_forum.containsKey(_week)) {
            _forum.put(_week, _forum.get(_week) + 1);
        } else {
            _forum.put(_week, 1);
        }

        this.studentSystem.set_forum(_forum);

        this.studentSystem.setState(this.studentSystem.getForumPostState());
    }

    @Override
    public void answerQuiz() {
        HashMap<Integer, Integer> _quiz = this.studentSystem.get_quiz();
        int _week = this.studentSystem.get_week();

        if (_quiz.containsKey(_week)) {
            System.out.println("Already answered this questionnaire");
        } else {
            _quiz.put(_week, 1);
        }

        this.studentSystem.set_quiz(_quiz);

//        this.studentSystem.setState(this.studentSystem.getQuizAnswerState());
    }

    @Override
    public void nextWeek() {
        int week = this.studentSystem.get_week();

        if(week < 12){
            this.studentSystem.set_week(week + 1);
        }
    }

    @Override
    public void status(String text) {
        System.out.println(this.studentSystem.printStatus(text));
    }
}
