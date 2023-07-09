package com.springproject.QuestApp.responses;


import com.springproject.QuestApp.entities.Post;
import lombok.Data;

@Data
public class PostResponse {

    Long id;
    Long userId;
    String username;
    String title;
    String text;


    // AutoMapper kullanabilirdik fakat manuel olarak mapledik.
    public PostResponse(Post entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.username = entity.getUser().getUsername();
        this.text = entity.getText();
        this.title = entity.getTitle();
    }
}
