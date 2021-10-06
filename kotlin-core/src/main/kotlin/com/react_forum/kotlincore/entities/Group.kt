package com.react_forum.kotlincore.entities

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Column
import javax.persistence.ManyToMany
import javax.persistence.CascadeType
import javax.persistence.OneToMany


@Entity
@Table(name="groups")
class Group(

    @Column(name="name")
    val name: String,

    @Column(name="users")
    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    val users: MutableSet<User> = mutableSetOf(),

    @Column(name="categories")
    @OneToMany(mappedBy = "group", cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH], orphanRemoval = true)
    val categories: MutableSet<Category> = mutableSetOf(),

): AbstractJpaEntity() {

    //addUser
    //removeUser
    //addCategory
    //removeCategory

}
