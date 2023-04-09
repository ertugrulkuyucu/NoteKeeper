package com.ertugrulBackend.noteKeeper.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.w3c.dom.Text;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String note;

    @Column()
    private String title;

/*
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
*/


}
