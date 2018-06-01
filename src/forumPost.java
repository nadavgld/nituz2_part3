public class forumPost extends ssStateClass {

    public forumPost(StudentSystem system){
        super(system);
    }

    @Override
    public String print() {

//        return "forumPost";

        try {
            if (this.studentSystem.get_forum().get(this.studentSystem.get_week()) >= 2) {
                return "Active Student";
            }
        } catch (Exception e) { }

        return "Not Active Student";
    }

}
