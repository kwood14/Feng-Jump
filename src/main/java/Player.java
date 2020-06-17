
public class Player {
    private int x, y;
    private int dx, dy;
    private boolean dead;
    private Controls controls;

    public Player() {
        x = 0;
        y = 0;
        dead = false;
    }

    public int getX() {
        return x;
    }
    
    public int getDX() {
        return dx;
    }
    
    public int getDY() {
        return dy;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setDx(int d) {
        this.dx = d;
    }

    public void setDy(int d) {
        this.dy = d;
    }

    public int getY() {
        return y;
    }

    public void setY(int num) {

        this.y = num;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
    
    public Controls getControls() {
        return controls;
    }
    
    public void setControls(Controls controls) {
        this.controls = controls;
    }

}
