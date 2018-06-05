public class QuizDisabled extends QuizStates {

    public QuizDisabled(StudentSystem ss) {
        super(ss);
    }

    public String status(String txt){
        return txt;
    }

    public void enterState(){
        System.out.println("Entered Quiz-disabled State");
    }
}
