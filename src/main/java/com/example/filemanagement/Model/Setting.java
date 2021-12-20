package com.example.filemanagement.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "setting")
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="max_size", nullable = false)
    private int maxSize;
    @Column(name="item_per_page", nullable = false)
    private int itemPerPage;
    @Column(name="mime_type_allow",length = 20, nullable = false)
    private String mimeTypeAllowed;
    @Column(name="last_update_time", nullable = false)
    private Date lastUpdateTime;

    public Setting(int id, int maxSize, int itemPerPage, String mimeTypeAllowed, Date lastUpdateTime) {
        this.id = id;
        this.maxSize = maxSize;
        this.itemPerPage = itemPerPage;
        this.mimeTypeAllowed = mimeTypeAllowed;
        this.lastUpdateTime = lastUpdateTime;
    }

    public Setting() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getItemPerPage() {
        return itemPerPage;
    }

    public void setItemPerPage(int itemPerPage) {
        this.itemPerPage = itemPerPage;
    }

    public String getMimeTypeAllowed() {
        return mimeTypeAllowed;
    }

    public void setMimeTypeAllowed(String mimeTypeAllowed) {
        this.mimeTypeAllowed = mimeTypeAllowed;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
