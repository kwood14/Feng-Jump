import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FengJump extends JPanel implements ActionListener {

    private Image background;
    private Image playerImage;
    private Image logImage, logImage1;
    private Timer timer;
    private Player player;
    private Log log, log1;
    private boolean jump = true;
    private boolean paused = false;
    private boolean mainMenu = true;
    int speed = 1;
    int speed1 = 1;
    
    public FengJump()
    {
        player = new Player();
        log = new Log();
        log1 = new Log();
        
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new Adapter());
        
        try {
            background = ImageIO.read(new File("src/main/resources/background.png"));
            playerImage = ImageIO.read(new File("src/main/resources/feng.png"));
            logImage = ImageIO.read(new File("src/main/resources/log.png"));        
            logImage1 = ImageIO.read(new File("src/main/resources/log.png"));
            
        } catch (IOException e) {
        }

        player.setX(0);
        player.setY(0);

        timer = new Timer(5, this);
        timer.start();
    }
    
    public void restart() {
        player = new Player();
        log = new Log();
        log1 = new Log();
        
        player.setX(0);
        player.setY(0);
        speed = 1;
        speed1 = 1;
    }

    @Override
    public void paint(Graphics g)
    {
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(background, 0, 0, this);
        if(mainMenu) {
            graphics.setFont(new Font("Monospaced", Font.BOLD, 50));
            graphics.drawString("FENG JUMP", 150, 200);
            graphics.setFont(new Font("Arial", Font.BOLD, 20));
            graphics.drawString("Press Enter to Begin", 175, 280);
        }
        else if(paused) {
            graphics.setFont(new Font("Arial", Font.BOLD, 30));
            graphics.drawString("Paused", 225, 200);
            graphics.setFont(new Font("Arial", Font.BOLD, 20));
            graphics.drawString("Press (P) to Unpause", 175, 280);
        }
        else {
            //250 is where grass is at
            graphics.drawImage(playerImage,player.getX(),250 - player.getY(),this);
            
            graphics.drawImage(logImage,600 + log.getX(),275 - log.getY(),50,50,this);
            graphics.drawImage(logImage1,900 + log1.getX(),275 - log1.getY(),50,50,this);
            
            graphics.setColor(Color.WHITE);
        }
        
        
        g.dispose();

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!mainMenu) {
            if(!paused) {
                int logX = log.getX() + 600;
                int log1X = log1.getX() + 900;
                int logY = log.getY();
                int log1Y = log1.getY();
                int playerX = player.getX();
                int playerY = player.getY();
                /*System.out.println("LOG X:" + logX);
                System.out.println("LOG Y:" + logY);
                System.out.println("LOG1 X:" + log1X);
                System.out.println("LOG1 Y:" + log1Y);
                System.out.println("PLAYER X: " + playerX);
                System.out.println("PLAYER Y: " + playerY);
                System.out.println("------------");*/
                if(playerX <= logX + 3 && playerX >= logX - 3) {
                    if(playerY <= logY + 3 && playerY >= logY - 3) {
                        mainMenu = true;
                        restart();
                    }
                }
                
                if(playerX <= log1X + 3 && playerX >= log1X - 3) {
                    if(playerY <= log1Y + 3 && playerY >= log1Y - 3) {
                        mainMenu = true;
                        restart();
                    }
                }
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
                    if(speed < 4) {
                        speed++;
                    }
                }
                if(log1.getX() < -920) {
                    log1.setX(0);
                    if(speed1 < 4) {
                        speed1++;
                    }
                }
                log.setX(log.getX() - speed);
                log1.setX(log1.getX() - speed1);
            }
        }
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
                        if(player.getY() == 0) {
                            player.setDy(-2);
                            player.setY(0);
                        }
                        player.setY(0);
                        break;
                    case KeyEvent.VK_W:
                        if(player.getY() == 0) {
                            player.setDy(-2);
                            player.setY(0);
                        }
                        player.setY(0);
                        break;
                    case KeyEvent.VK_A:
                        if(player.getDY() != 0) {
                            player.setDx(0);
                            player.setY(0);
                        }
                        if(player.getX() < 0) {
                            player.setDx(0);
                            player.setX(0);
                        }
                        else {
                            player.setDx(-1);
                        }
                        break;
                    case KeyEvent.VK_D:
                        if(player.getDY() != 0) {
                            player.setDx(0);
                            player.setY(0);
                        }
                        if(player.getX() > 600) {
                            player.setDx(0);
                            player.setX(600);
                        }
                        else {
                            player.setDx(1);
                        }
                        break;
                    case KeyEvent.VK_P:
                        paused = !paused;
                        break;
                    case KeyEvent.VK_ENTER:
                        mainMenu = false;
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
                    case KeyEvent.VK_W:
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
