package model.handler;

import java.util.Scanner;

import model.request.Request;
import model.request.factories.ArrayRequestFactory;
import model.request.factories.BoundingRequestFactory;

public class InputHandler {
    
    private static InputHandler instance;
    private static String EXIT_CODE = "GET OUT OF HERE";
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
            "Give me an integer withing 0 to 100", EXIT_CODE,
            lowerBound,
            upperBound);
        int input = request.makeRequest(inputReader);
        return input;
    }

    public char requestBoundedChar(char first, char last){
        Request<Character> request = BoundingRequestFactory.makeCharacterBoundRequest(
            "I want a lowercase alphabetic letter", "Give me a lowercase alphabetic letter", EXIT_CODE, first, last);
        char input = request.makeRequest(inputReader);
        return input;
    }

    public String requestPickStringFromArray(String[] array){
        Request<String> request = ArrayRequestFactory.makePickStringFromArrayRequest(
            "Pick one of these options: \n" + InputHandler.StrArrayToString(array),
            "You didn't pick one of the options \n  do you need a refresher? \n " + InputHandler.StrArrayToString(array), EXIT_CODE,
            array);
        String choice = request.makeRequest(inputReader);
        return choice;
    }

    public static String StrArrayToString(String[] strArray){
        StringBuffer str = new StringBuffer("[");
        for (String string : strArray) {
            str.append(string + " ");
        }
        str.deleteCharAt(str.length()-1);
        str.append("]");
        return str.toString();
    }
}