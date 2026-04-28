package exercise.input.model.handler;

import java.util.Scanner;

import exercise.input.model.request.BoundedRequest;
import exercise.input.model.request.Request;

public class InputHandler {
    
    private static InputHandler instance;
    private Scanner inputReader;

    private InputHandler(){
        inputReader = new Scanner("in");
    }

    public InputHandler getInstance(){
        if(instance == null){
            instance = new InputHandler();
        }
        return instance;
    }

    public int requestInteger(){
        Request<Integer> request = new BoundedRequest<Integer>("I want a simple integer within 0 to 100", 0, 100, inputReader,"Give me a real integer");
        int input = request.call();
        return input;
    }

    public char requestChar(){
        Request<Character> request = new BoundedRequest<Character>("I want a lowercase alphabetic letter", 'a', 'z', inputReader, "Give me a lowercase alphabetic letter");
        char input = request.call();
        return input;
    }

    
}