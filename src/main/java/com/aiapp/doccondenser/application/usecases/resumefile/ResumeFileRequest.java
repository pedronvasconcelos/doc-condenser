package com.aiapp.doccondenser.application.usecases.resumefile;

import com.aiapp.doccondenser.domain.document.FileExtension;

import java.util.List;

public class ResumeFileRequest {
    public String content;
    public String fileName;
    public String documentTitle;
    public String author;
    public FileExtension Extension;
    public List<String> keyWords;
    //cstr
    public ResumeFileRequest(String file, String fileName, String author, FileExtension extension, List<String> keyWords, String documentTitle) {
        this.content = file;
        this.fileName = fileName;
        this.author = author;
        this.Extension = extension;
        this.keyWords = keyWords;
        this.documentTitle = documentTitle;
    }
}
