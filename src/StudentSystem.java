import java.util.HashMap;

public class StudentSystem {
    private int _week;
    private int _articles;
    private HashMap<Integer, Integer> _forum;
    private HashMap<Integer, Integer> _quiz;
    private int _exam;

    private ssState regular = new Regular(this);
    private ssState diligent = new Diligent(this);
    private ssState researcher = new Researcher(this);
    private ssState idle = new Idle(this);
    private ssState inactive = new Inactive(this);
    private ssState active = new Active(this);
    private ssState dns = new DNS(this);
    private ssState fail = new Fail(this);
    private ssState pass = new Pass(this);
    private ssState excellent = new Excellent(this);
    private ssState quizDisabled = new QuizDisabled(this);
    private ssState quizEnabled = new QuizEnabled(this);


    private ArticleStates articleStates = new ArticleStates(this) {
        @Override
        protected void readArticle() {
            super.readArticle();
        }

        @Override
        public String status(String text) {
            return super.status(text);
        }

        @Override
        public void enterState() {
            super.enterState();
        }
    };
    private ExamStates examStates = new ExamStates(this) {
        @Override
        public void exam(int score) {
            super.exam(score);
        }

        @Override
        public String status(String text) {
            return super.status(text);
        }

        @Override
        public void enterState() {
            super.enterState();
        }
    };
    private PostStates postStates = new PostStates(this) {
        @Override
        public void post(String text) {
            super.post(text);
        }

        @Override
        public String status(String text) {
            return super.status(text);
        }

        @Override
        public void enterState() {
            super.enterState();
        }
    };
    private QuizStates quizStates = new QuizStates(this) {
        @Override
        public ssState getCurrentState() {
            return super.getCurrentState();
        }

        @Override
        public void setCurrent(ssState current) {
            super.setCurrent(current);
        }

        @Override
        public void answerQuiz() {
            super.answerQuiz();
        }

        @Override
        public String status(String text) {
            return super.status(text);
        }

        @Override
        public void enterState() {
            super.enterState();
        }
    };

    public StudentSystem() {
        this._week = 1;
        this._articles = 0;
        this._forum = new HashMap<>();
        this._quiz = new HashMap<>();
        this._exam = -1;

        this.articleStates.setCurrent(this.regular);
        this.examStates.setCurrent(this.dns);
        this.postStates.setCurrent(this.idle);
        this.quizStates.setCurrent(this.quizEnabled);
    }

//    public String printStatus(String input) {
//
//        if (this._articles > 7) {
//            input = "**" + input + "**";
//        } else if (this._articles >= 3 && this._articles <= 7)
//            input = "*" + input + "*";
//
//        try {
//            if (this._forum.get(this._week) >= 2) {
//                input = input + "(active)";
//            }
//        } catch (Exception e) {
////            System.out.println(e);
//        }
//
//        boolean got90Plus = false;
//        if (this._exam >= 90) {
//            got90Plus = true;
//            input = "^^^" + input + "^^^";
//        }
//
//        if (this._exam >= 56 && !got90Plus)
//            input = input + ":)";
//
//        return input;
//    }

//    public ssState getCurrentState() {
//        return currentState;
//    }

//    public void setCurrentState(ssState currentState) {
//        this.currentState = currentState;
//    }

    public int get_week() {
        return _week;
    }

    public void set_week(int _week) {
        if(_week <= 12){
            this._week = _week;
            this.postStates.setCurrent(this.idle);
            this.quizStates.setCurrent(this.quizEnabled);
        }else{
            System.out.println("Semester has ended");
        }
    }

    public int get_articles() {
        return _articles;
    }

    public void set_articles(int _articles) {
        if(_articles <= 10)
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

    public ArticleStates getArticleStates() {
        return articleStates;
    }

    public ExamStates getExamStates() {
        return examStates;
    }

    public PostStates getPostStates() {
        return postStates;
    }

    public ssState getRegular() {
        return regular;
    }

    public ssState getDiligent() {
        return diligent;
    }

    public ssState getResearcher() {
        return researcher;
    }

    public ssState getIdle() {
        return idle;
    }

    public ssState getInactive() {
        return inactive;
    }

    public ssState getActive() {
        return active;
    }

    public ssState getDns() {
        return dns;
    }

    public ssState getFail() {
        return fail;
    }

    public ssState getPass() {
        return pass;
    }

    public ssState getExcellent() {
        return excellent;
    }

    public ssState getQuizDisabled() {
        return quizDisabled;
    }

    public ssState getQuizEnabled() {
        return quizEnabled;
    }

    public QuizStates getQuizStates() {
        return quizStates;
    }
}
