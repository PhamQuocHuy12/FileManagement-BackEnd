package com.example.filemanagement.Services;

import com.example.filemanagement.Model.Document;
import com.example.filemanagement.Model.Setting;
import com.example.filemanagement.Repository.DocumentRepository;
import com.example.filemanagement.Repository.SettingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AppServices {
    private final DocumentRepository documentRepository;
    private final SettingRepository settingRepository;

    public AppServices(DocumentRepository documentRepository, SettingRepository settingRepository) {
        this.documentRepository = documentRepository;
        this.settingRepository = settingRepository;
    }

    public Page<Document> getAllFile (Pageable pageable) {
        return  documentRepository.findAllByStatusOrderByCreatedDateTimeDesc("available", pageable);
    }

    public Document uploadFile(Document document) {
        document.setCreatedDateTime(new Date());
        document.setVersion(documentRepository.countByName(document.getName())+1);
        documentRepository.save(document);
        return document;
    }
    public Document deleteFile(int id) {
        Document document = documentRepository.findById(id);
        document.setStatus("unavailable");
        documentRepository.save(document);
        return document;
    }

    public Document downloadFile(int id) {
        Document document = documentRepository.findById(id);
        int i = document.getNumberOfDownLoad() + 1;
        document.setNumberOfDownLoad(i);
        documentRepository.save(document);
        return document;
    }

    public Setting changeSetting(Setting setting) {
        setting.setLastUpdateTime(new Date());
        settingRepository.save(setting);
        return setting;
    }
}