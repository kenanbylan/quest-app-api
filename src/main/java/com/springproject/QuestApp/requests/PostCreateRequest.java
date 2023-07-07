package com.springproject.QuestApp.requests;

import lombok.Data;



//NOTE: Kullanıcı post oluşturuken user'dan alınacak bilgiler.

@Data
public class PostCreateRequest {

    Long id;
    String title;
    String text;
    Long userId;

}
