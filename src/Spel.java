import javax.swing.*;
import java.awt.*;

public class Spel extends JFrame {
    private JPanel controlPanel = new JPanel();
    private JButton newGameButton = new JButton("New game");
    private JLabel winGameLabel = new JLabel(" ");

    private JPanel gamePanel = new JPanel();
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");
    private JButton button4 = new JButton("4");
    private JButton button5 = new JButton("5");
    private JButton button6 = new JButton("6");
    private JButton button7 = new JButton("7");
    private JButton button8 = new JButton("8");
    private JButton button9 = new JButton("9");
    private JButton button10 = new JButton("10");
    private JButton button11 = new JButton("11");
    private JButton button12 = new JButton("12");
    private JButton button13 = new JButton("13");
    private JButton button14 = new JButton("14");
    private JButton button15 = new JButton("15");
    private JButton blankButton = new JButton("");

    public Spel() {
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(newGameButton);
        controlPanel.add(winGameLabel);

        gamePanel.setLayout(new GridLayout(4,4));
        gamePanel.add(button1);
        gamePanel.add(button2);
        gamePanel.add(button3);
        gamePanel.add(button4);
        gamePanel.add(button5);
        gamePanel.add(button6);
        gamePanel.add(button7);
        gamePanel.add(button8);
        gamePanel.add(button9);
        gamePanel.add(button10);
        gamePanel.add(button11);
        gamePanel.add(button12);
        gamePanel.add(button13);
        gamePanel.add(button14);
        gamePanel.add(button15);
        gamePanel.add(blankButton);

        add(controlPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);

        //pack();
        setSize(500,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void main() {}
}
