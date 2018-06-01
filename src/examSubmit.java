public class examSubmit extends ssStateClass {

    public examSubmit(StudentSystem system) {
        super(system);
    }

    @Override
    public String print() {
//        return "examSubmit";
        if (this.studentSystem.get_exam() >= 90) {
            return "Excellent Student";
        }

        if (this.studentSystem.get_exam() >= 56)
            return "Passed Test";

        if (this.studentSystem.get_exam() < 56)
            return "Failed in test";

        return "Didnt take the test (Idle)";
    }
}
