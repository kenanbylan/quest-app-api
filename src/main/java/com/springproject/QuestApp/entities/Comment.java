package com.springproject.QuestApp.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "comment")
@Data
public class Comment {

    @Id
    Long id;
    Long postId;
    Long userId;

    @Lob
    @Column(columnDefinition = "text") //Stringi text olarak tanıması için yapıldı yoksa VarChar olurdu.
    String text;



}
