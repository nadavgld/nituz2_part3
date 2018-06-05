public class Active extends PostStates {

    public Active(StudentSystem ss) {
        super(ss);
    }

    public String status(String txt){
        return txt+"(active)";
    }

    public void enterState(){
        System.out.println("Entered Active-forum-posting State");
    }
}
