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
    private JButton winGameStimulation = new JButton("Secret button");    // button to stimulate a game that can be easily win
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
        winGameStimulation.addActionListener(this);

        gamePanel.setLayout(new GridLayout(4,4));

        for (int i = 1; i < 16; i++) {       // generate 15 buttons with numbers and add it to button list
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(this);
            buttonList.add(button);
        }
        buttonList.add(blankButton);   //blank button is added to list manually


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

    // this "moving-Button" method control the movement of each number button:
    // using the button list from gameGenerate method in the 4 by 4 game panel, we will have the following matrix of index of the buttons in the list:

    // row/column     0  1  2  3
    //       0      | 0| 1| 2| 3|
    //       1      | 4| 5| 6| 7|
    //       2      | 8| 9|10|11|
    //       3      |12|13|14|15|

    // the method will get the row and column of the clicked button and the blank button and compare those
    // if they are the same row then we check their column, if the difference of column is 1 -> they are next to each other and can be swapped
    // otherwise they are not to be swapped (same logic if it is on the same column, then we check their row)

    public void movingButton(JButton selectedButton) {

        int buttonIndex = buttonList.indexOf(selectedButton);
        int buttonIndexRow = buttonIndex / 4;           // every row of the index matrix increased by 4, so in order to get row number of a button, we need to divide by 4
        int buttonIndexColumn = buttonIndex % 4;        // get column number of a button by get the rest of the index divided to 4

        int blankButtonIndex = buttonList.indexOf(blankButton);
        int blankButtonIndexRow = blankButtonIndex / 4;
        int blankButtonIndexColumn = blankButtonIndex % 4;

        if (buttonIndexRow == blankButtonIndexRow && Math.abs(buttonIndexColumn - blankButtonIndexColumn) == 1) {
            Collections.swap(buttonList, buttonIndex, blankButtonIndex);    // the swap of buttons happened in the button list
        } else if (buttonIndexColumn == blankButtonIndexColumn && Math.abs(buttonIndexRow - blankButtonIndexRow) == 1) {
            Collections.swap(buttonList, buttonIndex, blankButtonIndex);
        }

        gamePanel.removeAll();    // remove old panel

        for (JButton b : buttonList) {    // readded new buttons to the panel from the new list of buttons
            gamePanel.add(b);
        }

        gamePanel.revalidate();
        gamePanel.repaint();
    }

    void main() {}

}
