package com.example.filemanagement.Services;

import com.example.filemanagement.Model.Document;
import com.example.filemanagement.Repository.DocumentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class AppServices {
    private final DocumentRepository documentRepository;

    public AppServices(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> getAllFile () {
        return  documentRepository.findAll();
    }

    public Document uploadFile(Document document) {
        return documentRepository.save(document);
    }
    public Document deleteFile(Document document) {
        document.setStatus("unavailable");
        return documentRepository.save(document);
    }
}





//        List<Document> demoData =  new ArrayList<>();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        Date date = new Date();
//        Document doc1 = new Document(1, "hehe", "C://Document", 5, "jpg", 0,1, "available", date );
//        Document doc2 = new Document(2, "hehe", "C://Document", 5, "jpg", 0,2, "available", date );
//        Document doc3 = new Document(3, "this is not hehe", "C://Document//heehee", 4, "jpg", 5,1, "available", date );
//        documentRepository.save(doc1);
//        documentRepository.save(doc2);
//        documentRepository.save(doc3);