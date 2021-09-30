package com.react_forum.entities

import javx.persistence.Table
import javx.persistence.Entity
import javx.persistence.Column



@Entity
@Table(name="groups")
class Group(
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.Auto)
    var id: Int

    @Column(name="name")
    @NotNull
    var name: String

    @Column(name="users")
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    var users: MutableSet<User> = mutableSetOf()

) {
    
}
