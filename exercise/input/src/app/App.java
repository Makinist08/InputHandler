package app;

import model.handler.InputHandler;

public class App {
    public static void main(String[] args) throws Exception {
        InputHandler inputHandler = InputHandler.getInstance();

        while(true){
            System.out.println( "Let me add 2 to that " + (inputHandler.requestBoundedInt(0, 100) + 2));

            char c = inputHandler.requestBoundedChar('a', 'z');
            System.out.println(c + " is the " + (Character.getNumericValue(c) - 9) + " letter in the alphabet");
        }
    }
}
