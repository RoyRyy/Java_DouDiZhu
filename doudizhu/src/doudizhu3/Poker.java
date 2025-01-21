package doudizhu3;

public class Poker {
    private String pokerName;
    private boolean up;

    public Poker(String pokerName, boolean up) {
        this.pokerName = pokerName;
        this.up = up;
    }

    public String turnFront() {
        return this.pokerName;
    }

    public String turnRear() {
        return "背面";
    }

    public String getPokerName() {
        return this.pokerName;
    }

    public void setPokerName(String pokerName) {
        this.pokerName = pokerName;
    }

    public boolean isUp() {
        return this.up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public String toString() {
        return this.up ? this.pokerName : "背面";
    }
}
