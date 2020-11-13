import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  
  JPanel mainPanel;

  JLabel chooseLabel;
  JLabel comLabel;
  JLabel resultLabel;

  JTextField decisionInput;

  JButton rockButton;
  JButton paperButton;
  JButton scissorsButton;

  Font biggerFont = new Font("arial", Font.PLAIN, 28);

  Font biggerFont2 = new Font("arial", Font.PLAIN, 20);

  Font biggerFont3 = new Font("arial", Font.PLAIN, 40);

  JLabel picture;
  
  ImageIcon rockImage;
  ImageIcon paperImage;
  ImageIcon scissorsImage;

  JLabel winLabel;
  JLabel tiedLabel;
  JLabel loseLabel;

  JLabel gameLabel;

  JTextField winsText;
  JTextField tiesText;
  JTextField loseText;

  int winPoints = 0;
  int tiePoints = 0;
  int losePoints = 0;

  JPanel titleScreen;
  JPanel endScreen;
  JPanel switchPanel;

  JButton startButton;

  CardLayout screens;

  JLabel wonOrLostLabel;

  JLabel playLabel;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Rock Paper Scissors");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    
    // shows the window
    frame.setVisible(true);
 
    // initialize main panel 
    mainPanel = new JPanel();
    mainPanel.setLayout(null);

    // create labels
    chooseLabel = new JLabel("Choose between Rock, paper, or scissors");
    comLabel = new JLabel("The computer chose: ");
    resultLabel = new JLabel("You ");

    // make font bigger 
    chooseLabel.setFont(biggerFont);
    comLabel.setFont(biggerFont2);
    resultLabel.setFont(biggerFont2);

    // layout labels with cordinates and size 
    chooseLabel.setBounds(100, 10, 600, 100);
    comLabel.setBounds(150, 400, 300, 100);
    resultLabel.setBounds(150, 450, 300, 100);

    // create the buttons
    rockButton = new JButton("Rock");
    paperButton = new JButton("Paper");
    scissorsButton = new JButton("Scissors");
   
    // add action listener to buttons
    rockButton.addActionListener(this);
    paperButton.addActionListener(this);
    scissorsButton.addActionListener(this);

    // layout buttons with their size and cordinates
    rockButton.setBounds(200, 375, 100, 50);
    paperButton.setBounds(350, 375, 100, 50);
    scissorsButton.setBounds(500, 375, 100, 50);

    // set up the button to change image 
    rockButton.setActionCommand("rock");
    paperButton.setActionCommand("paper");
    scissorsButton.setActionCommand("scissors");

    // add buttons to the main panel 
    mainPanel.add(rockButton);
    mainPanel.add(paperButton);
    mainPanel.add(scissorsButton);
   
    // add labels to the main panel 
    mainPanel.add(chooseLabel);
    mainPanel.add(comLabel);
    mainPanel.add(resultLabel);

    // create images
    rockImage = new ImageIcon("rock2.jpg");
    paperImage = new ImageIcon("paper2.jpg");
    scissorsImage = new ImageIcon("scissors3.jpg");

    // create jlabel for picture
    picture = new JLabel();
    picture.setBounds(200, 150, 400, 200);

    // add the picture to the main screen
    mainPanel.add(picture);

    // create jlabels for counter
    winLabel = new JLabel("Wins:");
    tiedLabel = new JLabel("Ties:");
    loseLabel = new JLabel("Losses:");

    // set fonts for the labels
    winLabel.setFont(biggerFont2);
    tiedLabel.setFont(biggerFont2);
    loseLabel.setFont(biggerFont2);

    // layout labels with cordinates and size
    winLabel.setBounds(500, 400, 100, 100);
    tiedLabel.setBounds(500, 450, 100, 100);
    loseLabel.setBounds(500, 500, 100, 100);

    // add the labels to the main panel
    mainPanel.add(winLabel);
    mainPanel.add(tiedLabel);
    mainPanel.add(loseLabel);

    // create jlabel for the game label
    gameLabel = new JLabel("First One up to 7");

    // set font for the label 
    gameLabel.setFont(biggerFont2);

    // layout labels witht the size and cordinates
    gameLabel.setBounds(300, 30, 400, 200);

    // add the label to the main panel 
    mainPanel.add(gameLabel);

    // set up the end screen
    endScreen = new JPanel();
    endScreen.setLayout(null);

    // create the labels that tell user if they won or lost 
    wonOrLostLabel = new JLabel("You WON the Game!");
    wonOrLostLabel.setBounds(140, 250, 600, 100);
    wonOrLostLabel.setFont(biggerFont3);

    // add the labels to the end screen 
    endScreen.add(wonOrLostLabel);

    // set up the title screen
    titleScreen = new JPanel();
    titleScreen.setLayout(null);

    // create the button to start the game
    startButton = new JButton("START GAME");
    startButton.setBounds(250, 250, 300, 100);
    startButton.addActionListener(this);
    startButton.setActionCommand("start");

    // create the label on title screen
    playLabel = new JLabel("Play Rock, Paper, Scissors!");
    playLabel.setBounds(125, 50, 700, 200);
    playLabel.setFont(biggerFont3);

    // add the label to the title screen
    titleScreen.add(playLabel);

    // add the start button to the title screen
    titleScreen.add(startButton);

    // create the CardLayout
    screens = new CardLayout();

    // create the switch jpanel manager
    switchPanel = new JPanel();
    switchPanel.setLayout(screens);

    // add screens to the card layout
    switchPanel.add(titleScreen, "titleScreen");
    switchPanel.add(mainPanel, "mainPanel");
    switchPanel.add(endScreen, "endScreen");

    // add the main panel to the window
    frame.add(switchPanel);

    // sets the screen to show by asking the card layout
    screens.show(switchPanel, "titleScreen");

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // create a random number generator
    Random rand = new Random();

    int randNum = rand.nextInt(3) + 1;

    // create the if statement to add image of the button that is pressed
    if(command.equals("rock")){
      picture.setIcon(rockImage);
    }else if(command.equals("paper")){
      picture.setIcon(paperImage);
    }else if(command.equals("scissors")){
      picture.setIcon(scissorsImage);
    }

    // associate every number with rock paper and scissors
    String cpuChoice = "";
    if(randNum == 1){
      cpuChoice = "rock";
    }else if(randNum == 2){
      cpuChoice = "paper";
    }else if(randNum == 3){
      cpuChoice = "scissors";
    }

    // create if statements to determine who wins 
    if(cpuChoice.equals("rock") && command.equals("paper")){
      comLabel.setText("The computer chose: Rock");
      resultLabel.setText("You WIN!");
      // add 1 point to the counter for every win
      winPoints = winPoints + 1;
      winLabel.setText("Wins :" + winPoints);
    
    // create an if statement to determine who wins
    }else if(cpuChoice.equals("rock") && command.equals("rock")){
      comLabel.setText("The computer chose: Rock");
      resultLabel.setText("You tied");
      // add 1 point to the counter for every tie
      tiePoints = tiePoints + 1;
      tiedLabel.setText("Ties :" + tiePoints);

    // create an if statement to determine who wins
    }else if(cpuChoice.equals("rock") && command.equals("scissors")){
      comLabel.setText("The computer chose: Rock");
      resultLabel.setText("You lose :(");
      // add 1 point to the counter for every loss
      losePoints = losePoints + 1;
      loseLabel.setText("Losses :" + losePoints);

    // repeat code for when cpu chooses paper or scissors
    }else if(cpuChoice.equals("paper") && command.equals("scissors")){
      comLabel.setText("The computer chose: Paper");
      resultLabel.setText("You WIN!");
      winPoints = winPoints + 1;
      winLabel.setText("Wins :" + winPoints);

    }else if(cpuChoice.equals("paper") && command.equals("paper")){
      comLabel.setText("The computer chose: Paper");
      resultLabel.setText("You tied");
      tiePoints = tiePoints + 1;
      tiedLabel.setText("Ties :" + tiePoints);

    }else if(cpuChoice.equals("paper") && command.equals("rock")){
      comLabel.setText("The computer chose: Paper");
      resultLabel.setText("You lose :(");
      losePoints = losePoints + 1;
      loseLabel.setText("Losses :" + losePoints);

    }else if(cpuChoice.equals("scissors") && command.equals("rock")){
      comLabel.setText("The computer chose: Scissors");
      resultLabel.setText("You WIN!");
      winPoints = winPoints + 1;
      winLabel.setText("Wins :" + winPoints);

    }else if(cpuChoice.equals("scissors") && command.equals("scissors")){
      comLabel.setText("The computer chose: Scissors");
      resultLabel.setText("You tied");
      tiePoints = tiePoints + 1;
      tiedLabel.setText("Ties :" + tiePoints);
      
    }else if(cpuChoice.equals("scissors") && command.equals("paper")){
      comLabel.setText("The computer chose: Scissors");
      resultLabel.setText("You lose :(");
      losePoints = losePoints + 1;
      loseLabel.setText("Losses :" + losePoints);
    }
    
    // if statement to switch the panels when user presses the button
    if(command.equals("start")){
      screens.show(switchPanel, "mainPanel");

    }
    
    // if statement saying that if the win counter reaches 7, switch to the endscreen and tell the user that they won
    if(winPoints == 7){
      screens.show(switchPanel, "endScreen");
      wonOrLostLabel.setText("You WON the Game!");
      // if statement saying that if the loss counter reaches 7, switch to the endscreen and tell the user that they lost
    }else if(losePoints == 7){
      screens.show(switchPanel, "endScreen");
      wonOrLostLabel.setText("Sorry... You Lost the Game");
    }

    }
    

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}

