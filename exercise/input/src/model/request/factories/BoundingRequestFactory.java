package model.request.factories;

import java.util.function.Function;

import model.request.BoundingRequest;
import model.request.Request;

public class BoundingRequestFactory {

    public static Request<Integer> makeIntegerBoundRequest(String prompt, String message, int lowerBound, int upperBound){

        Function<String, Integer> sanitizer = (rawInput) -> {
            return Integer.valueOf(rawInput);
        };

        
        return new BoundingRequest<Integer>(prompt, message, sanitizer, lowerBound, upperBound);
    }

    public static Request<Character> makeCharacterBoundRequest(String prompt, String message, char lowerBound, char upperBound){

        Function<String, Character> sanitizer = (rawInput) -> {

            return rawInput.length() == 1 ? rawInput.toCharArray()[0] : null;
        };
        
        return new BoundingRequest<Character>(prompt, message, sanitizer, lowerBound, upperBound);
    }
}
