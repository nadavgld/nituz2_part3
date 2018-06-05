public class Regular extends ArticleStates {

    public Regular(StudentSystem ss) {
        super(ss);
    }

    public String status(String txt){
        return txt;
    }

    public void enterState(){
        System.out.println("Entered Regular-student State");
    }


}
