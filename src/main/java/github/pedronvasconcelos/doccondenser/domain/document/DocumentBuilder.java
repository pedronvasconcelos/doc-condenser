package github.pedronvasconcelos.doccondenser.domain.document;

import java.util.Date;
import java.util.List;

public class DocumentBuilder {

    private String title;
    private String content;
    private String fileName;
    private FileExtension extension;
    private String size;
    private Date creationDate;
    private Date lastQueryDate;
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

    public DocumentBuilder withFileName(String fileName) {
        this.fileName = fileName;
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        this.extension = FileExtension.valueOf(extension.toUpperCase());
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

    public Document build() {
        return new Document(title, content, fileName, extension, size, author, link, keywords);
    }
}
