import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


/**
 * Created by Kai Wood
 */
public class Start {


    public Start() {
        
        JFrame frame = new JFrame("Feng Jump Beta V1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 420);
        frame.setJMenuBar(menu());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        JTextArea outputTextArea = new JTextArea(5,5);
        outputTextArea.setText("Output Here");
        outputTextArea.setLineWrap(true);
        outputTextArea.setWrapStyleWord(true);
        outputTextArea.setMargin(new Insets(5, 5, 5,5));
       
        JButton startButton = new JButton("Start");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setPreferredSize(new Dimension(150,100));
        

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));        
        buttonPanel.add(startButton);

        JPanel heroControlPanel = new JPanel(new BorderLayout());
        heroControlPanel.add(buttonPanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(heroControlPanel, BorderLayout.CENTER);
        mainPanel.add(outputTextArea, BorderLayout.SOUTH);


        
        
        frame.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setSize(new Dimension(800, 650));

        //Button Listeners
        startButton.addActionListener((e) -> {
            outputTextArea.setText("Start Selected");
        });

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