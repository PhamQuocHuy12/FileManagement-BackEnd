package com.example.filemanagement.Repository;

import com.example.filemanagement.Model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;

@Repository
public interface DocumentRepository extends PagingAndSortingRepository<Document, Integer> {
    int countByName(String name);
    Document findById(int id);
    Page<Document> findAllByStatusOrderByCreatedDateTimeDesc(String status, Pageable pageable);
}
