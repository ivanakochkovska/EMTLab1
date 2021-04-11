package com.example.librarybackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Country extends BaseEntity {
    private String name;
    private String continent;
    @OneToMany(fetch = FetchType.LAZY)
    List<Author> authorList;

}
