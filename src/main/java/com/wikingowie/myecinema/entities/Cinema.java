package com.wikingowie.myecinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cinema")
public class Cinema extends BaseEntity {

    @Column (name="cinema_type")
    String cinemaType;

    @Column (name="city")
    String city;

    @Column (name="postcode")
    String postcode;

    @Column (name="adress")
    String adress;
}
