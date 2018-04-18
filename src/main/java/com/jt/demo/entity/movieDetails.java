package com.jt.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document  // cannot use @entity as that is for JPA
@JsonIgnoreProperties(ignoreUnknown=true) // Any properties not bound in this type should be ignored
public class movieDetails { // Class should be same as table name
    @Id
    public String id;

    public String title;
//
//    public String note;
//
//    public Date created;

    public void bookMark() {}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getNote() {
//        return note;
//    }
//
//    public void setNote(String note) {
//        this.note = note;
//    }
//
//    public Date getCreated() {
//        return created;
//    }
//
//    public void setCreated(Date created) {
//        this.created = created;
//    }
}
