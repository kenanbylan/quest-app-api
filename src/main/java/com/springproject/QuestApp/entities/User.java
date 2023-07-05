package com.springproject.QuestApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;   //modelin getter ve setterlarını otomatik olarak tanımlamaya fayda sağlar.


@Entity
@Table(name = "User")
@Data
public class User {
    @Id
    Long id;

    String username;
    String password;
}