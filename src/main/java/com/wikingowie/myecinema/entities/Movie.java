package com.wikingowie.myecinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "movie")
public class Movie extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private String type;

    @Column(name = "production")
    private String production;

    @Column(name = "release_year")
    private Date releaseYear;

    @Column(name = "director")
    private String director;

    @Column(name = "duration")
    private int duration;

    @Column(name = "for_how_many_years")
    private int forHowManyYears;

}
