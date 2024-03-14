package bin;
import java.util.List;

import javax.swing.JTextArea;

class War {
    List<Charactors> armyList1, armyList2, attackArmy1, attackArmy2, receivingArmy1, receivingArmy2, healerAttackArmy1, healerAttackArmy2;
    String battleHomeGround;
    Player player1, player2, winner = null;
    public War(Player player1, Player palyer2, String homeGround,JTextArea outpuTextArea){
        this.player1 = player1;
        this.player2 = palyer2;
        this.armyList1 = player1.getCharactors();
        this.armyList2 = palyer2.getCharactors();
        this.battleHomeGround = homeGround;
        battle(outpuTextArea);
    }
    

    public void setAttackPriorityWar(Charactors charA){
        if(charA.getMyType().equals("Archers")) charA.setAttackPriority(5);
        else if(charA.getMyType().equals("Knights")) charA.setAttackPriority(4);
        else if(charA.getMyType().equals("MythicalCreatures")) charA.setAttackPriority(3);
        else if(charA.getMyType().equals("Mages")) charA.setAttackPriority(2);
        else charA.setAttackPriority(1);
    }
    public void setReceivePriorityWar(Charactors charA){
        if(charA.getMyType().equals("Archers")) charA.setReceivePriority(3);
        else if(charA.getMyType().equals("Knights")) charA.setReceivePriority(2);
        else if(charA.getMyType().equals("MythicalCreatures")) charA.setReceivePriority(4);
        else if(charA.getMyType().equals("Mages")) charA.setReceivePriority(1);
        else charA.setReceivePriority(5);
    }
    public List<Charactors> setAttackOrder(List<Charactors> armyList){
        
        for (int i = 0; i < armyList.size()-1; i++){
            for(int j = 0; j < armyList.size()-i-1; j++){
                if(armyList.get(j).getspeed() == armyList.get(j + 1).getspeed()){
                    setAttackPriorityWar(armyList.get(j));
                    setAttackPriorityWar(armyList.get(j + 1));
                    if(armyList.get(j).getAttackPriority()<armyList.get(j + 1).getAttackPriority()){
                        Charactors tempVar = armyList.get(j + 1);
                        armyList.remove(armyList.get(j+1));
                        armyList.add(j+1,armyList.get(j));
                        armyList.remove(armyList.get(j));
                        armyList.add(j,tempVar);
                    }
                }
                else if(armyList.get(j).getspeed() < armyList.get(j + 1).getspeed()){
                    Charactors tempVar = armyList.get(j + 1);
                        armyList.remove(armyList.get(j+1));
                        armyList.add(j+1,armyList.get(j));
                        armyList.remove(armyList.get(j));
                        armyList.add(j,tempVar);
                }
            }
        }
        return armyList;
    }

    public List<Charactors> setReceivingAttackOrder(List<Charactors> armyList){
        for (int i = 0; i < armyList.size()-1; i++){
            for(int j = 0; j < armyList.size()-i-1; j++){
                if(armyList.get(j).getDefence() == armyList.get(j + 1).getDefence()){
                    setReceivePriorityWar(armyList.get(j));
                    setReceivePriorityWar(armyList.get(j + 1));
                    if(armyList.get(j).getReceivePriority()<armyList.get(j + 1).getReceivePriority()){
                        Charactors tempVar = armyList.get(j + 1);
                        armyList.remove(armyList.get(j+1));
                        armyList.add(j+1,armyList.get(j));
                        armyList.remove(armyList.get(j));
                        armyList.add(j,tempVar);
                    }
                }
                if(armyList.get(j).getDefence() > armyList.get(j + 1).getDefence()){
                    Charactors tempVar = armyList.get(j + 1);
                    armyList.remove(armyList.get(j+1));
                    armyList.add(j+1,armyList.get(j));
                    armyList.remove(armyList.get(j));
                    armyList.add(j,tempVar);
                }
            }
        }
        return armyList;
    }

    public List<Charactors> setHealerAttackOrder(List<Charactors> armyList){
        for (int i = 0; i < armyList.size()-1; i++){
            for(int j = 0; j < armyList.size()-i-1; j++){
                if(armyList.get(j).gethealth() > armyList.get(j + 1).gethealth()){
                    Charactors tempVar = armyList.get(j + 1);
                    armyList.remove(armyList.get(j+1));
                    armyList.add(j+1,armyList.get(j));
                    armyList.remove(armyList.get(j));
                    armyList.add(j,tempVar);
                }
            }
        }
        return armyList;
    }

    public void adjustCharactorBehaviour(Charactors charA){
        if(battleHomeGround.equals("Hillcrest")){
            if(charA.getHomeLand().equals("Hillcrest")){
                charA.setAttack(1);
                charA.setDefence(1);
                charA.setIsBonus();//attacking power eka 20% wadi karn seen ekat 
            }else if(charA.getHomeLand().equals("Marshland") || charA.getHomeLand().equals("Desert")){
                charA.setSpeed(-1);
            }
        }else if(battleHomeGround.equals("Marshland")){
            if(charA.getHomeLand().equals("Marshland")){
                charA.setDefence(2); 
            }else if(charA.getHomeLand().equals("Desert") ){
                charA.setAttack(-1);
            }else if(charA.getHomeLand().equals("Arcane") ){
                charA.setSpeed(-1);
            }
        }else if(battleHomeGround .equals("Desert")){
            if(charA.getHomeLand().equals("Desert") ){
                charA.setAttack(1); 
            }else if(charA.getHomeLand().equals("Marshland")){
                charA.setHealth(-1);
            }
        }else{
            if(charA.getHomeLand().equals("Arcane") ){
                charA.setAttack(2);
                charA.setIsBonus(); 
            }else if(charA.getHomeLand().equals("Marshland")  || charA.getHomeLand().equals("Hillcrest") ){
                charA.setSpeed(-1);
                charA.setDefence(-1);
            }
        }
    }

    public List<Charactors> bonusHillcrest(JTextArea outpuTextArea){
        receivingArmy2.get(0).setHealth(-((0.5*attackArmy1.get(0).getattack()*0.2)-(0.1*receivingArmy2.get(0).getDefence())));
        if(receivingArmy2.get(0).gethealth()<=0) {
            outpuTextArea.append(receivingArmy2.get(0).getName() + " died!");
            armyList2.remove(receivingArmy2.get(0));
        }
        return receivingArmy2;
    }
    public Charactors attack(List<Charactors> army1, List<Charactors> army2, double attackAmount, double defenceAmount, JTextArea outputTextArea){
        outputTextArea.append(army1.get(0).getName() + " attacks " + army2.get(0).getName() +"\n\n");
        army2.get(0).setHealth(attackAmount+defenceAmount);
        if(army1.get(0).getHomeLand().equals(battleHomeGround) && battleHomeGround.equals("Arcane")) army1.get(0).setHealth(army1.get(0).gethealth()*0.1);
        outputTextArea.append(army2.get(0).getName()+ "'s health: "+ army2.get(0).gethealth()+"\n");
        outputTextArea.append(army1.get(0).getName()+ "'s health: "+ army1.get(0).gethealth()+"\n\n");
        if(army2.get(0).gethealth()<=0) {
            outputTextArea.append(army2.get(0).getName() + " died!"+"\n\n");
            return (army2.get(0));
        }
        return null;
    }

    public void battle(JTextArea outpuTextArea){

        //print fighting text loader in outputTextArea
        outpuTextArea.append("Battle between " + player1.getName() + " and " + player2.getName() + " in " + battleHomeGround + "\n\n");

        // //loading splash screen in outputTextArea
        // outpuTextArea.append("Fighting....\n\n");
        // outpuTextArea.append("Please Wait for the result\n\n");
        // outpuTextArea.append("---------------------------------------------------\n\n");

        //loader screen dots in outputTextArea using a for loop
        // for(int i=0; i<10; i++){
        //     outpuTextArea.append(".");
        //     try {
        //         Thread.sleep(500);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // }
        outpuTextArea.append("\n\n");

        for(Charactors charA:armyList1){
            adjustCharactorBehaviour(charA);
        }
        for(Charactors charA:armyList2){
            adjustCharactorBehaviour(charA);
        }
        int turnNo =1;
        for(int i=0; i<10; i++){
            attackArmy1= setAttackOrder(armyList1);

            if(!attackArmy1.get(0).getMyType().equals("Healers")){
                outpuTextArea.append("Turn "+ turnNo +":" + attackArmy1.get(0).getName() + "\n\n");
                turnNo ++;
                receivingArmy2 = setReceivingAttackOrder(armyList2);
                Charactors diedCharactor = attack(attackArmy1, receivingArmy2, -0.5*attackArmy1.get(0).getattack(), 0.1*receivingArmy2.get(0).getDefence(), outpuTextArea);
                if(diedCharactor != null) armyList2.remove(diedCharactor);
                
                if(attackArmy1.get(0).getHomeLand().equals(battleHomeGround) && battleHomeGround.equals("Hillcrest")){
                    outpuTextArea.append("Bonus Turn "+ turnNo +":" + attackArmy1.get(0).getName()+ "\n\n");
                    turnNo ++;
                    receivingArmy2 = setReceivingAttackOrder(armyList2);
                    diedCharactor = attack(attackArmy1, receivingArmy2, -0.5*attackArmy1.get(0).getattack()*0.2, 0.1*receivingArmy2.get(0).getDefence(), outpuTextArea);
                    if(diedCharactor != null) armyList2.remove(diedCharactor);
                }
            }else{
                outpuTextArea.append("Turn "+ turnNo +":" + attackArmy1.get(0).getName()+ "\n\n");
                turnNo ++;
                healerAttackArmy1 = setHealerAttackOrder(armyList1);
                attack(attackArmy1, healerAttackArmy1, 0.1*attackArmy1.get(0).getattack(), 0,outpuTextArea);//meken maren nee
                
                if(attackArmy1.get(0).getHomeLand().equals(battleHomeGround) && battleHomeGround.equals("Hillcrest")){
                    outpuTextArea.append("Bonus Turn "+ turnNo +":" + attackArmy1.get(0).getName()+ "\n\n");
                    turnNo ++;
                    healerAttackArmy1 = setHealerAttackOrder(armyList1);
                    attack(attackArmy1, healerAttackArmy1, 0.1*attackArmy1.get(0).getattack()*0.2, 0,outpuTextArea);
                }
            }
            if(armyList2.size() !=0){
                attackArmy2= setAttackOrder(armyList2);
                
                if(!attackArmy2.get(0).getMyType().equals("Healers")){
                    outpuTextArea.append("Turn "+ turnNo +":" + attackArmy2.get(0).getName()+ "\n\n");
                    turnNo ++;
                    receivingArmy1 = setReceivingAttackOrder(armyList1);
                    Charactors diedCharactor = attack(attackArmy2, receivingArmy1, -0.5*attackArmy2.get(0).getattack(), 0.1*receivingArmy1.get(0).getDefence(), outpuTextArea);

                    if(diedCharactor != null) armyList1.remove(diedCharactor);
                    
                    if(attackArmy2.get(0).getHomeLand().equals(battleHomeGround) && battleHomeGround.equals("Hillcrest")){
                        outpuTextArea.append("Bonus Turn "+ turnNo +":" + attackArmy1.get(0).getName()+ "\n\n");
                        turnNo ++;
                        receivingArmy1 = setReceivingAttackOrder(armyList1);
                        diedCharactor = attack(attackArmy2, receivingArmy1, -0.5*attackArmy2.get(0).getattack()*0.2, 0.1*receivingArmy1.get(0).getDefence(), outpuTextArea);
                        
                        if(diedCharactor != null) armyList1.remove(diedCharactor);
                    }
                }else{
                    outpuTextArea.append("Turn "+ turnNo +":" + attackArmy2.get(0).getName()+ "\n\n");
                    turnNo ++;
                    healerAttackArmy2 = setHealerAttackOrder(armyList2);
                    attack(attackArmy2, healerAttackArmy2, 0.1*attackArmy2.get(0).getattack(), 0,outpuTextArea);//meken maren nee

                    if(attackArmy2.get(0).getHomeLand().equals(battleHomeGround) && battleHomeGround.equals("Hillcrest")){
                        outpuTextArea.append("Bonus Turn "+ turnNo +":" + attackArmy2.get(0).getName()+ "\n\n");
                        turnNo ++;
                        healerAttackArmy2 = setHealerAttackOrder(armyList2);
                        attack(attackArmy1, healerAttackArmy1, 0.1*attackArmy1.get(0).getattack()*0.2, 0,outpuTextArea);
                    }
                }
            }
            if(armyList1.isEmpty()){
                winner=  player2;
                break;
            }else if(armyList2.isEmpty()){
                winner = player1;
                break;
            }
        } 
        
    }

}