package model.request;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;


public class Request<T> {
    private String prompt;
    private String errorMessage;
    private Predicate<T> requirement;
    private Function<String, T> sanitizer;

    /**
     * 1. Prompt User -> All Requests
     * 2. Read Input -> All Requests
     * 3. Try to sanitize prompt -> Specific to Request Type
     * 4. Try to Test prompt -> Specific to Request Requirements
     * 5. On Error: Fail Test -> All Requests
     * 6. On Test Fail: ErrorPrompt and do step 2 -> All Requests
     * 7. Return Input
     */
    public Request(String prompt, String errorMessage, Function<String, T> sanitizer, Predicate<T> requirement){
        this.prompt = prompt;
        this.errorMessage = errorMessage;
        this.requirement = requirement;
        this.sanitizer = sanitizer;
    }

    /**
     * 
     * @param scanner
     * @return
     */
    public T makeRequest(Scanner scanner){
        boolean notSuccessfulTest = true;
        String rawInput;
        T input = null;

        System.out.println(prompt);

        do {
            try {
                rawInput = scanner.nextLine();
                input = this.sanitize(rawInput);
                notSuccessfulTest = !this.testRequirement(input);
            } catch (Exception e) {
                //System.out.println(errorMessage);
            }

            if(notSuccessfulTest){
                System.out.println(errorMessage);
            }
        } while (notSuccessfulTest);

        return input;
    }

    public T sanitize(String rawInput){
        return this.sanitizer.apply(rawInput);
    }

    public boolean testRequirement(T input){
        return this.requirement.test(input);
    }
}