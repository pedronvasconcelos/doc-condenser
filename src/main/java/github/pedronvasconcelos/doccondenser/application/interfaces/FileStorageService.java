package github.pedronvasconcelos.doccondenser.application.interfaces;

public interface FileStorageService {
    public String store(byte[] fileBytes, String fileName);
}
