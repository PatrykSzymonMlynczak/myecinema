package com.wikingowie.myecinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "seance")
public class Seance extends BaseEntity {

    @Column(name = "language_version")
    String languageVersion;

    @Column(name = "day")
    Date day;

    @Column(name = "showing_time")
    Time showingTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hall_id")
    Hall hall;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    Movie movie;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "cinema_id")
    Cinema cinema;
}
