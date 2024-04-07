package github.pedronvasconcelos.doccondenser.domain.document;
import java.util.List;
import java.util.UUID;

public interface DocumentRepository {

        Document find(UUID id);

        Document getByKeywords(List<String> keywords);
        void store(Document document);


}
