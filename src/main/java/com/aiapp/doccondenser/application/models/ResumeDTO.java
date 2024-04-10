package com.aiapp.doccondenser.application.models;

import java.util.List;

public class ResumeDTO {
    public String resume;
    public List<String>  AIKeywords;
    //cstr
    public ResumeDTO(String resume, List<String> AIKeywords) {
        this.resume = resume;
        this.AIKeywords = AIKeywords;
    }
}
