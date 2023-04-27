// class that prints out the story of the game
public class Story {
    public static void printIntro() {
        GameLogic.clearConsole();
        ASCII_ART.Henchman();
        GameLogic.printSeperator(30);
        IO.printSlow("STORY");
        GameLogic.printSeperator(30);
        IO.printSlow("You are the last man standing after your village got raided by the henchman of the evil emperor.", 50);
        IO.printSlow("Every single one of your friends, family and neighbours got murderered. You are standing in burning ruins of this once prosperous land.", 50);
        IO.printSlow("All you want is revenge, so you begin planning your jouney to defeat the evil emperor and free the country from the horrific man.", 50);
        GameLogic.anythingToContinue();
    }

    public static void printFirstActIntro() {
        GameLogic.clearConsole();
        ASCII_ART.Woods();
        GameLogic.printSeperator(30);
        IO.printSlow("ACT I - INTRO");
        GameLogic.printSeperator(30);
        IO.printSlow(ConsoleColors.GREEN + "As you begin your journey, you start travelling through the nearby woods to reach the everlasting mountains.", 50);
        IO.printSlow("The everlasting mountains are a very dangerous place.", 50);
        IO.printSlow("There are rumours that nobody that has gone there has ever come back alive.", 50);
        IO.printSlow("\nAfter a long day of walking through the woods, you finally reach the Everlasting Mountains.", 50);
        IO.printSlow("There is nothing on your mind besides the ambition of defeating the evil emperor which helps you move forward in your journey." + ConsoleColors.RESET, 50);
        GameLogic.anythingToContinue();
    }

    public static void printFirstActOutro() {
        GameLogic.clearConsole();
        ASCII_ART.Mountains();
        GameLogic.printSeperator(30);
        IO.printSlow("ACT I - OUTRO");
        GameLogic.printSeperator(30);
        IO.printSlow(ConsoleColors.GREEN + "You did it. You crossed the Everlasting Mountains and you are still alive.", 50);
        IO.printSlow("As you climb down the last hill, you are more than happy to feel hard ground beneath your foot.", 50);
        IO.printSlow("\nYou feel empowered and the experience you gained allows you to learn another trait!" + ConsoleColors.RESET, 50);
        GameLogic.anythingToContinue();
    }

    public static void printSecondActIntro() {
        GameLogic.clearConsole();
        ASCII_ART.Money();
        GameLogic.printSeperator(30);
        IO.printSlow("ACT II - INTRO");
        GameLogic.printSeperator(30);
        IO.printSlow(ConsoleColors.YELLOW + "You begin travelling across the landmines of this once well populated countryside.", 50);
        IO.printSlow("You collected some gold from the monsters you killed along the way.", 50);
        IO.printSlow("Luckily you know that every once in a while a travelling trader comes across these landlmines.", 50);
        IO.printSlow("You know exactly where the castle of the evil emperor is, but you have to cross these haunted landmines first..." + ConsoleColors.RESET, 50);
        GameLogic.anythingToContinue();
    }

    public static void printSecondActOutro() {
        GameLogic.clearConsole();
        ASCII_ART.Merchant();
        GameLogic.printSeperator(30);
        IO.printSlow("ACT II - OUTRO");
        GameLogic.printSeperator(30);
        IO.printSlow(ConsoleColors.YELLOW + "You managed to cross these haunted landlines and you're still alive!", 50);
        IO.printSlow("You are just a few hours away from your final destination, the castle of the Evil Emperor.", 50);
        IO.printSlow("You know that you probably can't rest there, so you make a last break to restore some health.", 50);
        IO.printSlow("\nAfter everything you have been through in your journey, you feel empowered to learn another trait." + ConsoleColors.RESET, 50);
        GameLogic.anythingToContinue();
    }

    public static void printThirdActIntro() {
        GameLogic.clearConsole();
        ASCII_ART.Castle();
        GameLogic.printSeperator(30);
        IO.printSlow("ACT III - INTRO");
        GameLogic.printSeperator(30);
        IO.printSlow(ConsoleColors.RED + "You see the huge black clastle in front of you.", 50);
        IO.printSlow("As you stand in front of the tall gates, you know there's no going back.", 50);
        IO.printSlow("You're disguised as a mercernary and enter the castle. You don't know what is going to happen.", 50);
        IO.printSlow("All you can do now is fight for your life and pray to come out as the winner..." + ConsoleColors.RESET, 50);
        GameLogic.anythingToContinue();
    }

    public static void printPrisonActIntro() {
        GameLogic.clearConsole();
        ASCII_ART.Hall();
        GameLogic.printSeperator(30);
        IO.printSlow("ACT Prison");
        GameLogic.printSeperator(30);
        IO.printSlow(ConsoleColors.BLACK + "Unfortunately, you get caught by one of the henchman of the Evil Emperor before reaching the throne room.", 50);
        IO.printSlow("You are handcuffed and are now being escorted to the cell, located somewhere downstairs", 50);
        IO.printSlow("As you walk downstairs, everything becomes dark, and a sudden flame blazes through all the torches, leading to your cell.", 50);
        IO.printSlow("To your right and to your left, you notice a buch of cells filled with prisoners, as you think about how your fate." + ConsoleColors.RESET, 50);
        GameLogic.anythingToContinue();
    }

    public static void printPrisonActOutro() {
        GameLogic.clearConsole();
        ASCII_ART.Prison();
        GameLogic.printSeperator(30);
        IO.printSlow("ACT Prison");
        GameLogic.printSeperator(30);
        IO.printSlow(ConsoleColors.BLACK + "You feel very defeated and don't know what to do.", 50);
        IO.printSlow("Suddenly, as you look around the room, you find yourself a note on the table.", 50);
        IO.printSlow("It turns out that the person you decided to help on the way, is the prison warden.", 50);
        IO.printSlow("He gives you a clue regarding the pin that opens the door of the prison: " + ConsoleColors.RESET, 50);
    }
    
    public static void Note() {
        System.out.println("\n(8951) TWO DIGITS ARE RIGHT, BUT BOTH ARE IN WRONG PLACE");
        System.out.println("(2169) TWO DIGITS ARE RIGHT, ONE IS IN RIGHT PLACE, 2ND IN WRONG PLACE");
        System.out.println("(3694) TWO DIGITS ARE RIGHT, ONE IS IN RIGHT PLACE, 2ND IN WRONG PLACE");
        System.out.println("(4721) TWO DIGITS ARE RIGHT, ONE IS IN RIGHT PLACE, 2ND IN WRONG PLACE");
        System.out.println("(1237) THREE DIGITS ARE RIGHT, BUT ALL ARE IN WRONG PLACE");
        // The code is 3719.
    }

    public static void printThirdActOutro() {
        GameLogic.clearConsole();
        ASCII_ART.Gate();
        GameLogic.printSeperator(30);
        IO.printSlow("ACT III - OUTRO");
        GameLogic.printSeperator(30);
        IO.printSlow(ConsoleColors.RED + "You came so far. You defeated all of the Evil Emperor's minions.", 50);
        IO.printSlow("As you stand in front of the door to his throne room, you know there's no going back.", 50);
        IO.printSlow("You recall your lost power and restore your health.", 50);
        IO.printSlow("You get the chance to learn a last trait before entering the throne room." + ConsoleColors.RESET, 50);
        GameLogic.anythingToContinue();
    }

    public static void printFourthActIntro() {
        GameLogic.clearConsole();
        ASCII_ART.EvilEmperor();
        GameLogic.printSeperator(30);
        IO.printSlow("ACT IV - INTRO");
        GameLogic.printSeperator(30);
        IO.printSlow("You enter the throne room of the Evil Emperor.", 50);
        IO.printSlow("You feel the darkness around you.", 50);
        IO.printSlow("He takes out the holy sword of darkness, the mightiest weapon known to man.", 50);
        IO.printSlow("You feel the power from your ancestors and late parents and siblings, as you step down to battle.", 50);
        GameLogic.anythingToContinue();
    }

    public static void printEnd(Player player) {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        IO.printSlow("Congratulations " + player.name + "! You defeated the Evil Emperor and saved the world!");
        GameLogic.printSeperator(30);
        IO.printSlow("This game was developed by Aadit Gupta");
        IO.printSlow("I hope you enjoyed it");
    }
}