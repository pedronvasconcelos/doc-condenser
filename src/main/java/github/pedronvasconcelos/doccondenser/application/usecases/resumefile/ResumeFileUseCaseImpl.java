package github.pedronvasconcelos.doccondenser.application.usecases.resumefile;

import github.pedronvasconcelos.doccondenser.application.interfaces.AIService;
import github.pedronvasconcelos.doccondenser.application.interfaces.FileReaderService;
import github.pedronvasconcelos.doccondenser.application.models.ResumeDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class ResumeFileUseCaseImpl implements ResumeFileUseCase{

    private final AIService aiService;
    private final FileReaderService fileReaderService;
    @Autowired
    public ResumeFileUseCaseImpl(AIService aiService, FileReaderService fileReaderService) {
        this.aiService = aiService;
        this.fileReaderService = fileReaderService;
    }


    @Override
    public ResumeFileResponse execute(ResumeFileRequest resumeFileRequest) {
        String content = fileReaderService.read(resumeFileRequest.file);
        ResumeDTO resumeDTO = aiService.generateResume(content);
        if (resumeDTO != null) {
            throw new RuntimeException("Error while generating resume");
        }
        return ResumeFileResponse.fromDto(resumeDTO, resumeFileRequest.fileName);
    }
}
