package com.example.fakecloud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "machine")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Machine{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="uid", nullable = false)
    private String uid;

    @Enumerated(EnumType.STRING)
    @Column(name="state", nullable = false)
    private MachineState state;

    @ManyToOne
    private User createdBy;

    @CreatedDate
    @Column(name="created_at", nullable = false)
    private Date createdAt;

    @Column(name="active", nullable = false)
    private boolean active;
}
