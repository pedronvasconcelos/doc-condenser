package github.pedronvasconcelos.doccondenser.application.core;

public interface UseCase<Request, Response> {
    Response execute(Request request);
}



