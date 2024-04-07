package github.pedronvasconcelos.doccondenser.domain.document;

import java.util.List;

public class DocumentBuilder {

    private String title;
    private String content;
    private String fileName;
    private FileExtension extension;
    private String size;
    private String author;
    private String link;
    private List<String> keywords;


    public DocumentBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public DocumentBuilder withContent(String content) {
        this.content = content;
        return this;
    }
    public DocumentBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public DocumentBuilder withFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
    public DocumentBuilder withExtension(FileExtension extension) {
        this.extension = extension;
        return this;
    }


    public DocumentBuilder withSize(String size) {
        this.size = size;
        return this;
    }

    public DocumentBuilder withLink(String link) {
        this.link = link;
        return this;
    }

    public DocumentBuilder withKeywords(List<String> keywords) {
        this.keywords = keywords;
        return this;
    }

    public ResumeDocument build() {
        return new ResumeDocument(title, content, fileName, extension, size, author, link, keywords);
    }
}
