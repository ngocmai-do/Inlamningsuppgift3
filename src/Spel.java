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

    // all buttons within the game is saved in a list for ease of generating game and control the movement of each button
    List<JButton> buttonList = new ArrayList<>(List.of(button1, button2, button3, button4, button5, button6, button7, button8,
            button9, button10, button11, button12, button13, button14, button15, blankButton));

    public Spel() {
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(newGameButton);
        controlPanel.add(winGameLabel);
        newGameButton.addActionListener(this);

        gamePanel.setLayout(new GridLayout(4,4));
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button10.addActionListener(this);
        button11.addActionListener(this);
        button12.addActionListener(this);
        button13.addActionListener(this);
        button14.addActionListener(this);
        button15.addActionListener(this);


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
        }

        if (e.getSource() == button1 || e.getSource() == button2 || e.getSource() == button3 || e.getSource() == button4 || e.getSource() == button5 ||
                e.getSource() == button6 || e.getSource() == button7 || e.getSource() == button8 || e.getSource() == button9 || e.getSource() == button10 ||
                e.getSource() == button11 || e.getSource() == button12 || e.getSource() == button13 || e.getSource() == button14 || e.getSource() == button15) {
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
