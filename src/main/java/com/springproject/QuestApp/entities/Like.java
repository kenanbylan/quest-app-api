package com.springproject.QuestApp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "p_like")
@Data
public class Like {

    @Id
    Long id;


    @ManyToOne(fetch = FetchType.LAZY) //user'ı getirmek için acele etme.
    @JoinColumn(name = "post_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) //user silindiğinde tüm ona ait tüm postlarda silinir.
    @JsonIgnore
    Post post;

    //MARK: Birden fazla postu olabilir tek bir user'ın "Many to one"
    @ManyToOne(fetch = FetchType.LAZY) //user'ı getirmek için acele etme.
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) //user silindiğinde tüm ona ait tüm postlarda silinir.
    @JsonIgnore
    User user;
    
}

