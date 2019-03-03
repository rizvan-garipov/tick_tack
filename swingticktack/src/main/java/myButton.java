import javax.swing.*;

public class myButton extends JButton {
    private int xC;
    private int yC;
    private boolean visit;

    public myButton(int x, int y) {
        this.xC = x;
        this.yC = y;
        this.visit = false;
    }

    @Override
    public int getX() {
        return xC;
    }

    @Override
    public int getY() {
        return yC;
    }

    public void setVisit(boolean visit) {
        this.visit = visit;
    }
}
