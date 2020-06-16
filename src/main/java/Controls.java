import java.awt.event.KeyEvent;


public class Controls {
    
    public void keyPressed(Player player, KeyEvent key)
    {

        int pressed = key.getKeyCode();
        if (!player.isDead()) {
            switch (pressed) {
                case KeyEvent.VK_SPACE:
                    player.setDy(-1);
                    break;
                case KeyEvent.VK_A:
                    player.setDx(-1);
                    break;
                case KeyEvent.VK_D:
                    player.setDx(1);
                    break;
            }
        }
    }

    public void keyReleased(Player player, KeyEvent key)
    {
        int pressed = key.getKeyCode();

        if (!player.isDead()) {
            switch (pressed) {
                case KeyEvent.VK_SPACE:
                    player.setDy(0);
                    break;
                case KeyEvent.VK_A:
                    player.setDx(0);
                    break;
                case KeyEvent.VK_D:
                    player.setDx(0);
                    break;
            }
        }
    }
}
