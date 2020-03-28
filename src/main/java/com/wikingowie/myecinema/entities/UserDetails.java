package com.wikingowie.myecinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_details")
public class UserDetails extends BaseEntity {

    @Column(name = "first_name")
    String firstName;

    @Column(name="last_name")
    String lastName;

    @Column(name="city")
    String city;

    @Column(name="adress")
    String adress;

    @Column(name="postcode")
    String postcode;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

}
