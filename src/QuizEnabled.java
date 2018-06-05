public class QuizEnabled extends QuizStates {

    public QuizEnabled(StudentSystem ss) {
        super(ss);
    }

    public String status(String txt){
        return txt;
    }

    public void enterState(){
        System.out.println("Entered Quiz-enabled State");
    }
}
