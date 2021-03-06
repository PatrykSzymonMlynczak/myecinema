package com.wikingowie.myecinema.domain.seat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wikingowie.myecinema.domain.hall.Hall;
import com.wikingowie.myecinema.domain.seance.Seance;
import com.wikingowie.myecinema.domain.ticket.Ticket;
import com.wikingowie.myecinema.infrastructure.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "seat")
public class Seat extends BaseEntity {

    @Column(name="place")
    private int place;

    @Column(name="row")
    private int row;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "halls_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Hall hall;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "seat")
    private Ticket ticket;

}
