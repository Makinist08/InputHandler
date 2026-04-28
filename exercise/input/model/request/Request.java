package exercise.input.model.request;

public interface Request<T> {
    public T call();
}