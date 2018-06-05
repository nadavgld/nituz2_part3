public class Pass extends ExamStates {

    public Pass(StudentSystem ss) {
        super(ss);
    }

    public String status(String txt){
        return txt+":)";
    }

    public void enterState(){
        System.out.println("Entered Pass State");
    }


}
