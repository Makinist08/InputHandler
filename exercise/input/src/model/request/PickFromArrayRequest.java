package model.request;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PickFromArrayRequest<T> extends Request<T>{
    private T[] array;

    /**
     * 1. Prompt User -> All Requests
     * 2. Read Input -> All Requests
     * 3. Try to sanitize prompt -> Turn String into an ArrayObject
     * 4. Try to Test prompt -> Test if ArrayObject is in our array
     * 5. On Error: Fail Test -> All Requests
     * 6. On Test Fail: ErrorPrompt and do step 2 -> All Requests
     * 7. Return ArrayObject
     */
    public PickFromArrayRequest(String prompt, String errorMessage, Function<String,T> sanitizer, T[] array){
        super(prompt, errorMessage, sanitizer, null);
        this.array = array;
    }

    @Override
    public boolean testRequirement(T t){
        boolean noMatches = true;
        int i = 0;

        while (noMatches && i < array.length) {
            noMatches = t.equals(array[i]);
            i++;
        }
        System.out.println("Input: " + t + "\n Array: " + (List.of(array)).toString() + "\n Tests: " + i + "\n foundMatch: " + noMatches);

        return noMatches;
    }

}
