package com.aiapp.doccondenser.application.interfaces;

import com.aiapp.doccondenser.application.models.ResumeDTO;

public interface AIService {
    public ResumeDTO generateResume(String content);
}
