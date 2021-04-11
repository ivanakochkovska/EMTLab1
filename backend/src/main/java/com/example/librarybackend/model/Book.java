package com.example.librarybackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Book extends BaseEntity {
    private String name;
    private CATEGORY category;
    //Author
    @ManyToMany
    private List<Author> authorList;
    private int availableCopies;
}
