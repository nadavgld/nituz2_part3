public class readArticle extends ssStateClass {

    public readArticle(StudentSystem system){
        super(system);
    }

    @Override
    public String print() {
//        return "readArticle";
        if (this.studentSystem.get_articles() > 7) {
            return "Researcher Student";
        } else if (this.studentSystem.get_articles() > 3)
            return "Diligent Student";
        return "Regular Student";
    }
}
