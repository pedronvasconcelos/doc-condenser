package github.pedronvasconcelos.doccondenser.application.usecases.resumefile;

import github.pedronvasconcelos.doccondenser.application.models.ResumeDTO;

import java.util.List;

public class ResumeFileResponse {
    public String resume;
    public List<String> AIKeywords;
    public String link;
    //cstr
    private ResumeFileResponse(String resume, List<String> AIKeywords, String link) {
        this.resume = resume;
        this.AIKeywords = AIKeywords;
        this.link = link;
    }
    public static ResumeFileResponse fromDto(ResumeDTO dto, String link){
        return new ResumeFileResponse(dto.resume, dto.AIKeywords, link);
    }

}
