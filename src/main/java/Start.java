import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Developed by Kai Wood
 */
public class Start {


    public Start() {
        
        JFrame frame = new JFrame("Feng Jump Beta V1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setJMenuBar(menu());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        FengJump fj = new FengJump();
        frame.add(fj);

        try {
            Image icon = Toolkit.getDefaultToolkit().getImage("src/main/resources/FengJump.png");
            frame.setIconImage(icon);
        }
        catch (Exception ex) {
            System.out.println("Unable to open icon image");
        }
        
        frame.setVisible(true);
    }
    
    public JMenuBar menu()
    {
        // Create a MenuBar
        JMenuBar menu = new JMenuBar();
        
        // Create a Game menu
        JMenu game = new JMenu("Game");

        // Close out the screen
        JMenuItem close = new JMenuItem("Close");
        close.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        JMenuItem restart = new JMenuItem("Restart");
        
        game.add(restart);
        game.add(close);
        

        // Create a Help menu
        JMenu help = new JMenu("Help");

        JMenuItem about = new JMenuItem("About");
        about.addActionListener((e) -> {
            JOptionPane.showMessageDialog(null, "<html><strong>Feng Jump Beta V1.0</strong><br><br> "
                    + "Developed by Kai Wood<br><br>"
                    + "<br></html>", "About", 1);
        });
        
        JMenuItem htp = new JMenuItem("How to Play");
        htp.addActionListener((e) -> {
            JOptionPane.showMessageDialog(null, "<html>"
                    + "Up - <strong>W</strong><br>"
                    + "Down - <strong>S</strong><br>"
                    + "Left - <strong>A</strong><br>"
                    + "Right - <strong>D</strong><br><br>"
                    + "</html>", "How to play", JOptionPane.QUESTION_MESSAGE);
        });

        help.add(htp);
        help.add(about);

        menu.add(game);
        menu.add(help);

        return menu;
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new Start();
        });
    }

}