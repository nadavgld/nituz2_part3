import java.util.HashMap;

public abstract class PostStates implements ssState{
    protected StudentSystem studentSystem;

    private ssState currentState;

    public PostStates(StudentSystem ss){
        this.studentSystem = ss;
    }

    public ssState getCurrentState() {
        return currentState;
    }

    public void setCurrent(ssState current){
        this.currentState = current;
        enterState();
    }

    public void post(String text) {
        HashMap<Integer, Integer> _forum = this.studentSystem.get_forum();
        int _week = this.studentSystem.get_week();

        if (_forum.containsKey(_week)) {
            _forum.put(_week, _forum.get(_week) + 1);
        } else {
            _forum.put(_week, 1);
        }

        int _posts = _forum.get(_week);

        this.studentSystem.set_forum(_forum);

        if(_posts >= 2)
            this.currentState = this.studentSystem.getActive();
        else
            this.currentState = this.studentSystem.getInactive();

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
