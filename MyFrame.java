import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Image;

public class MyFrame extends JFrame implements ActionListener{
    JButton buttonRock;
    JButton buttonPaper;
    JButton buttonScissors;

    JLabel rockLabel;
    JLabel paperLabel;
    JLabel scissorsLabel;

    JLabel rockLabelComputer;
    JLabel paperLabelComputer;
    JLabel scissorsLabelComputer;

    JLabel gameStatus;
    JLabel stats;

    String playerInput;
    String computerInput;

    int winCounter = 0;
    int loseCounter = 0;

    MyFrame(){

        gameStatus = new JLabel("hello");
        gameStatus.setBounds(345,150,150,500);
        gameStatus.setVisible(true);

        stats = new JLabel("0 wins / 0 losses");
        stats.setBounds(310,150,150,50);
        stats.setVisible(true);

        buttonRock = new JButton();
        buttonPaper = new JButton();
        buttonScissors = new JButton();

        buttonRock.addActionListener(this);
        buttonPaper.addActionListener(this);
        buttonScissors.addActionListener(this);

        ImageIcon img_rock = new ImageIcon(new ImageIcon("rock.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        ImageIcon img_paper = new ImageIcon(new ImageIcon("paper.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        ImageIcon img_scissors = new ImageIcon(new ImageIcon("scissors.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        
    
        rockLabel = new JLabel();
        rockLabel.setIcon(img_rock);
        rockLabel.setBounds(230,150,250,250);
        rockLabel.setVisible(false);

        paperLabel = new JLabel();
        paperLabel.setIcon(img_paper);
        paperLabel.setBounds(230,150,250,250);
        paperLabel.setVisible(false);


        scissorsLabel = new JLabel();
        scissorsLabel.setIcon(img_scissors);
        scissorsLabel.setBounds(230,150,250,250);
        scissorsLabel.setVisible(false);

        rockLabelComputer = new JLabel();
        rockLabelComputer.setIcon(img_rock);
        rockLabelComputer.setBounds(400,150,250,250);
        rockLabelComputer.setVisible(false);

        paperLabelComputer = new JLabel();
        paperLabelComputer.setIcon(img_paper);
        paperLabelComputer.setBounds(400,150,250,250);
        paperLabelComputer.setVisible(false);

        scissorsLabelComputer = new JLabel();
        scissorsLabelComputer.setIcon(img_scissors);
        scissorsLabelComputer.setBounds(400,150,250,250);
        scissorsLabelComputer.setVisible(false);

        


        buttonRock.setFocusable(false);
        buttonPaper.setFocusable(false);
        buttonScissors.setFocusable(false);


        buttonRock.setBounds(/*x*/50,/*y*/50,/*width*/100,/*length*/50);
        buttonPaper.setBounds(/*x*/50,/*y*/200,/*width*/100,/*length*/50);
        buttonScissors.setBounds(/*x*/50,/*y*/350,/*width*/100,/*length*/50);

        buttonRock.setText("Rock");
        buttonPaper.setText("Paper");
        buttonScissors.setText("Scissors");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(buttonRock); // display the button
        this.add(buttonPaper); // display the button
        this.add(buttonScissors); // display the button
        this.add(rockLabel);
        this.add(paperLabel);
        this.add(rockLabelComputer);
        this.add(scissorsLabel);
        this.add(paperLabelComputer);
        this.add(scissorsLabelComputer);
        this.add(gameStatus);
        this.add(stats);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        computerInput = computerMove();
        System.out.println(computerMove());
        if (e.getSource()==buttonRock) {
            rockLabel.setVisible(true);
            paperLabel.setVisible(false);
            scissorsLabel.setVisible(false);
            playerInput = "rock";
            System.out.println("You chose rock!");
        } else if (e.getSource()==buttonPaper) {
            rockLabel.setVisible(false);
            paperLabel.setVisible(true);
            scissorsLabel.setVisible(false);
            playerInput = "paper";
            System.out.println("You chose paper!");
        }
        else if (e.getSource()==buttonScissors) {
            rockLabel.setVisible(false);
            paperLabel.setVisible(false);
            scissorsLabel.setVisible(true);
            playerInput = "scissors";
            System.out.println("You chose scissors!");
        }

        // computer move
        System.out.println("The computer chose: " + computerInput);
        String winner = getWinner(playerInput, computerInput);
        System.out.println(winner);
        gameStatus.setText(winner);
        stats.setText(winCounter + " wins / " + loseCounter + " losses");
        if (computerInput.equals("Rock")) {
            rockLabelComputer.setVisible(true);
            paperLabelComputer.setVisible(false);
            scissorsLabelComputer.setVisible(false);
        } else if (computerInput.equals("Paper")) {
            rockLabelComputer.setVisible(false);
            paperLabelComputer.setVisible(true);
            scissorsLabelComputer.setVisible(false);
        } else if (computerInput.equals("Scissors"))
        {
            rockLabelComputer.setVisible(false);
            paperLabelComputer.setVisible(false);
            scissorsLabelComputer.setVisible(true);
        }

        
    }

    private String computerMove()
    {
        String[] s = {"Rock", "Paper", "Scissors"};
        Random ran = new Random();
        return s[ran.nextInt(s.length)];
    }

    private String getWinner(String playerInput, String computerInput)
    {   
        if (playerInput.equals("rock"))
        {
            if (computerInput.equals("Paper"))
            {
                loseCounter++;
                return "You Lose";
            }
            else if (computerInput.equals("Scissors"))
            {
                winCounter++;
                return "You Win";
            }
            else
                return "Tie Game";
        }

        if (playerInput.equals("paper"))
        {
            if (computerInput.equals("Paper"))
                return "Tie Game";
            else if (computerInput.equals("Scissors")){
                loseCounter++;
                return "You Lose";
            }
            else{
                winCounter++;
                return "You Win";
            }
        }

        if (playerInput.equals("scissors"))
        {
            if (computerInput.equals("Paper")){
                winCounter++;
                return "You Win";
            }
            else if (computerInput.equals("Scissors"))
                return "Tie Game";
            else{
                loseCounter++;
                return "You Lose";
            }
        }
        return "error";
    }
}