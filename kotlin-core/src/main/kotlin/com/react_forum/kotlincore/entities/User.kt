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


@Entity
@Table(name="users")
class User(
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    var id: Int

    @Column(name="username")
    @NotNull
    var username: String

    @ManyToMany(mappedBy = "users")
    var groups: MutableSet<Group> = mutableSetOf()

    @OneToMany(mappedBy = "user", cascade = CascadeType.All, orphanRemoval = true)
    var discussions: MutableSet<Discussion> = mutableSetOf()
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.All, orphanRemoval = true)
    var posts: MutableSet<Post> = mutableSetOf()




) {

}
    
