import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FengJump extends JPanel implements ActionListener {

    private final Image background;
    private final Image playerImage;
    private final Image logImage;
    private final Timer timer;
    private Player player;
    private Log log;
    private boolean jump = true;
    
    public FengJump()
    {
        player = new Player();
        log = new Log();
        
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new Adapter());
        
        background = Toolkit.getDefaultToolkit().getImage("src/main/resources/background.png");

        playerImage = Toolkit.getDefaultToolkit().getImage("src/main/resources/feng.png");
        
        logImage = Toolkit.getDefaultToolkit().getImage("src/main/resources/log.png");
        
        player.setX(0);
        player.setY(0);

        timer = new Timer(5, this);
        timer.start();
    }
    
    public Player getPlayer() {
        return player;
    }

    @Override
    public void paint(Graphics g)
    {

        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(background, 0, 0, this);

        //250 is where grass is at
        graphics.drawImage(playerImage,getPlayer().getX(),250 - getPlayer().getY(),this);
        
        graphics.drawImage(logImage,600 + log.getX(),275 - log.getY(),50,50,this);
        
        graphics.setColor(Color.WHITE);
        
        g.dispose();

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        player.setX(player.getX() + player.getDX());
        
        if(player.getY() < 50)
        {
            player.setY(player.getY() - player.getDY());
        }
        else {
            jump = false;
        }
        if(log.getX() < -620) {
            log.setX(0);
        }
        log.setX(log.getX() - 1);
        //player.setX(player.getX() + 1);
        //player.setY(player.getY() - 1);
        repaint();
    }
    
    private class Adapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e)
        {
            int pressed = e.getKeyCode();
            
            if (!player.isDead()) {
                switch (pressed) {
                    case KeyEvent.VK_SPACE:
                        player.setDy(-2);
                        player.setY(0);
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

        @Override
        public void keyReleased(KeyEvent e)
        {
            int pressed = e.getKeyCode();

            if (!player.isDead()) {
                switch (pressed) {
                    case KeyEvent.VK_SPACE:
                        player.setDy(0);
                        player.setY(0);
                        jump = true;
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
}
