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
    String title;

    @Column(name = "type")
    String type;

    @Column(name = "production")
    String production;

    @Column(name = "release_year")
    Date releaseYear;

    @Column(name = "director")
    String director;

    @Column(name = "duration")
    int duration;

    @Column(name = "for_how_many_years")
    int forHowManyYears;

}
