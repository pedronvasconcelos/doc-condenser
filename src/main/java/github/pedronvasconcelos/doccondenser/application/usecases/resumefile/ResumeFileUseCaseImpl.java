package github.pedronvasconcelos.doccondenser.application.usecases.resumefile;

import github.pedronvasconcelos.doccondenser.application.interfaces.AIService;
import github.pedronvasconcelos.doccondenser.application.interfaces.FileReaderService;
import github.pedronvasconcelos.doccondenser.application.interfaces.FileStorageService;
import github.pedronvasconcelos.doccondenser.application.models.ResumeDTO;
import github.pedronvasconcelos.doccondenser.domain.document.Document;
import github.pedronvasconcelos.doccondenser.domain.document.DocumentBuilder;
import github.pedronvasconcelos.doccondenser.domain.document.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ResumeFileUseCaseImpl implements ResumeFileUseCase{

    private final AIService aiService;
    private final FileReaderService fileReaderService;
    private final DocumentRepository documentRepository;
    private final FileStorageService fileStorageService;
    @Autowired
    public ResumeFileUseCaseImpl(AIService aiService,
                                 FileReaderService fileReaderService,
                                 DocumentRepository documentRepository,
                                 FileStorageService fileStorageService) {
        this.aiService = aiService;
        this.fileReaderService = fileReaderService;
        this.documentRepository = documentRepository;
        this.fileStorageService = fileStorageService;
    }


    @Override
    public ResumeFileResponse execute(ResumeFileRequest resumeFileRequest) {

        String content = fileReaderService.read(resumeFileRequest.file);
        String link = fileStorageService.store(resumeFileRequest.file, resumeFileRequest.fileName);
        String size = content.length() + " bytes";
        List<String> keywords = new ArrayList<String>();

        Document document = new DocumentBuilder()
                .withContent(content)
                .withAuthor(resumeFileRequest.author)
                .withExtension(resumeFileRequest.Extension)
                .withFileName(resumeFileRequest.fileName)
                .withLink(link)
                .withKeywords(resumeFileRequest.keyWords)
                .withSize(size)
                .withTitle(resumeFileRequest.documentTitle)
                .build();
        documentRepository.store(document);
        ResumeDTO resumeDTO = aiService.generateResume(content);
        if (resumeDTO != null) {
            throw new RuntimeException("Error while generating resume");
        }
        document.setResume(resumeDTO.resume, keywords);
        return ResumeFileResponse.fromDto(resumeDTO, resumeFileRequest.fileName);
    }
}
