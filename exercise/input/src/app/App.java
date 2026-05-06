package app;

import model.handler.InputHandler;

public class App {
    public static void main(String[] args) throws Exception {
        InputHandler inputHandler = InputHandler.getInstance();

        System.out.println( "Let me add 2 to that " + (inputHandler.requestBoundedInt(0, 100) + 2));

        char c = inputHandler.requestBoundedChar('a', 'z');
        System.out.println(c + " is the " + ordinal(Character.getNumericValue(c) - 9) + " letter in the alphabet");

        String[] options = {"Apple","Orange","Banana"};
        System.out.println("Enjoy your " + inputHandler.requestPickStringFromArray(options));

    }


    // Source - https://stackoverflow.com/a/6810409
    // Posted by Bohemian, modified by community. See post 'Timeline' for change history
    // Retrieved 2026-05-03, License - CC BY-SA 4.0

    public static String ordinal(int i) {
        String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
        switch (i % 100) {
        case 11:
        case 12:
        case 13:
            return i + "th";
        default:
            return i + suffixes[i % 10];

        }
    }

}
