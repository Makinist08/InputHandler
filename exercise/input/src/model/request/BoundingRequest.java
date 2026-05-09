package model.request;

import java.util.function.Function;

public class BoundingRequest<T extends Comparable<T>> extends Request<T> {
    private T lowerBound;
    private T upperBound;
    
    public BoundingRequest(String prompt, String errorMessage, String exitCode, Function<String,T> sanitizer, T lowerBound, T upperBound){
        super(prompt, errorMessage, exitCode, sanitizer, null);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public boolean testRequirement(T input){
        return input.compareTo(lowerBound) >= 0 && input.compareTo(upperBound) <= 0;
    }
}
