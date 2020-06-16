import java.awt.Image;


public class Player {
    private int x, y;
    private int dx, dy;
    private boolean dead;
    private Image playerIcon;

    public Player() {
        x = 0;
        y = 0;
    }
    
    public Image getPlayerIcon() {
        return playerIcon;
    }

    public int getX() {
        return x;
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

}
