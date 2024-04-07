package github.pedronvasconcelos.doccondenser.domain.document;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ResumeDocument {

    public UUID id;
    public String title;
    public String content;
    public Optional<String> resume;
    public String fileName;
    public FileExtension extension;
    public String size;
    public Date creationDate;
    public Date lastQueryDate;
    public String author;
    public String link;
    public List<String> userKeywords;
    public List<String> aiKeywords;
    public boolean resumeGenerated;
    public Date lastResumeGenerationDate;

    //region getters
    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getResume() {
        return resume.orElse("");
    }

    public String getFileName() {
        return fileName;
    }

    public FileExtension getExtension() {
        return extension;
    }

    public String getSize() {
        return size;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getLastQueryDate() {
        return lastQueryDate;
    }

    public String getAuthor() {
        return author;
    }

    public String getLink() {
        return link;
    }

    public List<String> getUserKeywords() {
        return userKeywords;
    }

    public List<String> getAiKeywords() {
        return aiKeywords;
    }

    //endregion

    public void setResume(String resume, List<String> keywords) {
        this.resume = Optional.of(resume);
        this.lastResumeGenerationDate = new Date();
        this.resumeGenerated = true;
        this.aiKeywords = keywords;
    }

    public ResumeDocument(String title, String content, String fileName, FileExtension extension, String size, String author, String link, List<String> userKeywords) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.content = content;
        this.fileName = fileName;
        this.extension = extension;
        this.size = size;
        this.creationDate = new Date();
        this.lastQueryDate = new Date();
        this.author = author;
        this.link = link;
        this.userKeywords = userKeywords;
    }

    public ResumeDocument(String id, String title, String content, String fileName, FileExtension extension, String size, String author, String link, List<String> userKeywords, Date creationDate) {
        this.id = UUID.fromString(id);
        this.title = title;
        this.content = content;
        this.fileName = fileName;
        this.extension = extension;
        this.size = size;
        this.creationDate = new Date();
        this.lastQueryDate = new Date();
        this.author = author;
        this.link = link;
        this.userKeywords = userKeywords;
        this.creationDate = creationDate;
    }


}
