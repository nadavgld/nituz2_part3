public abstract class ExamStates implements ssState{
    protected StudentSystem studentSystem;

    private ssState currentState;

    public ExamStates(StudentSystem ss){
        this.studentSystem = ss;
    }

    public ssState getCurrentState() {
        return currentState;
    }

    public void setCurrent(ssState current){
        this.currentState = current;
        enterState();
    }

    public void exam(int score) {
        this.studentSystem.set_exam(score);

        if(this.studentSystem.get_articles() > 0) {
            if (score < 56)
                this.currentState = this.studentSystem.getFail();
            else if (score < 90)
                this.currentState = this.studentSystem.getPass();
            else
                this.currentState = this.studentSystem.getExcellent();
        }
        enterState();
    }

    @Override
    public String status(String text) {
        return this.currentState.status(text);
    }

    @Override
    public void enterState() {
        this.currentState.enterState();
    }

}
