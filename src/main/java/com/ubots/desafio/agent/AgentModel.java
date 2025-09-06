package com.ubots.desafio.agent;

import com.ubots.desafio.common.TeamEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@SuperBuilder
@Table(name = "agent")
public class AgentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "team")
    private TeamEnum team;

    @Column(name = "active_load")
    private Integer activeLoad ;

    @PrePersist
    protected void prePersist() {
        if (this.activeLoad == null) {
            this.activeLoad = 0;
        }
    }

}
