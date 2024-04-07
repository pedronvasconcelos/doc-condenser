package github.pedronvasconcelos.doccondenser.application.usecases.resumefile;

import github.pedronvasconcelos.doccondenser.domain.document.FileExtension;

import java.util.List;

public class ResumeFileRequest {
    public byte[] file;
    public String fileName;
    public String documentTitle;
    public String author;
    public FileExtension Extension;
    public List<String> keyWords;
    //cstr
    public ResumeFileRequest(byte[] file, String fileName, String author, FileExtension extension, List<String> keyWords, String documentTitle) {
        this.file = file;
        this.fileName = fileName;
        this.author = author;
        this.Extension = extension;
        this.keyWords = keyWords;
        this.documentTitle = documentTitle;
    }
}
