public class Inactive extends PostStates {

    public Inactive(StudentSystem ss) {
        super(ss);
    }

    public String status(String txt){
        return txt;
    }

    public void enterState(){
        System.out.println("Entered Inactive-forum-posting State");
    }
}
