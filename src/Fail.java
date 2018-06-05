public class Fail extends ExamStates {

    public Fail(StudentSystem ss) {
        super(ss);
    }

    public String status(String txt){
        return txt;
    }

    public void enterState(){
        System.out.println("Entered Fail State");
    }


}
