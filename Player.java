public class Player extends Character{
    
    // intergers to store number of upgrades/skills in each path
    public int numAtkUpgrades, numDefUpgrades;

    // additional player stats
    int gold, restsLeft, pots;
    
    // Arrays to store skill names
    public String[] atkUpgrades = {"Strength", "Power", "Might", "Godlike Srength"};
    public String[] defUpgrades = {"Heavy Bones", "Stoneskin", "Scale Armor", "Holy Aura"};
    
    // Player specific constructor
    public Player(String name) {
        // calling constructor of superClass
        super(name, 100, 0);
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        // set additional stats
        this.gold = 5;
        this.restsLeft = 1;
        this.pots = 0;
        // let the player choose a trait when creating a new character
        chooseTrait();
    }

    @Override
    public int attack() {
        return (int) (Math.random()*(xp/4 + numAtkUpgrades*3 + 3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades + 1);
    }

    @Override
    public int defend() {
        return (int) (Math.random()*(xp/4 + numDefUpgrades*3 + 3) + xp/10 + numDefUpgrades*2 + numAtkUpgrades + 1);
    }

    public void chooseTrait() {
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait: ");
        System.out.println("(1) "+atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) "+defUpgrades[numDefUpgrades]);
        // get the players choice:
        int input = GameLogic.readInt("-> ", 2);
        GameLogic.clearConsole();
        // deal with both classes
        if (input == 1) {
            GameLogic.printHeading("You chose "+ atkUpgrades[numAtkUpgrades] +"!");
            numAtkUpgrades++;
        }
        else {
            GameLogic.printHeading("You chose "+ defUpgrades[numDefUpgrades] +"!");
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();
    }
}