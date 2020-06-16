import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
        
        //---------------------------------------------------


        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(heroControlPanel, BorderLayout.CENTER);
        mainPanel.add(outputTextArea, BorderLayout.SOUTH);


        
        
        frame.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setSize(new Dimension(800, 650));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        
        JMenuBar menubar = new JMenuBar();
        JMenu home = new JMenu("Home");
        JMenuItem choose = new JMenuItem("Pick a Character");
        JMenu about = new JMenu("About");
        JMenuItem credit = new JMenuItem("Author");
        home.add(choose);
        about.add(credit);
        menubar.add(home);
        menubar.add(about);
        frame.setJMenuBar(menubar);

        //Button Listeners
        startButton.addActionListener((e) -> {
            //String english = outputTextArea.getText().trim();
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