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
    private JButton blankButton = new JButton("");

    // all buttons within the game is saved in this button list for ease of generating game and control the movement of each button
    List<JButton> buttonList = new ArrayList<>();


    public Spel() {
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(newGameButton);
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
        for (JButton b : buttonList) {
            gamePanel.add(b);
        }
        gamePanel.revalidate();
        gamePanel.repaint();
    }

    // this "moving-Button" method control the movement of each number button, which take the index of the clicked button and check the button that located next to it
    // if there is a blank space (blank button) next to it then the buttons will swap places
    // a button can only move up, down, left or right which its index corresponds with index of clicked button plus/minus 4 or 1
    // notes: there is special cases with button that is in the 4 corners and 4 sides of the game so the code is also separated into different else-if cases,
    // otherwise we will have problem with button moves incorrectly or out-of-bound problems
    public void movingButton(JButton selectedButton) {

        int buttonIndex = buttonList.indexOf(selectedButton);

        if (buttonIndex == 0) {
            if (buttonList.get(buttonIndex + 1) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex + 1, selectedButton);
            } else if (buttonList.get(buttonIndex + 4) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex + 4, selectedButton);
            }
        }

        else if (buttonIndex == 3) {
            if (buttonList.get(buttonIndex - 1) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex - 1, selectedButton);
            } else if (buttonList.get(buttonIndex + 4) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex + 4, selectedButton);
            }
        }

        else if (buttonIndex == 12) {
            if (buttonList.get(buttonIndex + 1) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex + 1, selectedButton);
            } else if (buttonList.get(buttonIndex - 4) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex - 4, selectedButton);
            }
        }

        else if (buttonIndex == 15) {
            if (buttonList.get(buttonIndex - 1) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex - 1, selectedButton);
            } else if (buttonList.get(buttonIndex - 4) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex - 4, selectedButton);
            }
        }

        else if (buttonIndex == 1 || buttonIndex == 2) {
            if (buttonList.get(buttonIndex + 1) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex + 1, selectedButton);
            } else if (buttonList.get(buttonIndex + 4) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex + 4, selectedButton);
            } else if (buttonList.get(buttonIndex - 1) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex - 1, selectedButton);
            }
        }

        else if (buttonIndex == 4 || buttonIndex == 8) {
            if (buttonList.get(buttonIndex + 1) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex + 1, selectedButton);
            } else if (buttonList.get(buttonIndex + 4) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex + 4, selectedButton);
            } else if (buttonList.get(buttonIndex - 4) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex - 4, selectedButton);
            }
        }

        else if (buttonIndex == 7 || buttonIndex == 11) {
            if (buttonList.get(buttonIndex - 1) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex - 1, selectedButton);
            } else if (buttonList.get(buttonIndex + 4) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex + 4, selectedButton);
            } else if (buttonList.get(buttonIndex - 4) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex - 4, selectedButton);
            }
        }

        else if (buttonIndex == 13 || buttonIndex == 14) {
            if (buttonList.get(buttonIndex - 1) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex - 1, selectedButton);
            } else if (buttonList.get(buttonIndex + 1) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex + 1, selectedButton);
            } else if (buttonList.get(buttonIndex - 4) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex - 4, selectedButton);
            }
        }

        else {
            if (buttonList.get(buttonIndex + 1) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex + 1, selectedButton);
            } else if (buttonList.get(buttonIndex - 1) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex - 1, selectedButton);
            } else if (buttonList.get(buttonIndex + 4) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex + 4, selectedButton);
            } else if (buttonList.get(buttonIndex - 4) == blankButton) {
                buttonList.set(buttonIndex, blankButton);
                buttonList.set(buttonIndex - 4, selectedButton);
            }
        }

        for (JButton b : buttonList) {
            gamePanel.add(b);
        }

        gamePanel.revalidate();
        gamePanel.repaint();
    }

    void main() {}

}
