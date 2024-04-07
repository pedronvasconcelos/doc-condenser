package github.pedronvasconcelos.doccondenser.infrastructure.persistence;
import github.pedronvasconcelos.doccondenser.domain.document.DocumentRepository;
import github.pedronvasconcelos.doccondenser.domain.document.ResumeDocument;
import github.pedronvasconcelos.doccondenser.infrastructure.persistence.models.DocumentStoreModel;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.filter.Filter;
import org.springframework.ai.vectorstore.filter.FilterExpressionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DocumentRepositoryImpl implements DocumentRepository {
    @Autowired
    VectorStore vectorStore;

    @Override
    public ResumeDocument find(UUID id) {
        FilterExpressionBuilder b = new FilterExpressionBuilder();
        Filter.Expression filterExpression = b.eq("id", id).build();

       List<Document> documentListList = vectorStore.similaritySearch(SearchRequest.defaults()
               .withFilterExpression(filterExpression));
        if(documentListList.size() == 0){
            return null;
        }
        return DocumentStoreModel.toEntity(documentListList.get(0));
    }

    @Override
    public ResumeDocument getByKeywords(List<String> keywords) {
        FilterExpressionBuilder b = new FilterExpressionBuilder();
        Filter.Expression filterExpression = b.in("userKeywords", keywords).build();

        List<Document> documentList = vectorStore.similaritySearch(SearchRequest.defaults()
                .withFilterExpression(filterExpression));

        if (documentList.isEmpty()) {
            return null;
        }

        return DocumentStoreModel.toEntity(documentList.get(0));
    }

    @Override
    public void store(ResumeDocument resumeDocument) {
        DocumentStoreModel doc = DocumentStoreModel.fromEntity(resumeDocument);
        Document document =  new Document(doc.resume, doc.metaData );
        List<Document> docs = new ArrayList<Document>(1);
        docs.add(document);
        vectorStore.add(docs);
    }
}
