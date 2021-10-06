package com.react_forum.kotlincore.entities

import javax.persistence.Table
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.OneToMany
import javax.persistence.ManyToMany
import javax.persistence.CascadeType
import javax.persistence.JoinTable
import javax.persistence.JoinColumn
import javax.persistence.FetchType

@Entity
@Table(name="users")
class User(

    @Column(name="username")
    var username: String,

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    @JoinTable(
        name = "groups_users",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "group_id", referencedColumnName = "id")],
    )
    var groups: MutableSet<Group> = mutableSetOf(),

    @OneToMany(mappedBy = "user",
        cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH],
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    var discussions: MutableSet<Discussion> = mutableSetOf(),
    
    @OneToMany(mappedBy = "user",
        cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH],
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    var posts: MutableSet<Post> = mutableSetOf(),

): AbstractJpaEntity() {

}
    
