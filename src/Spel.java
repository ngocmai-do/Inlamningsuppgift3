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
    private JButton winGameStimulation = new JButton("Secret button");
    private JLabel winGameLabel = new JLabel(" ");

    private JPanel gamePanel = new JPanel();
    private JButton blankButton = new JButton("");

    // all buttons within the game is saved in this button list for ease of generating game and control the movement of each button
    List<JButton> buttonList = new ArrayList<>();


    public Spel() {
        controlPanel.setLayout(new GridLayout(1,3));
        controlPanel.add(newGameButton);
        controlPanel.add(winGameStimulation);
        controlPanel.add(winGameLabel);
        newGameButton.addActionListener(this);

        gamePanel.setLayout(new GridLayout(4,4));

        for (int i = 1; i < 16; i++) {       // generate 15 buttons with numbers and add it to button list
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(this);
            buttonList.add(button);
        }
        buttonList.add(blankButton);


        add(controlPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);

        setSize(500,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGameButton) {
            gameGenerate();
        } else if (buttonList.contains(e.getSource())) {
            JButton selectedButton = (JButton) e.getSource();
            movingButton(selectedButton);
        }
    }


    // this method generate a new game with click of "new game" button, list of buttons is used here together with shuffle to create random order or buttons
    public void gameGenerate() {
        Collections.shuffle(buttonList);
        gamePanel.removeAll();
        for (JButton b : buttonList) {
            gamePanel.add(b);
        }
        gamePanel.revalidate();
        gamePanel.repaint();
    }


    public void movingButton(JButton selectedButton) {

        int buttonIndex = buttonList.indexOf(selectedButton);
        int blankButtonIndex = buttonList.indexOf(blankButton);

        if (buttonIndex == 0 && (buttonIndex + 1 == blankButtonIndex || buttonIndex + 4 == blankButtonIndex)) {
            Collections.swap(buttonList, buttonIndex, blankButtonIndex);
        }

        else if (buttonIndex == 3 && (buttonIndex - 1 == blankButtonIndex || buttonIndex + 4 == blankButtonIndex)) {
            Collections.swap(buttonList, buttonIndex, blankButtonIndex);
        }

        else if (buttonIndex == 12 && (buttonIndex + 1 == blankButtonIndex || buttonIndex - 4 == blankButtonIndex)) {
            Collections.swap(buttonList, buttonIndex, blankButtonIndex);
        }

        else if (buttonIndex == 15 && (buttonIndex - 1 == blankButtonIndex || buttonIndex - 4 == blankButtonIndex)) {
            Collections.swap(buttonList, buttonIndex, blankButtonIndex);
        }

        else if ((buttonIndex == 1 || buttonIndex == 2) &&
                (buttonIndex + 1 == blankButtonIndex || buttonIndex + 4 == blankButtonIndex || buttonIndex - 1 == blankButtonIndex)) {
            Collections.swap(buttonList, buttonIndex, blankButtonIndex);
        }

        else if ((buttonIndex == 4 || buttonIndex == 8) &&
                (buttonIndex + 1 == blankButtonIndex || buttonIndex + 4 == blankButtonIndex || buttonIndex - 4 == blankButtonIndex)) {
            Collections.swap(buttonList, buttonIndex, blankButtonIndex);
        }

        else if ((buttonIndex == 7 || buttonIndex == 11) &&
                (buttonIndex - 1 == blankButtonIndex || buttonIndex + 4 == blankButtonIndex || buttonIndex - 4 == blankButtonIndex)) {
            Collections.swap(buttonList, buttonIndex, blankButtonIndex);
        }

        else if ((buttonIndex == 13 || buttonIndex == 14) &&
                (buttonIndex - 1 == blankButtonIndex || buttonIndex + 1 == blankButtonIndex || buttonIndex - 4 == blankButtonIndex)) {
            Collections.swap(buttonList, buttonIndex, blankButtonIndex);
        }

        else if ((buttonIndex == 5 || buttonIndex == 6 || buttonIndex == 9 || buttonIndex == 10) &&
                (buttonIndex - 1 == blankButtonIndex || buttonIndex + 1 == blankButtonIndex || buttonIndex + 4 == blankButtonIndex || buttonIndex - 4 == blankButtonIndex)) {
                Collections.swap(buttonList, buttonIndex, blankButtonIndex);
        }

        gamePanel.removeAll();

        for (JButton b : buttonList) {
            gamePanel.add(b);
        }

        gamePanel.revalidate();
        gamePanel.repaint();
    }

    void main() {}

}
