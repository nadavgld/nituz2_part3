public class Idle extends PostStates {

    public Idle(StudentSystem ss) {
        super(ss);
    }

    public String status(String txt){
        return txt;
    }

    public void enterState(){
        System.out.println("Entered Idle-forum-posting State");
    }
}
