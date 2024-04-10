package com.aiapp.doccondenser.application.usecases.resumefile;

import com.aiapp.doccondenser.application.interfaces.AIService;
import com.aiapp.doccondenser.application.interfaces.FileReaderService;
import com.aiapp.doccondenser.application.interfaces.FileStorageService;
import com.aiapp.doccondenser.application.models.ResumeDTO;
import com.aiapp.doccondenser.domain.document.ResumeDocument;
import com.aiapp.doccondenser.domain.document.DocumentBuilder;
import com.aiapp.doccondenser.domain.document.DocumentRepository;
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
    public ResumeFileResponse execute(ResumeFileRequest request) {


         List<String> keywords = new ArrayList<String>();

        ResumeDocument resumeDocument = new DocumentBuilder()
                .withContent(request.content)
                .withAuthor(request.author)
                .withExtension(request.Extension)
                .withFileName(request.fileName)
                .withLink("mock")
                .withKeywords(request.keyWords)
                .withSize("mock")
                .withTitle(request.documentTitle)
                .build();
        documentRepository.store(resumeDocument);
        ResumeDTO resumeDTO = aiService.generateResume(request.content);
        if (resumeDTO != null) {
            throw new RuntimeException("Error while generating resume");
        }
        resumeDocument.setResume(resumeDTO.resume, keywords);
        return ResumeFileResponse.fromDto(resumeDTO, request.fileName);
    }
}
