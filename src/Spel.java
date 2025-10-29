import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Spel extends JFrame implements ActionListener {
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
        newGameButton.addActionListener(this);

        gamePanel.setLayout(new GridLayout(4,4));

        add(controlPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);

        //pack();
        setSize(500,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGameButton) {
            List<JButton> buttonList = new ArrayList<>(List.of(button1, button2, button3, button4, button5, button6, button7, button8,
                    button9, button10, button11, button12, button13, button14, button15, blankButton));
            Collections.shuffle(buttonList);
            for (JButton b : buttonList) {
                gamePanel.add(b);
            }
            gamePanel.revalidate();
            gamePanel.repaint();
        }
    }


    void main() {}


}
