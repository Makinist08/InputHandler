package exercise.input.model.request;

import java.util.Scanner;


public class BoundedRequest<T extends Comparable<T>> implements Request<T>{
    private String prompt;
    private T lowerLimit;
    private T upperLimit;
    private Scanner scanner;
    private String errorResponse;

    /**
     * Bound request
     * @param prompt
     * @param lowerLimit
     * @param upperLimit
     * @param scanner
     * @param errorResponse
     */
    public BoundedRequest(String prompt, T lowerLimit, T upperLimit, Scanner scanner, String errorResponse){
        this.prompt = prompt;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.scanner = scanner;
        this.errorResponse = errorResponse;
    }

    public T call(){
        T input;
        boolean notSuccessful = true;
        System.out.println(prompt);

        do {
            String rawInput = scanner.nextLine();
            try {

                if(input.compareTo(lowerLimit) >= 0 && input.compareTo(upperLimit) <= 0){
                    notSuccessful = false;
                }
            } catch (Exception e) {
                System.out.println(errorResponse);
            }
        } while (notSuccessful);

        return input;
    }

}
