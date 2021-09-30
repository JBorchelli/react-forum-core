package com.react_forum.entities

import javax.persistence.Table
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.NotNull
import javax.persistence.GenerationType
import javax.persistence.ManyToMany
import javax.persistence.CascadeType
import javax.persistence.ManyToOne

@Entity
@Table(name="posts")
class Post(
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    var id: Int

    @Column(name="text")
    @NotNull
    var text: String

    @Column(name="user")
    @ManyToOne
    var user: User

    @Column(name="discussion")
    @ManyToOne
    var discussion: Discussion


) {
    
}
