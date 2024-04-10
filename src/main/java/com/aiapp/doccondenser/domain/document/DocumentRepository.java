package com.aiapp.doccondenser.domain.document;
import java.util.List;
import java.util.UUID;

public interface DocumentRepository {

        ResumeDocument find(UUID id);

        ResumeDocument getByKeywords(List<String> keywords);
        void store(ResumeDocument resumeDocument);


}
