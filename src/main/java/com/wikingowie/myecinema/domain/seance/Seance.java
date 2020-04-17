package com.wikingowie.myecinema.domain.seance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wikingowie.myecinema.domain.booking.Booking;
import com.wikingowie.myecinema.domain.cinema.Cinema;
import com.wikingowie.myecinema.domain.hall.Hall;
import com.wikingowie.myecinema.domain.movie.Movie;
import com.wikingowie.myecinema.infrastructure.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "seance")
public class Seance extends BaseEntity {

    @Column(name = "language_version")
    private String languageVersion;

    @Column(name = "day")
    private LocalDate day;

    @Column(name = "showing_time")
    private Time showingTime;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "seance")
    private Booking booking;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall hall;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cinema_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Cinema cinema;
}
