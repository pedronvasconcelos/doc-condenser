package github.pedronvasconcelos.doccondenser.application.usecases.resumefile;

import github.pedronvasconcelos.doccondenser.domain.document.FileExtension;

public class ResumeFileRequest {
    public byte[] file;
    public String fileName;
    public String author;
    public FileExtension Extension;
    //cstr
    public ResumeFileRequest(byte[] file, String fileName, String author, FileExtension extension) {
        this.file = file;
        this.fileName = fileName;
        this.author = author;
        this.Extension = extension;
    }
}
