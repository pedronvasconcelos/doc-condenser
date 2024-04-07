package github.pedronvasconcelos.doccondenser.application.interfaces;

import github.pedronvasconcelos.doccondenser.application.models.ResumeDTO;

public interface AIService {
    public ResumeDTO generateResume(String content);
}
