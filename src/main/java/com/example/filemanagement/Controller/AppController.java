package com.example.filemanagement.Controller;

import com.example.filemanagement.Model.Document;
import com.example.filemanagement.Model.Setting;
import com.example.filemanagement.Services.AppServices;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AppController {
    private final AppServices appServices;

    public AppController(AppServices appServices) {
        this.appServices = appServices;
    }

    @GetMapping(path = "/")
    public ResponseEntity<?> getAllFile(Pageable pageable) {
        try {
            return new ResponseEntity<>(appServices.getAllFile(pageable), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/upload")
    public ResponseEntity<?> uploadFile(@RequestBody Document document) {
        try {
            return new ResponseEntity<>(appServices.uploadFile(document), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable  int id) {
        try {
            return new ResponseEntity<>(appServices.deleteFile(id), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/download/{id}")
    public ResponseEntity<?> downloadFile(@PathVariable int id) {
        try {
            return new ResponseEntity<>(appServices.downloadFile(id), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/setting")
    public ResponseEntity<?> changeSetting(@RequestBody Setting setting) {
        try {
            return new ResponseEntity<>(appServices.changeSetting(setting), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
