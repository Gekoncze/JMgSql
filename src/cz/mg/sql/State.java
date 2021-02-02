package cz.mg.sql;

public class State {
    private Enum state;

    public State(Enum state) {
        this.state = state;
    }

    public Enum getState() {
        return state;
    }

    public void setState(Enum state) {
        if (state.ordinal() < this.state.ordinal()) throw new IllegalStateException("Some methods were called in an illegal order.");
        this.state = state;
    }
}
