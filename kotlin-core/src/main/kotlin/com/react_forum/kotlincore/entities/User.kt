package com.react_forum.kotlincore.entities

import javax.persistence.Table
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.OneToMany
import javax.persistence.ManyToMany
import javax.persistence.CascadeType


@Entity
@Table(name="users")
class User(

    @Column(name="username")
    var username: String,

    @ManyToMany(mappedBy = "users")
    var groups: MutableSet<Group> = mutableSetOf(),

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    var discussions: MutableSet<Discussion> = mutableSetOf(),
    
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    var posts: MutableSet<Post> = mutableSetOf(),

): AbstractJpaEntity() {

}
    
