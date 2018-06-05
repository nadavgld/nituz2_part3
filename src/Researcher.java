public class Researcher extends ArticleStates {

    public Researcher(StudentSystem ss) {
        super(ss);
    }

    public String status(String txt){
        return "**"+txt+"**";
    }

    public void enterState(){
        System.out.println("Entered Researcher-student State");
    }
}
