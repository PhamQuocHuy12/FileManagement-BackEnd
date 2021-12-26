package com.example.filemanagement.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private int size;

    @Column( nullable = false)
    private String mime;

    @Column(name = "number_of_download", columnDefinition = "integer default 0")
    private int numberOfDownLoad;

    private int version;

    @Column(length = 20, nullable = false)
    private String status;

    @Column(name = "created_date_time")
    private Date createdDateTime;

    public Document( String name, String path, int size, String mime, int numberOfDownLoad, int version, String status, Date createdDateTime) {
        this.name = name;
        this.path = path;
        this.size = size;
        this.mime = mime;
        this.numberOfDownLoad = numberOfDownLoad;
        this.version = version;
        this.status = status;
        this.createdDateTime = createdDateTime;
    }

    public Document(String name, String path, int size, String mime, String status) {
        this.name = name;
        this.path = path;
        this.size = size;
        this.mime = mime;
        this.status = status;
    }

    public Document() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public int getNumberOfDownLoad() {
        return numberOfDownLoad;
    }

    public void setNumberOfDownLoad(int numberOfDownLoad) {
        this.numberOfDownLoad = numberOfDownLoad;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

}
