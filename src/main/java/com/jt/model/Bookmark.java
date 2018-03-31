package com.jt.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Bookmark{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String note;

    @Column(nullable=false)
    private String url;


    @Column(nullable=false, updatable=false)
    private Date created;

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}