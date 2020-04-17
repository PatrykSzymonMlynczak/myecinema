package com.wikingowie.myecinema.domain.booking;

import com.wikingowie.myecinema.domain.bar.Bar;
import com.wikingowie.myecinema.domain.user.UserAccount;
import com.wikingowie.myecinema.domain.seance.Seance;
import com.wikingowie.myecinema.infrastructure.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "booking")
public class Booking extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seance_id", nullable = false)
    private Seance seance;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id", nullable = false)
    private UserAccount userAccount;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bar_order_id", nullable = false)
    private Bar barOrder;

}
