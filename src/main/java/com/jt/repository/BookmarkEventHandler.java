package com.jt.repository;

import com.jt.model.Bookmark;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.util.Date;

@RepositoryEventHandler(Bookmark.class)
public class BookmarkEventHandler {
    @HandleBeforeCreate
    public void handleBookmarkCreate(Bookmark bookmark){
        bookmark.setCreated(new Date());
    }
}
