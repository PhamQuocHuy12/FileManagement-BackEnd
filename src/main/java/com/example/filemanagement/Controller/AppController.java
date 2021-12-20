package com.example.filemanagement.Controller;

import com.example.filemanagement.Model.Document;
import com.example.filemanagement.Services.AppServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AppController {
    private final AppServices appServices;

    public AppController(AppServices appServices) {
        this.appServices = appServices;
    }

    @GetMapping(path = "/")
    public ResponseEntity<?> getAllFile() {
        try {
            return new ResponseEntity<>(appServices.getAllFile(), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/upload")
    public ResponseEntity<?> uploadFile(@RequestBody Document document) {
        try {
            appServices.uploadFile(document);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/delete")
    public ResponseEntity<?> deleteFile(@RequestBody Document document) {
        try {
            appServices.deleteFile(document);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
