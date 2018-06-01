import java.util.HashMap;

public class StudentSystem {
    private int _week;
    private int _articles;
    private HashMap<Integer, Integer> _forum;
    private HashMap<Integer, Integer> _quiz;
    private int _exam = -1;

    private ssState readArticleState;
    private ssState examSubmitState;
    private ssState forumPostState;
    private ssState quizAnswerState;
    private ssState newSemesterState;

    private ssState currentState;

    public StudentSystem() {
        this._week = 1;
        this._articles = 0;
        this._forum = new HashMap<>();
        this._quiz = new HashMap<>();
        this._exam = -1;

        this.readArticleState = new readArticle(this);
        this.examSubmitState = new examSubmit(this);
        this.forumPostState = new forumPost(this);
        this.quizAnswerState = new quizAnswer(this);
        this.newSemesterState = new newSemester(this);

        this.setState(this.newSemesterState);
    }

    public void setState(ssState newState) {
        System.out.println("enter " + newState.print() + " state");
        this.currentState = newState;
    }

    public String printStatus(String input) {

        if (this._articles > 7) {
            input = "**" + input + "**";
        } else if (this._articles >= 3 && this._articles <= 7)
            input = "*" + input + "*";

        try {
            if (this._forum.get(this._week) >= 2) {
                input = input + "(active)";
            }
        } catch (Exception e) {
//            System.out.println(e);
        }

        boolean got90Plus = false;
        if (this._exam >= 90) {
            got90Plus = true;
            input = "^^^" + input + "^^^";
        }

        if (this._exam >= 56 && !got90Plus)
            input = input + ":)";

        return input;
    }

    public ssState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ssState currentState) {
        this.currentState = currentState;
    }

    public int get_week() {
        return _week;
    }

    public void set_week(int _week) {
        this._week = _week;
    }

    public int get_articles() {
        return _articles;
    }

    public void set_articles(int _articles) {
        this._articles = _articles;
    }

    public HashMap<Integer, Integer> get_forum() {
        return _forum;
    }

    public void set_forum(HashMap<Integer, Integer> _forum) {
        this._forum = _forum;
    }

    public HashMap<Integer, Integer> get_quiz() {
        return _quiz;
    }

    public void set_quiz(HashMap<Integer, Integer> _quiz) {
        this._quiz = _quiz;
    }

    public int get_exam() {
        return _exam;
    }

    public void set_exam(int _exam) {
        if (_articles == 0) {
            System.out.println("No article has been read - cannot do the exam");
        } else {
            this._exam = _exam;
        }
    }

    public ssState getReadArticleState() {
        return readArticleState;
    }

    public ssState getExamSubmitState() {
        return examSubmitState;
    }

    public ssState getForumPostState() {
        return forumPostState;
    }

    public ssState getQuizAnswerState() {
        return quizAnswerState;
    }
}
