package com.jt.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown=true) // Any properties not bound in this type should be ignored
public class BookMark {
    @Id
    public Integer id;

    public String url;

    public String note;

    public Date created;

    public void bookMark() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
