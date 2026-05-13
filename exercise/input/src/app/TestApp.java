package app;
import model.handler.InputHandler;

public class TestApp {
    public static void main(String[] args) throws Exception {
        InputHandler inputHandler = InputHandler.getInstance();

        Integer i = inputHandler.requestBoundedInt(0, 100);
        if (i != null) {
            System.out.println( "Let me add 2 to that " + (i.intValue() + 2));
        } else {
            System.out.println("Skipping int test");
        }

        Character c = inputHandler.requestBoundedChar('a', 'z');
        if(c != null){
            System.out.println(c + " is the " + ordinal(Character.getNumericValue(c) - 9) + " letter in the alphabet");
        } else {
            System.out.println("Skipping char test");
        }

        String[] options = {"Apple","Orange","Banana"};
        String choice = inputHandler.requestPickStringFromArray(options);
        if(choice != null){
            System.out.println("Enjoy your " + choice);
        } else {
            System.out.println("Skipping str test");
        }

        System.out.println("Done");
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
