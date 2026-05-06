package model.request.factories;

import java.util.function.Function;

import model.request.PickFromArrayRequest;
import model.request.Request;

public class ArrayRequestFactory {
    public static Request<String> makePickStringFromArrayRequest(String prompt, String errorMessage, String[] array){

        Function<String, String> sanitizer = (rawInput) -> {
            return rawInput;
        };
        
        return new PickFromArrayRequest<String>(prompt, errorMessage, sanitizer, array);
    }
}
