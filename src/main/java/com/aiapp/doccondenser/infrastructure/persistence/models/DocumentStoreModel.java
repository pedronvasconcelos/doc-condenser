package com.aiapp.doccondenser.infrastructure.persistence.models;

import com.aiapp.doccondenser.domain.document.FileExtension;
import com.aiapp.doccondenser.domain.document.ResumeDocument;
import org.springframework.ai.document.Document;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class DocumentStoreModel {

    public String resume;
    public Map<String, Object> metaData;

    public static DocumentStoreModel fromEntity(ResumeDocument resume){
        DocumentStoreModel model = new DocumentStoreModel();
         model.resume = resume.content;
        Map<String, Object> metadata = Map.of(
                "id", resume.getId(),
                "title", resume.getTitle(),
                "author", resume.getAuthor(),
                "link", resume.getLink(),
                "size", resume.getSize(),
                "creationDate", resume.getCreationDate(),
                "userKeywords", resume.getUserKeywords(),
                "fileName", resume.getFileName()
        );
        model.metaData = metadata;
        return model;
    }

    public static ResumeDocument toEntity(Document model) {
        Map<String, Object> metaData = model.getMetadata();
        String resumeContent = model.getContent();
        String fileName = (String) metaData.get("fileName");
        FileExtension extension = FileExtension.fromFileName(fileName);
        ResumeDocument resume = new ResumeDocument(
                (String) metaData.get("id"),
                (String) metaData.get("title"),
                resumeContent,
                fileName,
                extension ,
                (String) metaData.get("size"),
                (String) metaData.get("author"),
                (String) metaData.get("link"),
                (List<String>) metaData.get("userKeywords"),
                (Date) metaData.get("creationDate")
        );
        return resume;
    }
}
