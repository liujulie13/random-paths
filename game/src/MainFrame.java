import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;

public class MainFrame extends JFrame {
    
    public void initialize() {

        final Font mainFont = new Font("Segoe print", Font.BOLD, 18);
        JTextField highScore, currentFloor, hp;
        JLabel prompt;
        AtomicInteger highScoreCount = new AtomicInteger(0);
        AtomicInteger currentPath = new AtomicInteger(0);
        AtomicInteger currentHP = new AtomicInteger(3);

        String[] goodPrompts = {
            "You walked into a beautiful forest clearing. +1 Life point",
            "The sunset watches you warmly. +1 Life point",
            "Gemstones dazzle all around you. +1 Life point",
            "The tranquil blue of the lake calms your mind. +1 Life point",
            "A cat purrs as it rubs against you. +1 Life point",
            "A lovely melody flows through the air. +1 Life point",
            "Nearby orchids bloom in many shades of violet. +1 Life point",
            "A kind girl hands you a flower. +1 Life point",
            "The broken vending machine gives you a free drink. +1 Life point",
            "New determination builds inside you. +1 Life point"
        };

        String[] midPrompts = {
            "The road stretches onwards. Nothing happened.",
            "Clouds loom above. Nothing happened.",
            "A feather drifts past you. Nothing happened.",
            "You pass by a laughing crowd. Nothing happened.",
            "How long will this journey go on for? Nothing happened.",
            "The breeze softly rustles your hair. Nothing happened.",
            "You start to take interest in the paintings hanging around the murals. Nothing happened.",
            "Someone asks you for directions. You don't know.  Nothing happened.",
            "Minutes melt into hours, which melt into days as you walk. Nothing happened.",
            "If only every day could like today.  Nothing happened."
        };

        String[] badPrompts = {
            "You miss home, you really do. -1 Life point",
            "Thousands of beastly eyes watch hungrily from behind. -1 Life point",
            "By accident, you drunk your shoe in mud. -1 Life point",
            "An anxious feeling swells inside of you. -1 Life point",
            "A piercing scream interrupts your journey. -1 Life point",
            "There is no end at all, no end to this meaningless path. -1 Life point",
            "An evil goddess whispers lost promises of salvation into your ears. -1 Life point",
            "The scorching heat makes your skin peel. -1 Life point",
            "Oblivion is all your mind can imagine. -1 Life point",
            "A gust of wind pulls you down the icy cliff. -1 Life point"
        };

        //JLabel highScore = new JLabel();
        //highScore.setFont(mainFont);
        Random random = new Random();

        highScore = new JTextField("High score: "+highScoreCount);
        highScore.setFont(mainFont);

        currentFloor = new JTextField("Current Floor: "+currentPath);
        currentFloor.setFont(mainFont);

        hp = new JTextField("Life points: "+currentHP);
        hp.setFont(mainFont);


        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(1,3,5,5));
        formPanel.setOpaque(false);
        formPanel.add(highScore);
        formPanel.add(currentFloor);
        formPanel.add(hp);

        /* Label */
        prompt = new JLabel("", SwingConstants.CENTER);
        prompt.setFont(mainFont);

        /* Button */
        JButton btnOne = new JButton("Path 1");
        btnOne.setFont(mainFont);
        btnOne.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] array = {1, 2, 3};

                int[] rearrangedArray = ArrayRearranger.randomizeArray(array);
                
                int n = rearrangedArray[0];
                
                if(n==1){
                    int randomIndex = random.nextInt(goodPrompts.length);
                    String randomSentence = goodPrompts[randomIndex];
                    currentHP.getAndAdd(1);
                    currentPath.getAndAdd(1);
                    currentFloor.setText("Current Floor: "+currentPath);
                    hp.setText("Life points: "+currentHP);
                    prompt.setText(randomSentence);
                }
                else if(n==2){
                    currentHP.getAndDecrement();
                    int randomIndex = random.nextInt(badPrompts.length);
                    String randomSentence = badPrompts[randomIndex];
                    currentPath.getAndAdd(1);
                    currentFloor.setText("Current Floor: "+currentPath);
                    hp.setText("Life points: "+currentHP);
                    prompt.setText(randomSentence);
                }
                else if(n==3) {
                    int randomIndex = random.nextInt(midPrompts.length);
                    String randomSentence = midPrompts[randomIndex];
                    currentPath.getAndAdd(1);
                    currentFloor.setText("Current Floor: "+currentPath);
                    hp.setText("Life points: "+currentHP);
                    prompt.setText(randomSentence);
                }

                if(currentHP.get()<0){
                    prompt.setText("You died.");
                    highScoreCount.set(currentPath.get());
                    currentPath.set(0);
                    currentHP.set(3);
                    highScore.setText("High score: "+highScoreCount);
                    currentFloor.setText("Current Floor: "+currentPath);
                    hp.setText("Life points: "+currentHP);
                }
            }
        });

        JButton btnTwo = new JButton("Path 2");
        btnTwo.setFont(mainFont);
        btnTwo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int[] array = {1, 2, 3};

                int[] rearrangedArray = ArrayRearranger.randomizeArray(array);
                
                int n = rearrangedArray[1];
                
                if(n==1){
                    int randomIndex = random.nextInt(goodPrompts.length);
                    String randomSentence = goodPrompts[randomIndex];
                    currentHP.getAndAdd(1);
                    currentPath.getAndAdd(1);
                    currentFloor.setText("Current Floor: "+currentPath);
                    hp.setText("Life points: "+currentHP);
                    prompt.setText(randomSentence);
                }
                else if(n==2){
                    currentHP.getAndDecrement();
                    int randomIndex = random.nextInt(badPrompts.length);
                    String randomSentence = badPrompts[randomIndex];
                    currentPath.getAndAdd(1);
                    currentFloor.setText("Current Floor: "+currentPath);
                    hp.setText("Life points: "+currentHP);
                    prompt.setText(randomSentence);
                }
                else if(n==3) {
                    int randomIndex = random.nextInt(midPrompts.length);
                    String randomSentence = midPrompts[randomIndex];
                    currentPath.getAndAdd(1);
                    currentFloor.setText("Current Floor: "+currentPath);
                    hp.setText("Life points: "+currentHP);
                    prompt.setText(randomSentence);
                }

                if(currentHP.get()<0){
                    prompt.setText("You died.");
                    highScoreCount.set(currentPath.get());
                    currentPath.set(0);
                    currentHP.set(3);
                    highScore.setText("High score: "+highScoreCount);
                    currentFloor.setText("Current Floor: "+currentPath);
                    hp.setText("Life points: "+currentHP);
                }
            }

        });

        JButton btnThree = new JButton("Path 3");
        btnThree.setFont(mainFont);
        btnThree.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                int[] array = {1, 2, 3};

                int[] rearrangedArray = ArrayRearranger.randomizeArray(array);

                int n = rearrangedArray[2];

                if(n==1){
                    int randomIndex = random.nextInt(goodPrompts.length);
                    String randomSentence = goodPrompts[randomIndex];
                    currentHP.getAndAdd(1);
                    currentPath.getAndAdd(1);
                    currentFloor.setText("Current Floor: "+currentPath);
                    hp.setText("Life points: "+currentHP);
                    prompt.setText(randomSentence);
                }
                else if(n==2){
                    currentHP.getAndDecrement();
                    int randomIndex = random.nextInt(badPrompts.length);
                    String randomSentence = badPrompts[randomIndex];
                    currentPath.getAndAdd(1);
                    currentFloor.setText("Current Floor: "+currentPath);
                    hp.setText("Life points: "+currentHP);
                    prompt.setText(randomSentence);
                }
                else if(n==3) {
                    int randomIndex = random.nextInt(midPrompts.length);
                    String randomSentence = midPrompts[randomIndex];
                    currentPath.getAndAdd(1);
                    currentFloor.setText("Current Floor: "+currentPath);
                    hp.setText("Life points: "+currentHP);
                    prompt.setText(randomSentence);
                }

                if(currentHP.get()<0){
                    prompt.setText("You died.");
                    highScoreCount.set(currentPath.get());
                    currentPath.set(0);
                    currentHP.set(30);
                    highScore.setText("High score: "+highScoreCount);
                    currentFloor.setText("Current Floor: "+currentPath);
                    hp.setText("Life points: "+currentHP);
                }
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2,5,5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnOne);
        buttonsPanel.add(btnTwo);
        buttonsPanel.add(btnThree);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(220,220,225));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(prompt, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Game");
        setSize(500,600);
        setMinimumSize(new Dimension(900,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }

}