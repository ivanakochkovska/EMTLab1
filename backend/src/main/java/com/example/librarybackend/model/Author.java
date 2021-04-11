package com.example.librarybackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Author extends BaseEntity {
    private String name;
    private String surname;
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
    @ManyToMany
    List<Book> bookList;
}
