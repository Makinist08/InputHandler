package model.handler;

import java.util.Scanner;

import model.request.BoundingRequestFactory;
import model.request.Request;

public class InputHandler {
    
    private static InputHandler instance;
    private Scanner inputReader;

    private InputHandler(){
        inputReader = new Scanner(System.in);
    }

    public static InputHandler getInstance(){
        if(instance == null){
            instance = new InputHandler();
        }
        return instance;
    }

    public int requestBoundedInt(int lowerBound, int upperBound){
        Request<Integer> request = BoundingRequestFactory.makeIntegerBoundRequest(
            "I want a simple integer within 0 to 100", 
            "Give me an integer withing 0 to 100",
            lowerBound,
            upperBound);
        int input = request.makeRequest(inputReader);
        return input;
    }

    public char requestBoundedChar(int lowerBound, int upperBound){
        Request<Character> request = BoundingRequestFactory.makeCharacterBoundRequest(
            "I want a lowercase alphabetic letter", "Give me a lowercase alphabetic letter", 'a', 'z');
        char input = request.makeRequest(inputReader);
        return input;
    }
}