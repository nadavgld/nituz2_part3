public class Diligent extends ArticleStates {

    public Diligent(StudentSystem ss) {
        super(ss);
    }

    public String status(String txt){
        return "*"+txt+"*";
    }

    public void enterState(){
        System.out.println("Entered Diligent-student State");
    }
}
