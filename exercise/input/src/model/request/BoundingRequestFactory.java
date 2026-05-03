package model.request;

import java.util.function.Function;
import java.util.function.Predicate;

public class BoundingRequestFactory {

    public static Request<Integer> makeIntegerBoundRequest(String prompt, String message, int lowerBound, int upperBound){

        Function<String, Integer> sanitizer = (rawInput) -> {
            return Integer.valueOf(rawInput);
        };

        Predicate<Integer> requirement = (input) -> {
            return (input.intValue() >= lowerBound && input.intValue() <= upperBound);
        };
        
        return new Request<Integer>(prompt, message, sanitizer, requirement);
    }

    public static Request<Character> makeCharacterBoundRequest(String prompt, String message, char lowerBound, char upperBound){

        Function<String, Character> sanitizer = (rawInput) -> {

            return rawInput.length() == 1 ? rawInput.toCharArray()[0] : null;
        };

        Predicate<Character> requirement = (input) -> {
            return (input.compareTo(Character.valueOf(lowerBound)) >= 0 && input.compareTo(Character.valueOf(upperBound)) <= 0);
        };
        
        return new Request<Character>(prompt, message, sanitizer, requirement);
    }
}
