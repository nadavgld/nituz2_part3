public class Excellent extends ExamStates {

    public Excellent(StudentSystem ss) {
        super(ss);
    }

    public String status(String txt){
        return "^^^" + txt + "^^^";
    }

    public void enterState(){
        System.out.println("Entered Excellent State");
    }


}
