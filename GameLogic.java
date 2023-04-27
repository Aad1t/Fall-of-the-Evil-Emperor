// Name: Aadit Gupta
// Date: April 13, 2023
// Purpose: This game will be a simulation of someone going through a journey on a quest to defet the evil emperor who has ruined his life.

import java.util.*;
import javax.swing.*;
import javax.swing.ImageIcon;


public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static boolean isRunning;

    static boolean help;

    // random encounters
    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};

    // enemy names
    public static String[] enemies = {"Ogre", "Demon", "Goblin", "Wizard", "Thanos"};

    // Story elements
    public static int place = 0, act = 1;
    public static String[] places = {"Everlasting Mountains", "Haunted Landmines", "Castle of the Evil Emperor", "Throne Room"};

    // method to get user input from console
    public static int readInt(String prompt, int userChoice) {
        int input;
        do{
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter an integer!");
            }
        } while (input < 1 || input > userChoice);
        return input;
    }

    // method to simulate clearing out the console
    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    // method to print a seperator with length n
    public static void printSeperator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // method to print a heading
    public static void printHeading(String title) {
        printSeperator(30);
        System.out.println(title);
        printSeperator(30);
    }

    // method to stop the game until user enters anything
    public static void anythingToContinue() {
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = GameLogic.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        }
        else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    // method to start the game
    public static void startGame(){
        JFrame frame = new JFrame();
        frame.setSize(470, 350);
        JOptionPane.showMessageDialog(frame, createImageIcon("Evil_Emperor.jpg"), "Welcome to my game: Fall of the Evil Emperor", JOptionPane.INFORMATION_MESSAGE);
        boolean nameSet = false;
        String name;
        // print title screen
        clearConsole();
        System.out.println(java.time.LocalDate.now());
        ASCII_ART.Kingdom();
        printSeperator(40);
        printSeperator(30);
        System.out.println("___________      .__  .__            _____  ___________.__             ___________     .__.__    ___________                                         ");
		System.out.println("\\_   _____/____  |  | |  |     _____/ ____\\ \\__    ___/|  |__   ____   \\_   _____/__  _|__|  |   \\_   _____/ _____ ______   ___________  ___________ ");
		System.out.println(" |    __) \\__  \\ |  | |  |    /  _ \\   __\\    |    |   |  |  \\_/ __ \\   |    __)_\\  \\/ /  |  |    |    __)_ /     \\\\____ \\_/ __ \\_  __ \\/  _ \\_  __ \\");
		System.out.println(" |     \\   / __ \\|  |_|  |__ (  <_> )  |      |    |   |   Y  \\  ___/   |        \\\\   /|  |  |__  |        \\  Y Y  \\  |_> >  ___/|  | \\(  <_> )  | \\/");
		System.out.println(" \\___  /  (____  /____/____/  \\____/|__|      |____|   |___|  /\\___  > /_______  / \\_/ |__|____/ /_______  /__|_|  /   __/ \\___  >__|   \\____/|__|   ");
		System.out.println("     \\/        \\/                                           \\/     \\/          \\/                        \\/      \\/|__|        \\/                    ");
        IO.printSlow("TEXT RPG BY AADIT");
        printSeperator(30);
        printSeperator(40);
        anythingToContinue();
        // Math riddle to check if user is ready for the quest
        clearConsole();
        ASCII_ART.puzzle();
        IO.printSlow("\nTo Make Sure You Are Ready to go on This Quest, Here is a Quick Math Problem for you to Solve", 50);
        System.out.println();
        printHeading("BRAIN TEASER");
        int ans = 0;
        System.out.println("\nWhat is 5^2 + 2(8 + 6) / 4 ?");
        while (ans != 32) {
            ans = IO.inputInt("\nEnter your response -> ");
            if (ans != 32) {
                IO.printSlow("\nTry Again!", 20);
            }
        }
        IO.printSlow("\nCONGRATULATIONS! YOU ARE READY TO BEGIN YOUR AMAZING JOURNEY ON THIS QUEST", 50);

        // getting the player name
        do {
            clearConsole();
            printHeading("What is your name?");
            name = scanner.next();
            // asking the player if he wants to correct his choice
            clearConsole();
            printHeading("You name is "+name+".\nIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change my name.");
            int input = readInt("-> ", 2);
            if (input == 1) {
                nameSet = true;
            }
        } while(!nameSet);
        // print story intro
        Story.printIntro();
        // create new player object with the name
        player = new Player(name);
        // print first story act intro
        Story.printFirstActIntro();
        // setting isRunning to true, so the game loop can continue
        isRunning = true;
        // start main game loop
        gameLoop();
    }

    // method that asks the user to help out the stranger
    public static boolean HelpStranger() {
        // This somebody will be warden introduced late in prison act
        GameLogic.clearConsole();
        ASCII_ART.Stranger();
        IO.printSlow("\nOh wait! You suddenly find someone who looks in trouble.", 50);
        IO.printSlow("His foot is stuck in the mud.", 50);
        IO.printSlow("Are you going to help him out or no..", 50);
        IO.printSlow("REMEBER by choosing to input random integer or digit, you are neglecting to help the man.", 50);
        // gives user the choice to help or not
        char choice = IO.inputChar("Enter yes or no (y/n): ");
        switch (choice) {
            case 'y':
                IO.printSlow("\nNICE! YOU SAVED THE MAN'S LIFE!", 65);
                anythingToContinue();
                return  true;
        }
        IO.printSlow("\nYOU ARE GOING TO REGRET YOUR CHOICE LATER", 65);
        anythingToContinue();
        return false;
    }

    public static void PrisonEscape() {
        IO.printSlow("\nYou have three tries to guess the pin!", 50);
        IO.printSlow("If you are unsuccessful, you shall be locked here eternally.", 50);
        int tries = 0;
        // loop that asks user to enter the pin 3 times
        for (int i = 1; i <= 3; i++) {
            int guess = IO.inputInt("\nGuess the Pin (It is 4-digit): ");
            if (guess == 3719) {
                IO.printSlow("\nCONGRATULATIONS, you guessed the pin and now you are free.");
                break;
            }
            else {
                // helps user come up with the guess
                String high_guess = "Your guess was higher than the actual pin.";
                String low_guess = "Your guess was lower than the actual pin.";
                String pin_help = guess > 3917 ? high_guess : low_guess;
                System.out.println(pin_help);
                tries += 1;
            }
        }
        // game ends if user is unable to guess the right pin within 3 attempts
        if (tries == 3) {
            IO.printSlow("\nUnfortunately, you were not able to guess the pin in three atempts.", 50);
            IO.printSlow("As a result, the guards of the prison have been notified about your attempt to escape.", 50);
            IO.printSlow("Hence, you are locked here eternally", 50);
            playerDied();
        }
        // or else it continues...
        else {
            IO.printSlow("You are free to move on, in this journey.", 50);
            IO.printSlow("Good Luck against your final battle with the Evil Emperor!", 50);
            anythingToContinue();
        }
    }

    public static void checkAct() {
        // change acts based on xp
        if (player.xp >= 5 && act == 1) {
            // increment act and place
            act = 2;
            place = 1;
            // story
            Story.printFirstActOutro();
            // let the player "level up"
            player.chooseTrait();
            // story 
            Story.printSecondActIntro();
            // assign new values to enemies
            enemies[0] = "Evil Mercenary";
            enemies[1] = "Goblin";
            enemies[2] = "Wolve Pack";
            enemies[3] = "Henchman of the Evil Emperor";
            enemies[4] = "Scary Stranger";
            // assign new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Shop";
        }
        else if (player.xp >= 25 && act == 2) {
            // increment act and place
            act = 3;
            place = 2;
            // story
            Story.printSecondActOutro();
            // lvl up
            player.chooseTrait();
            // Help strange
            help = HelpStranger();
            // story
            Story.printThirdActIntro();
            // assign new values to enemies
            enemies[0] = "Evil Mercenary";
            enemies[1] = "Evil Mercenary";
            enemies[2] = "Henchman of the Evil Emperor";
            enemies[3] = "Henchman of the Evil Emperor";
            enemies[4] = "Henchman of the Evil Emperor";
            // assign new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Battle";
            encounters[4] = "Shop";
            // fully heal the player
            player.hp = player.maxHp;   
        }
        else if (player.xp >= 50 && act == 3) {
            // increment act and place
            act = 4;
            place = 3;
            Story.printPrisonActIntro();
            // provides the clue only if the user helped the stranger
            if (help) {
                Story.printPrisonActOutro();
                Story.Note();
            }
            PrisonEscape();
            if (isRunning) {
                // story
                Story.printThirdActOutro();
                // lvl up
                player.chooseTrait();
                // story
                Story.printFourthActIntro();
                // fully heal the player
                player.hp = player.maxHp;
                // calling the final battle
                finalBattle();
            }
        }
    }

    // method to calculate a random encounter
    public static void randomEncounter() {
        // random number between 0 and the length of the encounters array
        int encounter = (int) (Math.random() * encounters.length);
        // calling the respective methods
        if (encounters[encounter].equals("Battle")) {
            randomBattle();
        }
        else if (encounters[encounter].equals("Rest")) {
            takeRest();
        }
        else {
            shop();
        }
    }

    // method to continue the journey (more next part)
    public static void continueJourney() {
        // check if act must be increase
        checkAct();
        // check if game isn't in the last act
        if (act != 4) {
            randomEncounter();
        }
    }

    // printing out the information about the player character
    public static void characterInfo() {
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeperator(20);
        System.out.println("XP: " + player.xp);
        printSeperator(20);
        // player xp and gold
        System.out.println("XP: " + player.xp + "\tGold: " + player.gold);
        printSeperator(20);
        // # of pots
        System.out.println("Number of Potions: " + player.pots);
        printSeperator(20);

        // printing the choosen traits
        if (player.numAtkUpgrades > 0) {
            System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeperator(20);
        }
        if (player.numDefUpgrades > 0) {
            System.out.println("Defensive Trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
        }
        anythingToContinue();
    }

    // shopping / encountering a travelling trader
    public static void shop() {
        clearConsole();
        printHeading("You meet a mysterious stranger (possibly a merchant perhaps). \n He offers you something:");
        int price = (int) (Math.random() * (5 + player.pots*3) + 5 + player.pots);
        System.out.println("- Magic Potion: " + price + " gold.");
        printSeperator(30);
        // ask the player to buy one
        System.out.println("Do you want to buy one?\n(1) Yes!\n(2) No thanks.");
        int input = readInt("-> ", 2);
        // check if the player wants to buy
        if (input == 1) {
            clearConsole();
            // check if player has enough gold
            if (player.gold >= price) {
                printHeading("You bought a magic potion for " + price + "gold.");
                player.pots++;
                player.gold -= price;
            }
            else {
                printHeading("You don't have enough gold to buy this...");
            }
            anythingToContinue();
        }
    }

    // taking a rest
    public static void takeRest() {
        clearConsole();
        if (player.restsLeft >= 1) {
            printHeading("Do you want to take a rest? (" + player.restsLeft + " rest(s) left).");
            System.out.println("(1) Yes\n(2) No, not now.");
            int input = readInt("-> ", 2);
            if (input == 1) {
                // player actually takes rest
                clearConsole();
                if (player.hp < player.maxHp) {
                    int hpRestored = (int) (Math.random() * (player.xp/4 + 1) + 10);
                    player.hp += hpRestored;
                    if (player.hp > player.maxHp) {
                        player.hp = player.maxHp;
                    }
                    System.out.println("You took a rest and restored up to " + hpRestored + " health.");
                    System.out.println("You're now at " + player.hp + "/" + player.maxHp + " health.");
                    player.restsLeft--;
                }
                else {
                    System.out.println("You're at full health. You don't need to rest now!");
                }
                anythingToContinue();
            }
        }
    }

    // creating a random battle
    public static void randomBattle() {
        clearConsole();
        printHeading("You encountered an evil creature. Fight it to move on.");
        anythingToContinue();
        // creating new enemy with random name
        battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], player.xp));
    }

    // the main Battle methods
    public static void battle (Enemy enemy) {
        // main battle loop
        while(true) {
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
            System.out.println("Choose an action: ");
            printSeperator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Run Away");
            int input = readInt("-> ", 3);
            if (input == 1) {
                // FIGHT
                // calculate damage given and damage taken
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();
                // check damage isn't negtive
                if (dmgTook < 0) {
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }
                if (dmg < 0) {
                    dmg = 0;
                }
                // deal damage to both parties
                player.hp -= dmgTook;
                enemy.hp -= dmg;
                // print the info of this battle round
                clearConsole();
                printHeading("BATTLE");
                System.out.println("You dealth " + dmg + " damage to the " + enemy.name + ".");
                printSeperator(15);
                System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you.");
                anythingToContinue();
                // check if player is still alive or dead
                if (player.hp <= 0) {
                    playerDied(); // method to end the game
                    break;
                }
                else if (enemy.hp <= 0) {
                    clearConsole();
                    printHeading("You defeated the " + enemy.name + "!");
                    // increase the player xp
                    player.xp += enemy.xp;
                    System.out.println("You earned " + enemy.xp + " XP!");
                    // random drops
                    boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                    int goldEarned = (int) (Math.random()*enemy.xp);
                    if (addRest) {
                        player.restsLeft++;
                        System.out.println("YOu earned the chance to get an additional rest!");
                    }
                    if (goldEarned > 0) {
                        player.gold += goldEarned;
                        System.out.println("You collect " + goldEarned + " gold from the " + enemy.name + "'s corpse!");
                    }
                    anythingToContinue();
                    break;
                }
            }
            else if (input == 2) {
                // USE POTION
                clearConsole();
                if(player.pots > 0 && player.hp < player.maxHp) {
                    printHeading("Do you want to drink a potion? (" + player.pots + " left).");
                    System.out.println("(1) Yes\n(2) No, maybe later");
                    input = readInt("-> ", 2);
                    if (input == 1) {
                        // player actually took it
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("You drank a magic potion. It restored your health back to " + player.maxHp);
                        anythingToContinue();
                    }
                }
                else {
                    printHeading("You don't have any potions or you are at full health.");
                    anythingToContinue();
                }
            }
            else {
                // RUNAWAY
                clearConsole();
                // check that player isn't in last act (final boss battle)
                if (act != 4) {
                    // chance of 35% to escape
                    if (Math.random() * 10 + 1 <= 3.5) {
                        printHeading("You ran away from the " + enemy.name + "!");
                        anythingToContinue();
                        break;
                    }
                    else {
                        printHeading("You didn't manage to escape.");
                        // calculate the damage the player takes
                        int dmgTook = enemy.attack();
                        System.out.println("In your hurry, you took " + dmgTook + " damage!");
                        anythingToContinue();
                        // check if player's still alive
                        if (player.hp <= 0) {
                            playerDied();
                        }
                    }
                }
                else {
                    printHeading("NOW THAT YOU HAVE COME THIS FAR, YOU CANNOT ESCAPE THE EVIL EMPEROR");
                    anythingToContinue();
                }
            }
        }
    }

    // printing the main menu
    public static void printMenu() {
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choose an action");
        printSeperator(20);
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");
    }

    // the Final Battle of the Game
    public static void finalBattle() {
        // creating the evil emperor and letting the player fight against him
        battle(new Enemy("THE EVIL EMPEROR", 200));
        // Ending
        if (player.hp > 0) {
            Story.printEnd(player);
        }
        else {
            playerDied();
        }
        clearConsole();
        char playAgain = IO.inputChar("Do you want to play again? (y/n) ");
        if (playAgain == 'y') {
            GameLogic.startGame();
        }
        else {
            isRunning = false;
        }
    }

    // method that gets called when the player is dead
    public static void playerDied() {
        clearConsole();
        printHeading("You died...");
        IO.printSlow("You earned " + player.xp + " XP on your journey. Try to earn more next time!");
        IO.printSlow("Thank you for playing my game. I hope you enjoyed it :)");
        clearConsole();
        char playAgain = IO.inputChar("Do you want to play again? (y/n) ");
        if (playAgain == 'y') {
            GameLogic.startGame();
        }
        else {
            isRunning = false;
        }
    }

    public static void gameLoop() {
        while (isRunning) {
            printMenu();
            int input = readInt("-> ", 3);
            if (input == 1) {
                continueJourney();
            }
            else if (input == 2) {
                characterInfo();
            }
            else {
                isRunning = false;
            }
        }
    }
}