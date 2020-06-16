import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class FengJump extends JPanel implements ActionListener{

    private final Image background;
    private final Image playerImage;
    private final Timer timer;
    private Player player;
    private boolean playing;
    private boolean begin;
    
    public FengJump()
    {
        background = Toolkit.getDefaultToolkit().getImage("src/main/resources/background.png");

        playerImage = Toolkit.getDefaultToolkit().getImage("src/main/resources/feng.png");
        player = new Player();
        
        player.setX(0);
        player.setY(0);

        playing = false;
        begin = true;

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
        
        graphics.setColor(Color.WHITE);
        
        
        g.dispose();

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
