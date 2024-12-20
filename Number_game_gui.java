import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Number_game_gui extends JFrame {
    JPanel mainpanel;
    JTextField text, names;
    JLabel data;
    JTextArea displayArea;
    JComboBox levelbox;
    int randomnumber;
    int order;
   private  int correctdigits;
    private ArrayList<String> data_1 = new ArrayList<>();
    private int counter_1;
    private String playerName;  // Store player name here
    private int numofguesses =0;

    public Number_game_gui() {
        this.text = new JTextField("Enter Name: ", 30);
        this.text.addActionListener(new txtInputListener());
        add(this.text);
        setLayout(new GridLayout(2, 1));
        setSize(330, 330);
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Game");

        data = new JLabel();
        this.create_pannel();
        this.CreateButtons();
        add(this.mainpanel);
        setVisible(true);
    }

    public void create_pannel() {
        mainpanel = new JPanel(new GridLayout(2, 4));
        String level_list[] = {"Level 1", "Level 2", "Level 3", "Level 4"};
        levelbox = new JComboBox(level_list);
    }

    public void CreateButtons() {
        JButton start_game = new JButton("Start Game");
        JButton clear_display = new JButton("Clear Display");
        JButton Statistics = new JButton("Current Statistics");

        start_game.addActionListener(new StartListener());
        clear_display.addActionListener(new ClearListener());
        Statistics.addActionListener(new stat_listener());

        this.mainpanel.add(start_game);
        this.mainpanel.add(levelbox);
        this.mainpanel.add(Statistics);
        this.mainpanel.add(clear_display);
    }

    class StartListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            text.setEditable(true);
            Random rn = new Random();
            if (levelbox.getSelectedItem().toString().equals("Level 1")) {
                text.setText("Enter a random value between 1 and 20?");
                String value = text.getText().toString();
                int max_value = Integer.parseInt(value.replaceAll("[^\\d]", ""));
                randomnumber = rn.nextInt(max_value);
            } else if (levelbox.getSelectedItem().toString().equals("Level 2")) {
                randomnumber = rn.nextInt(99 - 1 + 1) + 1;
            } else if (levelbox.getSelectedItem().toString().equals("Level 3")) {
                randomnumber = rn.nextInt(999 - 100 + 1) + 100;
            } else {
                randomnumber = rn.nextInt(9999 - 1000 + 1) + 1000;
            }
            text.setText("Guess the number generated: ");
        }
    }

    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            text.setText(null);
            text.setText("Enter Name: ");
        }
    }

    public class txtInputListener implements ActionListener {
        int numofguesses;
        int order = 0;
        int correctdigits = 0;
        char[] guessnum;
        char[] randomnum;

        public void actionPerformed(ActionEvent event) {
            if (text.getText().contains("Enter Name")) {
                String input = text.getText();
                playerName = input.substring(12);  // Store the player name
                text.setText("Choose a difficulty and press Start Game");
                text.setEditable(false);
                data_1.add(playerName);
            }

            if (text.getText().contains("Guess the number generated: ")) {
                String guess = text.getText().substring(28);  // Extract the guess from the input
                try {
                    int num = Integer.parseInt(guess);
                    numofguesses++;

                    if (num > randomnumber) {
                        text.setText("Guess is less than.");
                    } else if (num < randomnumber) {
                        text.setText("Guess is greater than.");
                    } else {
                        text.setText("Guess is just right. You won!");
                        return;  // Correct guess, stop the game
                    }
                } catch (NumberFormatException e) {
                    text.setText("Please enter a valid number.");
                }
            }
        }
    }

    class stat_listener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            JDialog stat_2 = new JDialog();
            displayArea = new JTextArea("Current Statistics");
            displayArea.setEditable(false);

            displayArea.setText("Player name: " + playerName + "\nTotal guesses: " + numofguesses + "\nCorrect digits: " + correctdigits);
            stat_2.add(displayArea);
            stat_2.setSize(150, 150);
            stat_2.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Number_game_gui();
    }
}

