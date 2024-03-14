package bin;
//import javax.xml.stream.events.Characters;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;
class Player{
    UserProfile userProfile;
    public Player(String name, String username){
        this.userProfile = new UserProfile(name, username);
    }
    // Scanner scanner = new Scanner(System.in);
    private int goldCoins=500;
    private int xp=0;
    private String homeGround;
    private boolean isDefault = false;
    private Map<String, String> armourMap = new HashMap<>();
    private Map<String, String> artefactMap = new HashMap<>();
    private List<Charactors> armyList = new ArrayList<>();//dekak onn ne meka ekk karn puluwan
    private HashMap<String, Charactors> armyMap = new HashMap<>();
    boolean enableArchers = true, enableKnights = true, enableMages = true, enableHealers = true, enableMythicalCreatures = true;

    public void setIsDefault(){
        this.isDefault = true;
    }

    public void setArmourMap(String arm, String chra){
        armourMap.put(arm,chra);
    }
    public Map<String, String> getArmourMap(){
        return armourMap;
    }

    public void setArtefactMap(String art, String chra){
        artefactMap.put(art,chra);
    }
    public Map<String, String> getArtefactMap(){
        return artefactMap;
    }

    public void setArmyList(List<Charactors> armyList){
        this.armyList = armyList;
    }
    public List<Charactors> getArmyList(){
        return armyList;
    }
    public void setArmyMap(HashMap<String, Charactors> armyMap){
        this.armyMap = armyMap;
    }
    public HashMap<String, Charactors> getArmyMap(){
        return armyMap;
    }
    public String getUserName(){
        return this.userProfile.getUsername();
    }
    public String getName(){
        return this.userProfile.getName();
    }
    public void setGoldCoins(int amount){
        int roundedValue = (int) Math.round(amount);
        goldCoins += roundedValue;
    }
    public int getGoldCoins(){
        return goldCoins;
    }
    public void setXP(int amount){
        xp += amount;
    }
    public int getXP(){
        return xp;
    }

    //for default player
    public void setHomeGround(String homeGround){
        this.homeGround = homeGround;
    }
    public void setHomeGround(JTextArea outputTextArea){
        
        String homeGroundNumberStr = JOptionPane.showInputDialog(null, "1.Hillcrest\n2.Marshland\n3.Desert\n4.Arcane\nEnter the number of your homeground.");
        //convert string to int
        int homeGroundNumber = Integer.parseInt(homeGroundNumberStr);
        if(homeGroundNumber==1){
            this.homeGround = "Hillcrest";
        }
        else if(homeGroundNumber==2){
            this.homeGround = "Marshland";
        }
        else if(homeGroundNumber==3){
            this.homeGround = "Desert";
        }
        else{
            this.homeGround = "Arcane";
        }
    }
    public String getHomeGround(){
        return this.homeGround;
    }
    public int getUserId(){
        return this.userProfile.getUserID();
    }
    public void setCharactors(JTextArea outputTextArea){
        
        int charactorNumber = 0;
        int addMoreCharactors;
        do{
            if(goldCoins<=0) {
                break;
            }
            String charactorTypeNumberStr = JOptionPane.showInputDialog(null,"1.Archers\n2.Knights\n3.Mages\n4.Healers\n5.Mythical Creatures\nEnter the number of the character type you want to add to your army.");
            //convert string to int
            int charactorTypeNumber = Integer.parseInt(charactorTypeNumberStr);
            while(charactorTypeNumber <1 || charactorTypeNumber>5){
                JOptionPane.showMessageDialog(null,"You have entered invalid number ! Enter a valid number.");
                charactorTypeNumberStr = JOptionPane.showInputDialog(null,"1.Archers\n2.Knights\n3.Mages\n4.Healers\n5.Mythical Creatures\nEnter the number of the character type you want to add to your army.");
                charactorTypeNumber = Integer.parseInt(charactorTypeNumberStr);
            }

            if(!(enableArchers || enableKnights || enableHealers || enableMages || enableMythicalCreatures)) {
                JOptionPane.showMessageDialog(null,"You can't add more characters!");
                break;
            } 

            if(charactorTypeNumber ==1 ){
                if(enableArchers){
                    String charactorNumberStr = JOptionPane.showInputDialog("1.Shooter - 80 gc"+"\n2.Ranger - 115 gc"+"\n3.Sunfire - 160 gc"+"\n4.Zing - 200 gc"+"\n5.Saggitarius - 230 gc\n" + "Enter the number of the character you want to add to your army.");
                    charactorNumber = Integer.parseInt(charactorNumberStr);                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"You have already added an archer to your army !");
                }
            }
            else if(charactorTypeNumber ==2){
                if(enableKnights){
                    String charactorNumberStr = JOptionPane.showInputDialog("1.Squire - 85 gc"+"\n2.Cavalier - 110 gc"+"\n3.Templar - 155 gc"+"\n4.Zoro - 180 gc"+"\n5.Swiftblade - 250 gc" + "\nEnter the number of the character you want to add to your army.");
                    charactorNumber = Integer.parseInt(charactorNumberStr);
                }
                else{
                    JOptionPane.showMessageDialog(null,"You have already added a knight to your army !");
                }
            }
            else if(charactorTypeNumber ==3){
                if(enableMages){
                    String charactorNumberStr = JOptionPane.showInputDialog("1.Warlock - 100 gc"+"\n2.Illusionist - 120 gc"+"\n3.Enchanter - 170 gc"+"\n4.Conjurer - 210 gc"+"\n5.Eldritch - 250 gc" + "\nEnter the number of the character you want to add to your army.");
                    charactorNumber = Integer.parseInt(charactorNumberStr);
                }
                else{
                    JOptionPane.showMessageDialog(null,"You have already added a mage to your army !");
                }
            }
            else if(charactorTypeNumber ==4){
                if(enableHealers){
                    String charactorNumberStr = JOptionPane.showInputDialog("1.Soother - 95 gc"+"\n2.Medic - 125 gc"+"\n3.Alchemist - 150 gc"+"\n4.Saint - 200 gc"+"\n5.Lightbringer - 260 gc" + "\nEnter the number of the character you want to add to your army.");
                    charactorNumber = Integer.parseInt(charactorNumberStr);
                }
                else{
                    JOptionPane.showMessageDialog(null,"You have already added a healer to your army !");
                }
            }
            else{
                if(enableMythicalCreatures){
                    String charactorNumberStr = JOptionPane.showInputDialog("1.Dragon - 120 gc"+"\n2.Basilisk - 165 gc"+"\n3.Hydra - 205 gc"+"\n4.Phoenix - 275 gc"+"\n5.Pegasus - 340 gc" + "\nEnter the number of the character you want to add to your army.");
                    charactorNumber = Integer.parseInt(charactorNumberStr);
                }
                else{
                    JOptionPane.showMessageDialog(null,"You have already added a mythical creature to your army !");
                }
            }
             
            while(charactorTypeNumber <1 || charactorTypeNumber>5){
                String charactorNumberStr = JOptionPane.showInputDialog("You have entered invalid number ! Enter a valid number of the character.");
                charactorNumber = Integer.parseInt(charactorNumberStr);
            }

            buildCharactors(charactorTypeNumber, charactorNumber, outputTextArea);

            addMoreCharactors = JOptionPane.showConfirmDialog(null,"You want to add more charactors?");
        }while(addMoreCharactors == JOptionPane.YES_OPTION && goldCoins>0);
    }

    public void sellCharactors(String sellCharactorName, JTextArea outputTextAreax){
        if(armyMap.containsKey(sellCharactorName)){

            int roundedValue = (int) Math.round(armyMap.get(sellCharactorName).getPrice()*0.9);
            this.setGoldCoins(roundedValue);
            if(armyMap.get(sellCharactorName).getMyType().equals("Archers")) enableArchers =true;
            else if(armyMap.get(sellCharactorName).getMyType().equals("Knights")) enableKnights =true;
            else if(armyMap.get(sellCharactorName).getMyType().equals("Mages")) enableMages =true;
            else if(armyMap.get(sellCharactorName).getMyType().equals("Healers")) enableHealers =true;
            else if(armyMap.get(sellCharactorName).getMyType().equals("MythicalCreatures")) enableMythicalCreatures =true;
            armyMap.remove(sellCharactorName);

            Demo.playSound("res\\Buying Sound Effect.wav");
            outputTextAreax.append(sellCharactorName + " sold successfully.\n");
            outputTextAreax.append("Your total Gold Coins: " + getGoldCoins() + "\n");
        }
        else{
            JOptionPane.showMessageDialog(null,"You haven't "+sellCharactorName+" Charactor !");
        }
    }

    public List<Charactors> getCharactors(){
        return this.armyList;
    }
    public Map<String,Charactors> getCharactorsMap(){
        return this.armyMap;
    }

    // public boolean acceptWar(Player player1,JTextArea outputTextArea){
    //     outputTextArea.append("Your XP level : "+ player1.getXP()+"\n");
    //     outputTextArea.append("Your charactors : "+"\n");
    //     for (String key : player1.getCharactorsMap().keySet()) {
    //         outputTextArea.append(key+"  "+" ");
    //     }
    //     outputTextArea.append("\n\n");
        
    //     int ans = JOptionPane.showConfirmDialog(null,"Do you accept battle ? (Y/N)");
        
    //     if(ans == JOptionPane.YES_OPTION)return true;
    //     else return false;

    // }
    public void declareWar(Map<Integer, Player> profileMap, JTextArea outputTextArea){
        Random rand = new Random();
        int randInt = rand.nextInt(this.userProfile.getUserIDCounter()-1);
        while(randInt == this.userProfile.getUserID()){
            declareWar(profileMap, outputTextArea);
        }
        outputTextArea.append("Your opponent's XP level : "+ profileMap.get(randInt).getXP()+"\n");
        outputTextArea.append("Your opponent's charactors : "+"\n");
        for (String key : profileMap.get(randInt).getCharactorsMap().keySet()) {
            outputTextArea.append(key+"  "+" ");
        }
        outputTextArea.append("\n\n");

        int ans = JOptionPane.showConfirmDialog(null,"Challenge them to battle by clicking Yes or you can select another opponent by clicking No.");
        if(ans == JOptionPane.YES_OPTION){
                War war= new War(this,profileMap.get(randInt),profileMap.get(randInt).getHomeGround(),outputTextArea);
                if (war.winner == null){
                    outputTextArea.append("Battle Draw!\n\n");
                }
                else if(war.winner.equals(this)){
                    this.xp++;
                    outputTextArea.append(this.userProfile.getUsername()+" Win!\n\n");
                    int roundedValue = (int) Math.round(profileMap.get(randInt).getGoldCoins()*0.1);
                    this.setGoldCoins(roundedValue);
                    profileMap.get(randInt).setGoldCoins(-roundedValue);
                }else if(war.winner.equals(profileMap.get(randInt))){
                    profileMap.get(randInt).xp++;
                    outputTextArea.append(profileMap.get(randInt).userProfile.getUsername()+" Win!\n\n");
                    int roundedValue = (int) Math.round(this.getGoldCoins()*0.1);
                    profileMap.get(randInt).setGoldCoins(roundedValue);
                    this.setGoldCoins(-roundedValue);
                }
                //print result after the war
                outputTextArea.append("New XP levels and Gold Coins after the battle : \n\n");
                outputTextArea.append(this.userProfile.getUsername()+ " : "+this.getXP() + " XP ," + " Gold Coins : " +this.getGoldCoins()+"\n\n");
                outputTextArea.append(profileMap.get(randInt).userProfile.getUsername()+ " : "+profileMap.get(randInt).getXP()+ " XP ," + " Gold Coins : " +profileMap.get(randInt).getGoldCoins()+"\n\n");
                restore();//restore the charactors
                restoreArmour(); //restore the armours
                restoreArtefact();  //restore the artefacts
                profileMap.get(randInt).restore();  //restore the opponent's charactors
                profileMap.get(randInt).restoreArmour();    //restore the opponent's armours
                profileMap.get(randInt).restoreArtefact();      //restore the opponent's artefacts

        }else{
            declareWar(profileMap, outputTextArea);//select another opponent
        }
    }

    //buy armour and artefact for the charactor
    public void buyArmour(String charactorName, String armourName){
        
        if(armyMap.containsKey(charactorName)){
            armyMap.get(charactorName).setArmour(armourName, this,isDefault);

        }else{
            JOptionPane.showMessageDialog(null,"You haven't "+charactorName+" Charactor !");
        }
    }
    public void buyArtefact(String charactorName, String artefactName){
        if(armyMap.containsKey(charactorName)){
            armyMap.get(charactorName).setArtefact(artefactName, this,isDefault);

        }else{
            JOptionPane.showMessageDialog(null,"You haven't "+charactorName+" Charactor !");
        }
    }

    public void restoreArtefact(){
        for(String str: getArtefactMap().keySet()){
            Artefact ar;
            if(str.equals("Excalibur")){
                ar = new Excalibur();
            }else if(str.equals("Amulet")){
                ar = new Amulet();
            }else{
                ar = new Crystal();
            }
            if(armyMap.get(getArmourMap().get(str)) != null){
                int roundedValue = (int) Math.round(ar.getPrice()*0.2);
                armyMap.get(getArtefactMap().get(str)).setPrice(roundedValue);
                armyMap.get(getArtefactMap().get(str)).setHealth(ar.getDifHealth());
                armyMap.get(getArtefactMap().get(str)).setDefence(ar.getDifDefence());
                armyMap.get(getArtefactMap().get(str)).setSpeed(ar.getDifSpeed());
            }
        }
    }

    public void restoreArmour(){
        for(String str: getArmourMap().keySet()){
            Armour ar;
            if(str.equals("Chainmail")){
                ar = new Chainmail();
            }else if(str.equals("Regalia")){
                ar = new Regalia();
            }else{
                ar = new Fleece();
            }
            if(armyMap.get(getArmourMap().get(str)) != null){
                int roundedValue = (int) Math.round(ar.getPrice()*0.2);
                armyMap.get(getArmourMap().get(str)).setPrice(roundedValue);
                armyMap.get(getArmourMap().get(str)).setHealth(ar.getDifHealth());
                armyMap.get(getArmourMap().get(str)).setDefence(ar.getDifDefence());
                armyMap.get(getArmourMap().get(str)).setSpeed(ar.getDifSpeed());
            }   
        }
    }

    public void restore(){
        armyList.clear();
        for(String charA : armyMap.keySet()){
            if (charA.equals("Shooter")) {
                //buildCharactors(1, 1);
                armyMap.put(charA, new Shooter());
                armyList.add(new Shooter());
            }
            else if (charA.equals("Ranger")) {
                //buildCharactors(1, 2);
                armyMap.put(charA, new Ranger());
                armyList.add(new Ranger());
            }
            else if (charA.equals("Sunfire")) {
                //buildCharactors(1, 3);
                armyMap.put(charA, new Sunfire());
                armyList.add(new Sunfire());
                
            }
            else if (charA.equals("Zing")) {
                //buildCharactors(1, 4);
                armyMap.put(charA, new Zing());
                armyList.add(new Zing());
            }
            else if (charA.equals("Saggitarius")) {
                //buildCharactors(1, 5);
                armyMap.put(charA, new Saggitarius());
                armyList.add(new Saggitarius());
            }
            else if (charA.equals("Squire")) {
                //buildCharactors(2, 1);
                armyMap.put(charA, new Squire());
                armyList.add(new Squire());
            }
            else if (charA.equals("Cavalier")) {
                //buildCharactors(2, 2);
                armyMap.put(charA, new Cavalier());
                armyList.add(new Cavalier());
            }
            else if (charA.equals("Templar")) {
                //buildCharactors(2, 3);
                armyMap.put(charA, new Templar());
                armyList.add(new Templar());
            }
            else if (charA.equals("Zoro")) {
                //buildCharactors(2, 4);
                armyMap.put(charA, new Zoro());
                armyList.add(new Zoro());
            }
            else if (charA.equals("Swiftblade")) {
                //buildCharactors(2, 5);
                armyMap.put(charA, new Swiftblade());
                armyList.add(new Swiftblade());
            }
            else if (charA.equals("Warlock")) {
                //buildCharactors(3, 1);
                armyMap.put(charA, new Warlock());
                armyList.add(new Warlock());
            }
            else if (charA.equals("Illusionist")) {
                //buildCharactors(3, 2);
                armyMap.put(charA, new Illusionist());
                armyList.add(new Illusionist());
            }
            else if (charA.equals("Enchanter")) {
                //buildCharactors(3, 3);
                armyMap.put(charA, new Enchanter());
                armyList.add(new Enchanter());
            }
            else if (charA.equals("Conjurer")) {
               // buildCharactors(3, 4);
                armyMap.put(charA, new Conjurer());
                armyList.add(new Conjurer());
            }
            else if (charA.equals("Eldritch")) {
                //buildCharactors(3, 5);
                armyMap.put(charA, new Eldritch());
                armyList.add(new Eldritch());
            }
            else if (charA.equals("Soother")) {
                //buildCharactors(4, 1);
                armyMap.put(charA, new Soother());
                armyList.add(new Soother());
            }
            else if (charA.equals("Medic")) {
                //buildCharactors(4, 2);
                armyMap.put(charA, new Medic());
                armyList.add(new Medic());
            }
            else if (charA.equals("Alchemist")) {
                //buildCharactors(4, 3);
                armyMap.put(charA, new Alchemist());
                armyList.add(new Alchemist());
            }
            else if (charA.equals("Saint")) {
                //buildCharactors(4, 4);
                armyMap.put(charA, new Saint());
                armyList.add(new Saint());
            }
            else if (charA.equals("Lightbringer")) {
                //buildCharactors(4, 5);
                armyMap.put(charA, new Lightbringer());
                armyList.add(new Lightbringer());
            }
            else if (charA.equals("Dragon")) {
                //buildCharactors(5, 1);
                armyMap.put(charA, new Dragon());
                armyList.add(new Dragon());
            }
            else if (charA.equals("Basilisk")) {
                //buildCharactors(5, 2);
                armyMap.put(charA, new Basilisk());
                armyList.add(new Basilisk());
            }
            else if (charA.equals("Hydra")) {
                //buildCharactors(5, 3);
                armyMap.put(charA, new Hydra());
                armyList.add(new Hydra());
            }
            else if (charA.equals("Phoenix")) {
                //buildCharactors(5, 4);
                armyMap.put(charA, new Phoenix());
                armyList.add(new Phoenix());
            }
            else if (charA.equals("Pegasus")) {
                //buildCharactors(5, 5);
                armyMap.put(charA, new Pegasus());
                armyList.add(new Pegasus());
            }
            this.setArmyList(armyList);
            this.setArmyMap(armyMap);
            
            
        }
    }

    public void buildCharactors(int charactorTypeNumber, int charactorNumber, JTextArea outputTextArea){
        if(charactorTypeNumber ==1 && enableArchers){
            if(charactorNumber ==1){
                Charactors shooter = new Shooter();
                if(shooter.getPrice()<=goldCoins){
                    armyList.add(shooter);
                    armyMap.put("Shooter", shooter);
                    this.setGoldCoins(-(shooter.getPrice()));
                    enableArchers = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Shooter added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else if(charactorNumber ==2){
                Charactors ranger = new Ranger();
                if(ranger.getPrice()<=goldCoins){
                    armyList.add(ranger);
                    armyMap.put("Ranger", ranger);
                    this.setGoldCoins(-(ranger.getPrice()));
                    enableArchers = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Ranger added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else if(charactorNumber ==3){
                Charactors sunfire = new Sunfire();
                if(sunfire.getPrice()<=goldCoins){
                    armyList.add(sunfire);
                    armyMap.put("Sunfire", sunfire);
                    this.setGoldCoins(-(sunfire.getPrice()));
                    enableArchers = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Sunfire added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else if(charactorNumber ==4){
                Charactors zing = new Zing();
                if(zing.getPrice()<=goldCoins){
                    armyList.add(zing);
                    armyMap.put("Zing", zing);
                    this.setGoldCoins(-(zing.getPrice()));
                    enableArchers = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Zing added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else{
                Charactors saggitarius = new Saggitarius();
                if(saggitarius.getPrice()<=goldCoins){
                    armyList.add(saggitarius);
                    armyMap.put("Saggitarius", saggitarius);
                    this.setGoldCoins(-(saggitarius.getPrice()));
                    enableArchers = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Saggitarius added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }
        }else if(charactorTypeNumber ==2 && enableKnights){               
            if(charactorNumber ==1){
                Charactors squire = new Squire();
                if(squire.getPrice()<=goldCoins){
                    armyList.add(squire);
                    armyMap.put("Squire", squire);
                    this.setGoldCoins(-(squire.getPrice()));
                    enableKnights = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Squire added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else if(charactorNumber ==2){
                Charactors cavalier = new Cavalier();
                if(cavalier.getPrice()<=goldCoins){
                    armyList.add(cavalier);
                    armyMap.put("Cavalier", cavalier);
                    this.setGoldCoins(-(cavalier.getPrice()));
                    enableKnights = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Cavalier added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else if(charactorNumber ==3){
                Charactors templar = new Templar();
                if(templar.getPrice()<=goldCoins){
                    armyList.add(templar);
                    armyMap.put("Templar", templar);
                    this.setGoldCoins(-(templar.getPrice()));
                    enableKnights = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Templar added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else if(charactorNumber ==4){
                Charactors zoro = new Zoro();
                if(zoro.getPrice()<=goldCoins){
                    armyList.add(zoro);
                    armyMap.put("Zore", zoro);
                    this.setGoldCoins(-(zoro.getPrice()));
                    enableKnights = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Zoro added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else{
                Charactors swiftblade = new Swiftblade();
                if(swiftblade.getPrice()<=goldCoins){
                    armyList.add(swiftblade);
                    armyMap.put("Swiftblade", swiftblade);
                    this.setGoldCoins(-(swiftblade.getPrice()));
                    enableKnights = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Swiftblade added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }
        }else if(charactorTypeNumber ==3 && enableMages){
            if(charactorNumber ==1){
                Charactors warlock = new Warlock();
                if(warlock.getPrice()<=goldCoins){
                    armyList.add(warlock);
                    armyMap.put("Warlock", warlock);
                    this.setGoldCoins(-(warlock.getPrice()));
                    enableMages = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Warlock added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else if(charactorNumber ==2){
                Charactors illusionist = new Illusionist();
                if(illusionist.getPrice()<=goldCoins){
                    armyList.add(illusionist);
                    armyMap.put("Illusionist", illusionist);
                    this.setGoldCoins(-(illusionist.getPrice()));
                    enableMages = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Illusionist added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else if(charactorNumber ==3){
                Charactors enchanter = new Enchanter();
                if(enchanter.getPrice()<=goldCoins){
                    armyList.add(enchanter);
                    armyMap.put("Enchanter", enchanter);
                    this.setGoldCoins(-(enchanter.getPrice()));
                    enableMages = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Enchanter added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else if(charactorNumber ==4){
                Charactors conjurer = new Conjurer();
                if(conjurer.getPrice()<=goldCoins){
                    armyList.add(conjurer);
                    armyMap.put("Conjurer", conjurer);
                    this.setGoldCoins(-(conjurer.getPrice()));
                    enableMages = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Conjurer added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else{
                Charactors eldritch = new Eldritch();
                if(eldritch.getPrice()<=goldCoins){
                    armyList.add(eldritch);
                    armyMap.put("Eldritch", eldritch);
                    this.setGoldCoins(-(eldritch.getPrice()));
                    enableMages = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Eldritch added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }
        }else if(charactorTypeNumber ==4 && enableHealers){
            if(charactorNumber ==1){
                Charactors soother = new Soother();
                if(soother.getPrice()<=goldCoins){
                    armyList.add(soother);
                    armyMap.put("Soother", soother);
                    this.setGoldCoins(-(soother.getPrice()));
                    enableHealers = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Soother added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else if(charactorNumber ==2){
                Charactors medic = new Medic();
                if(medic.getPrice()<=goldCoins){
                    armyList.add(medic);
                    armyMap.put("Medic", medic);
                    this.setGoldCoins(-(medic.getPrice()));
                    enableHealers = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Medic added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else if(charactorNumber ==3){
                Charactors alchemist = new Alchemist();
                if(alchemist.getPrice()<=goldCoins){
                    armyList.add(alchemist);
                    armyMap.put("Alchemist", alchemist);
                    this.setGoldCoins(-(alchemist.getPrice()));
                    enableHealers = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Alchemist added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else if(charactorNumber ==4){
                Charactors saint = new Saint();
                if(saint.getPrice()<=goldCoins){
                    armyList.add(saint);
                    armyMap.put("Saint", saint);
                    this.setGoldCoins(-(saint.getPrice()));
                    enableHealers = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Saint added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else{
                Charactors lightbringer = new Lightbringer();
                if(lightbringer.getPrice()<=goldCoins){
                    armyList.add(lightbringer);
                    armyMap.put("Lightbringer", lightbringer);
                    this.setGoldCoins(-(lightbringer.getPrice()));
                    enableHealers = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Lightbringer added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }
        }else if(charactorTypeNumber ==5 && enableMythicalCreatures){
            if(charactorNumber ==1){
                Charactors dragon = new Dragon();
                if(dragon.getPrice()<=goldCoins){
                    armyList.add(dragon);
                    armyMap.put("Dragon", dragon);
                    this.setGoldCoins(-(dragon.getPrice()));
                    enableMythicalCreatures = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Dragon added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else if(charactorNumber ==2){
                Charactors basilisk = new Basilisk();
                if(basilisk.getPrice()<=goldCoins){
                    armyList.add(basilisk);
                    armyMap.put("Basilisk", basilisk);
                    this.setGoldCoins(-(basilisk.getPrice()));
                    enableMythicalCreatures = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Basilisk added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else if(charactorNumber ==3){
                Charactors hydra = new Hydra();
                if(hydra.getPrice()<=goldCoins){
                    armyList.add(hydra);
                    armyMap.put("Hydra", hydra);
                    this.setGoldCoins(-(hydra.getPrice()));
                    enableMythicalCreatures = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Hydra added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else if(charactorNumber ==4){
                Charactors phoenix = new Phoenix();
                if(phoenix.getPrice()<=goldCoins){
                    armyList.add(phoenix);
                    armyMap.put("Phoenix", phoenix);
                    this.setGoldCoins(-(phoenix.getPrice()));
                    enableMythicalCreatures = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Phoenix added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }else{
                Charactors pegasus = new Pegasus();
                if(pegasus.getPrice()<=goldCoins){
                    armyList.add(pegasus);
                    armyMap.put("Pegasus", pegasus);
                    this.setGoldCoins(-(pegasus.getPrice()));
                    enableMythicalCreatures = false;
                    Demo.playSound("res\\Buying Sound Effect.wav");
                    outputTextArea.append("Pegasus added to your army.\n");
                    outputTextArea.append("Gold coins left : "+goldCoins+"\n");
                }else{
                    JOptionPane.showMessageDialog(null,"There is no sufficient gold coins to buy that character !");
                }
            }
          
        } 
    }
    
}




