package github.pedronvasconcelos.doccondenser.domain.document;

public enum FileExtension {
    TXT,
    DOC,
    DOCX;

    public static FileExtension fromFileName(String fileName){
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
        switch (extension){
            case "txt":
                return TXT;
            case "doc":
                return DOC;
            case "docx":
                return DOCX;
            default:
                throw new IllegalArgumentException("Invalid file extension");
        }
    }

}
