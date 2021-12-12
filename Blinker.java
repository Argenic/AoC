package AoC.year21;

public class Blinker {
    private boolean blinked;
    private int value;
    private int x;
    private int y;
    
    public Blinker(int value, int x, int y) {
        blinked = false;
        this.value = value;
        this.x = x;
        this.y = y;
    }
    
    public boolean increment() {
        if(blinked) {
            return false;
        } else if(value < 9) {
            value += 1;
            return false;
        } else {
            value = 0;
            blinked = true;
            return true;
        }
    }
    
    public void newStep() {
        this.blinked = false;
    }
    
    public int getValue() {
        return value;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}