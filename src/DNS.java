public class DNS extends ExamStates {

    public DNS(StudentSystem ss) {
        super(ss);
    }

    public String status(String txt){
        return txt;
    }

    public void enterState(){
        System.out.println("Entered Did-Not-Start-exam State");
    }


}
