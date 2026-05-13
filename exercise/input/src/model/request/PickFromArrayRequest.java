package model.request;

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
    public PickFromArrayRequest(String prompt, String errorMessage, String exitCode, Function<String,T> sanitizer, T[] array){
        super(prompt, errorMessage, exitCode, sanitizer);
        this.array = array;
    }

    @Override
    public boolean testRequirement(T t){
        boolean isMatch = false;
        int i = 0;

        while (!isMatch && i < array.length) {
            isMatch = false;
            isMatch = t.equals(array[i]);
            i++;
        }

        System.out.println("Input: " + t + "\n Array: " + (List.of(array)).toString() + "\n Tests: " + (i+1) + "\n foundMatch: " + isMatch);

        return isMatch;
    }

}
