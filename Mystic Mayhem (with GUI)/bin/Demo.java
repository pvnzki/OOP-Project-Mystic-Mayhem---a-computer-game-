package bin;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
// import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.*;


public class Demo extends JFrame{
    
    public JTextArea outputTextArea;
    public static JTextArea outpuTextAreax;
    private static Map<String, Player> profiles = new HashMap<>();
    static Map<Integer, Player> profilesWithID = new HashMap<>();
    public static Player currentPlayer;


    public static void main(String[] args) {
        
        //create a java swing gui for the game

        //call the method for background music in the game
        playSound("res\\MysticMayhemOST.wav");

        //create a default player to play with other players
        Player player = new Player("GeraltofRivia", "whitewolf");
        profiles.put("whitewolf", player);
        profilesWithID.put(player.userProfile.getUserID(), player);

        player.setIsDefault();

        //create an army for the default player
        Charactors ranger = new Ranger();
        Charactors squire = new Squire();
        Charactors warlock = new Warlock();
        Charactors medic = new Medic();
        Charactors dragon = new Dragon();
        List<Charactors> armyList = new ArrayList<>();

        armyList = player.getArmyList();
        armyList.add(ranger);
        armyList.add(squire);
        armyList.add(warlock);
        armyList.add(medic);
        armyList.add(dragon);
        player.setArmyList(armyList);

        HashMap<String, Charactors> armyMap = new HashMap<>();
        armyMap = player.getArmyMap();
        armyMap.put("Ranger", ranger);
        armyMap.put("Squire", squire);
        armyMap.put("Warlock", warlock);
        armyMap.put("Medic", medic);
        armyMap.put("Dragon", dragon);
        player.setArmyMap(armyMap);

        player.setGoldCoins(215);
        player.setXP(32);

        //set a homeground for default player
        player.setHomeGround("Marshland");
        player.setIsDefault();

        //set artefact and armour
        player.buyArmour("Ranger","Chainmail");
        player.buyArtefact("Medic","Amulet");
        
        workWindow();

    }

    private static void createUserProfile(JTextArea outputTextArea0) {
        String name = JOptionPane.showInputDialog("Enter name:");
        String username;
        while (true) {
            username = JOptionPane.showInputDialog("Enter username:");

            if (profiles.containsKey(username)) {
                JOptionPane.showMessageDialog(null,"Username already taken. Please enter a new username.");
            } else {
                break;
            }
        }

        
        Player player = new Player(name, username);
        profiles.put(username, player);
        //System.out.println(player.userProfile.getUserID());
        profilesWithID.put(player.userProfile.getUserID(), player);
        currentPlayer = profilesWithID.get(profilesWithID.size()-1);

        outputTextArea0.append("Hi "+ player.userProfile.getName() + ". Your user profile created successfully.\n\n");
        outputTextArea0.append("Your Profile is "+ player.userProfile + "\n\n");
        outputTextArea0.append("Please press Next to start the game!\n");
    }

    private static void changeName(JTextArea outputTextArea0) {
        String username = JOptionPane.showInputDialog("Enter current username: ");

        Player player = profiles.get(username);
        if (player == null) {
            JOptionPane.showMessageDialog(null,"User profile not found.");
        } else {
            String newName = JOptionPane.showInputDialog("Enter new name: ");
            player.userProfile.setName(newName);
            JOptionPane.showMessageDialog(null,"Name changed successfully.");
            outputTextArea0.append("Your name changed to " + newName + " successfully.");
        }
    }

    public static void getArmourTool(JTextArea outputTextArea){
        JOptionPane.showMessageDialog(null,"Now you can add Armour to a player.");
        int chrNum=1;
        for(Charactors charA : currentPlayer.getArmyList()){
            outputTextArea.append(chrNum+"."+charA.getName()+"\n");
            chrNum++;
        }

        outputTextArea.append("\n");

        String charaString = JOptionPane.showInputDialog("Enter the charactor number that you want add armour.");
        int charaInteger = Integer.parseInt(charaString);
        String armourString = JOptionPane.showInputDialog("1.Chainmail (70 gc)\n 2.Regalia (105 gc)\n3.Fleece (150 gc)\nEnter the armour number that you want add armour.");
        int armourInt = Integer.parseInt(armourString);
        String armString =null;
        switch (armourInt) {
            case 1:
                armString="Chainmail";
                playSound("res\\Buying Sound Effect.wav");
                break;
            case 2:
                armString="Regalia";
                playSound("res\\Buying Sound Effect.wav");
                break;
            case 3:
                armString="Fleece";
                playSound("res\\Buying Sound Effect.wav");
                break;        
        
            default:
                JOptionPane.showMessageDialog(null,"Invalid Choice! ");
                break;
        }
        if(armString !=null) currentPlayer.buyArmour(currentPlayer.getArmyList().get(charaInteger-1).getName(), armString);
    }

    public static void getArtefactTool(JTextArea outputTextArea){
        JOptionPane.showMessageDialog(null,"Now you can add Artefact to a player.");
        int chrNum=1;
        for(Charactors charA : currentPlayer.getArmyList()){
            outputTextArea.append(chrNum+"."+charA.getName()+"\n");
            chrNum++;
        }
        outputTextArea.append("\n");
        
        String charaString = JOptionPane.showInputDialog("Enter the charactor number that you want add Artefacts.");
        int charaInteger = Integer.parseInt(charaString);
        String artefactsString = JOptionPane.showInputDialog("1.Excalibur (150 gc)\n 2.Amulet (200 gc)\n3.Crystal (210 gc)\nEnter the artefact number that you want add artefact.");
        int artefactsInt = Integer.parseInt(artefactsString);
        String artString =null;

        switch (artefactsInt) {
            case 1:
                artString="Excalibur";
                
                break;
            case 2:
                artString="Amulet";
                break;
            case 3:
                artString="Crystal";
                break;        
        
            default:
                JOptionPane.showMessageDialog(null,"Invalid Choice! ");
                break;
        }
        if(artString !=null) currentPlayer.buyArtefact(currentPlayer.getArmyList().get(charaInteger-1).getName(), artString);
        
    }
    public static void sellArmyCharactors(JTextArea outpuTextAreax){
        int chrNum=1;
        for(Charactors charA : currentPlayer.getArmyList()){
            outpuTextAreax.append(chrNum+"."+charA.getName());
            chrNum++;
        }
        String charaString = JOptionPane.showInputDialog("Enter the character number that you want to remove.");
        int charaInteger = Integer.parseInt(charaString);
        try{
            currentPlayer.sellCharactors(currentPlayer.getArmyList().get(charaInteger-1).getName(),outpuTextAreax);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Somthing went wrong...");
        }
        // outpuTextAreax.append("Your gold coin amount : "+ currentPlayer.getGoldCoins());
    }


    public static Clip playSound(String filename) {
        Clip clip = null;
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filename).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
        return clip;
    }

    //create a method to set an image fpr the bottom of the frame
    public static class ImagePanel extends JPanel {
        
        private Image img;

        public ImagePanel(String img) {
            this(new ImageIcon(img).getImage());
        }

        public ImagePanel(Image img) {
            this.img = img;
            Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);
        }


        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int frameWidth = getWidth();
            int frameHeight = getHeight();
            int imageWidth = img.getWidth(null);
            int imageHeight = img.getHeight(null);
            int x = (frameWidth - imageWidth) / 2;
            int y = frameHeight - imageHeight;
            g.drawImage(img, x, y, null);
        }
    }

    public static void workWindow() {
        //set an animation for the game window

        
        //create a window for the game
        JFrame frame = new JFrame("Mystic Mayhem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().setBackground(Color.WHITE);
        //set colour to output text area
        

        //set an footer image for the bottom of the frame
        ImagePanel panel = new ImagePanel(new ImageIcon("res\\bgimg2.jpg").getImage());
        frame.add(panel);
        //place the image at the bottom
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel(new ImageIcon("res\\bgimg2.jpg")), BorderLayout.SOUTH);
        //decrease the size of the image
        panel.setPreferredSize(new Dimension(300, 200));


        //create a text area at the top for the game
        JTextArea outputTextArea0 = new JTextArea(20, 30);
        outputTextArea0.setLineWrap(true);
        outputTextArea0.setWrapStyleWord(true);
        outputTextArea0.setEditable(false);
        frame.add(outputTextArea0);
        outputTextArea0.setBackground(Color.black);
        outputTextArea0.setForeground(Color.yellow);
        //set the font colour
        outputTextArea0.setFont(new Font("Arial", Font.BOLD, 14));

        //change the size of the text area
        outputTextArea0.setPreferredSize(new Dimension(300, 200));

        //add a scroll bar to the text area
        JScrollPane scrollPane = new JScrollPane(outputTextArea0);
        frame.add(scrollPane);

        //set a colour to the frame
        frame.getContentPane().setBackground(Color.white);
        //i want to change the colour of the frame to an image
        // frame.setContentPane(new JLabel(new ImageIcon("D:\\CSE MyAca\\Program Construction\\Projects\\Game\\IranGame\\res\\bgimg2.jpg")));
        // frame.setLayout(new FlowLayout());
        
        //create a button panel for the game
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3));
        frame.add(buttonPanel,BorderLayout.SOUTH);

        outputTextArea0.append("Welcome to Mystic Mayhem!\n\n");
        outputTextArea0.append("SOUND ON! to get better experience\n\n");
        outputTextArea0.append("-----------------------------------------\n");
        outputTextArea0.append("To get started, Click Create Profile.\n\n");  

        //create a next button to go to a new panel
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // exit the game
                frame.setVisible(false);
                frame.dispose();
                workWindow2();
            }
        });
        buttonPanel.add(nextButton);
        nextButton.setVisible(false);

        //create buttons for the game
        JButton createProfileButton = new JButton("Create Profile");
        createProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createUserProfile(outputTextArea0);
                outputTextArea0.append("Congratulations! You got 500 Gold Coins\n\n");
                nextButton.setVisible(true);
            }
            
        });
        buttonPanel.add(createProfileButton);

        // create a button to change the name
        JButton changeNameButton = new JButton("Change Name");
        changeNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // change the name of the player
                changeName(outputTextArea0);
            }
        });
        buttonPanel.add(changeNameButton);

        // create a button to exit the game
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // exit the game
                System.exit(0);
            }
        });
        buttonPanel.add(exitButton);

        // make the frame visible
        frame.setVisible(true);

    }
    public static void workWindow2() {
        //create a window for the game
        JFrame frame2 = new JFrame("Mystic Mayhem");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(1200, 500);
        frame2.setLayout(new FlowLayout());
        frame2.getContentPane().setBackground(Color.WHITE);


        ImagePanel panel = new ImagePanel(new ImageIcon("res\\store.jpg").getImage());
        frame2.add(panel);
        //place the image at the bottom
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel(new ImageIcon("res\\store.jpg")), BorderLayout.SOUTH);
        //decrease the size of the image
        panel.setPreferredSize(new Dimension(300, 300));

        // make the frame2 visible
        frame2.setVisible(true);


        //create two tabs for this window
        JTabbedPane tabbedPane = new JTabbedPane();
        frame2.add(tabbedPane);
        
        //create a panel for the first tab
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        tabbedPane.addTab("Sell", panel1);
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 16));

        //create a text area at the top for the panel 1
        JTextArea outputTextAreax = new JTextArea(28, 30);
        //center the output text area
        outputTextAreax.setAlignmentX(Component.CENTER_ALIGNMENT);
        outputTextAreax.setLineWrap(true);
        outputTextAreax.setWrapStyleWord(true);  
        outputTextAreax.setEditable(false);
        panel1.add(outputTextAreax);
        outputTextAreax.setBackground(Color.black);
        outputTextAreax.setForeground(Color.yellow);
        outputTextAreax.setFont(new Font("Arial", Font.BOLD, 12));

        outputTextAreax.append("Welcome to the Mystic Mayhem Store!\n");
        outputTextAreax.append("----------------------------------------------------------\n");
        outputTextAreax.append("This where you can buy new charactors and sell your charactors\n\n");
        outputTextAreax.append("First you need to buy charactors in order to sell them.\n\n");
        outputTextAreax.append("----------------------------------------------------------\n");

        //add a scroll bar to the text area
        JScrollPane scrollPane1 = new JScrollPane(outputTextAreax);
        panel1.add(scrollPane1);

        //create a button panel for the next window
        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new GridLayout(3, 3));
        panel1.add(buttonPanel1);

        //create buttons for sell charactors and armour
        JButton sellCharactorButton = new JButton("Sell Charactor");
        sellCharactorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //create a new profile
                // Scanner scanner = new Scanner(System.in);
                sellArmyCharactors(outputTextAreax);
    
            }
            
        });
        
        buttonPanel1.add(sellCharactorButton);

        //create a panel for the second tab
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        tabbedPane.addTab("Buy", panel2);
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 16));

        //create a text area at the top for the game
        JTextArea outputTextArea = new JTextArea(28, 30);
        //center the output text area
        outputTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        outputTextArea.setLineWrap(true);
        outputTextArea.setWrapStyleWord(true);
        outputTextArea.setEditable(false);
        panel2.add(outputTextArea);
        outputTextArea.setBackground(Color.black);
        outputTextArea.setForeground(Color.yellow);
        outputTextArea.setFont(new Font("Arial", Font.BOLD, 12));

        outputTextArea.append("Welcome to the Mystic Mayhem Store!\n");
        outputTextArea.append("---------------------------------------------------------\n");
        outputTextArea.append("This where you can buy new charactors and sell your charactors\n\n");
        outputTextArea.append("First you need to buy charactors in order to sell them.\n\n");
        outputTextArea.append("---------------------------------------------------------\n");


        //add a scroll bar to the text area
        JScrollPane scrollPane2 = new JScrollPane(outputTextArea);
        panel2.add(scrollPane2);

        //create a button panel for the next window
        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.setLayout(new GridLayout(3, 3));
        panel2.add(buttonPanel2);

        //create buttons for the next window
        // create a button to start the war
        JButton startBattleButton = new JButton("Start Battle");
        startBattleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //play sound for the battle
                playSound("res\\battle.wav");
                
                //exit from current window and open a new one
                frame2.dispose();
                workWindow3();
            }
        });
        buttonPanel2.add(startBattleButton);
        startBattleButton.setVisible(false);


        //create button for add armour
        JButton addArmourButton = new JButton("Add Armour");
        addArmourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getArmourTool(outputTextArea);
                
            }
            
        });
        buttonPanel2.add(addArmourButton);
        addArmourButton.setVisible(false);

        //create button for add artefact
        JButton addArtefactButton = new JButton("Add Artefact");
        addArtefactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getArtefactTool(outputTextArea);
            }
            
        });
        buttonPanel2.add(addArtefactButton);
        addArtefactButton.setVisible(false);

        // create a button to change the setHomeGround
        JButton setHomeGroundButton = new JButton("Set Home Ground");
        setHomeGroundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // change the name of the player
                profilesWithID.get(profilesWithID.size()-1).setHomeGround(outputTextArea);
                outputTextArea.append("Home ground set to "+ profilesWithID.get(profilesWithID.size()-1).getHomeGround() +" successfully.\n");
                addArmourButton.setVisible(true);
                addArtefactButton.setVisible(true);
                startBattleButton.setVisible(true);
            }
        });
        buttonPanel2.add(setHomeGroundButton);
        setHomeGroundButton.setVisible(false);

        //create button for add army
        JButton addArmyButton = new JButton("Add army");
        addArmyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //create a new profile
                // Scanner scanner = new Scanner(System.in);
                profilesWithID.get(profilesWithID.size()-1).setCharactors(outputTextArea);
                setHomeGroundButton.setVisible(true);
    
            }
        });
        buttonPanel2.add(addArmyButton);

    }

        public static void workWindow3() {


            //create a window for the game
            JFrame frame3 = new JFrame("Mystic Mayhem Battle");
            frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame3.setSize(620, 500);
            frame3.setLayout(new FlowLayout());
            frame3.getContentPane().setBackground(Color.WHITE);
    
    
            // ImagePanel panel = new ImagePanel(new ImageIcon("D:\\CSE MyAca\\Program Construction\\Projects\\Game\\IranGame\\res\\bgimg2.jpg").getImage());
            // frame3.add(panel);
            // //place the image at the bottom
            // panel.setLayout(new BorderLayout());
            // panel.add(new JLabel(new ImageIcon("D:\\CSE MyAca\\Program Construction\\Projects\\Game\\IranGame\\res\\bgimg2.jpg")), BorderLayout.SOUTH);
            // //decrease the size of the image
            // panel.setPreferredSize(new Dimension(300, 200));
    
            // make the frame3 visible
            frame3.setVisible(true);



    
            //create a text area at the top for the game
            JTextArea outputTextArea = new JTextArea(28, 60);
            //center the output text area
            outputTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);
            outputTextArea.setLineWrap(true);
            outputTextArea.setWrapStyleWord(true);
            outputTextArea.setEditable(false);
            frame3.add(outputTextArea);
            outputTextArea.setBackground(Color.black);
            outputTextArea.setForeground(Color.yellow);
            outputTextArea.setFont(new Font("Arial", Font.BOLD, 12));
    
            //add a scroll bar to the text area
            JScrollPane scrollPane3 = new JScrollPane(outputTextArea);
            frame3.add(scrollPane3);
    
            //create a button panel for the next window
            JPanel buttonPanel3 = new JPanel();
            buttonPanel3.setLayout(new GridLayout(3, 3));
            frame3.add(buttonPanel3);

            //play sound on this window
            playSound("res\\BattleSound.wav");

            //set a text for the battle window
            outputTextArea.append("Welcome to the Battle Field!\n\n");
            outputTextArea.append("SOUND ON! to get better experience\n\n");
            outputTextArea.append("-----------------------------------------\n");
            outputTextArea.append("To start the Battle, Click Declare War.\n\n");
    
            //create buttons for the next window
            JButton addDecWarButton = new JButton("Declare War");
            addDecWarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //call declare war method
                    profilesWithID.get(profilesWithID.size()-1).declareWar(profilesWithID,outputTextArea);
        
                }
            });
            buttonPanel3.add(addDecWarButton);
            
    }



}
