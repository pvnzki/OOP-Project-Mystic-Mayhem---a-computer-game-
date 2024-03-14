package bin;
class Armour{
    private int price;
    private double difDefence;
    private double difHealth;
    private double difSpeed;
    public Armour(int price,double difDefence,double difHealth,double difSpeed){
        this.price = price;
        this.difDefence = difDefence;
        this.difHealth = difDefence;
        this.difSpeed = difSpeed;
    }
    public int getPrice(){
        return price;
    }
    public double getDifDefence(){
        return difDefence;
    }
    public double getDifHealth(){
        return difHealth;
    }
    public double getDifSpeed(){
        return difSpeed;
    }
}

class Chainmail extends Armour{
    public Chainmail(){
        super(70,1,0,-1);
    }
}

class Regalia extends Armour{
    public Regalia(){
        super(105,1,0,0);
    }
}

class Fleece extends Armour{
    public Fleece(){
        super(150,2,1,-1);
    }
}

class Artefact{
    private int price;
    private double difDefence;
    private double difHealth;
    private double difSpeed;
    private double difAttack;
    public Artefact(int price,double difDefence,double difHealth,double difSpeed,double difAttack){
        this.price = price;
        this.difDefence = difDefence;
        this.difHealth = difDefence;
        this.difSpeed = difSpeed;
        this.difAttack = difAttack;
    }
    public int getPrice(){
        return price;
    }
    public double getDifDefence(){
        return difDefence;
    }
    public double getDifHealth(){
        return difHealth;
    }
    public double getDifSpeed(){
        return difSpeed;
    }
    public double getDifAttack(){
        return difAttack;
    }
}

class Excalibur extends Artefact{
    public Excalibur(){
        super(150,0,0,0,2);
    }
}

class Amulet extends Artefact{
    public Amulet(){
        super(200,-1,1,1,1);
    }
}

class Crystal extends Artefact{
    public Crystal(){
        super(210,1,-1,-1,2);
    }
}

