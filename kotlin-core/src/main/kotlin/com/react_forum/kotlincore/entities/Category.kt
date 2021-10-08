package com.react_forum.kotlincore.entities

import javax.persistence.Table
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.OneToMany
import javax.persistence.CascadeType
import javax.persistence.ManyToOne
import javax.persistence.JoinColumn

@Entity
@Table(name="categories")
class Category(

    @Column(name="title")
    var title: String,

    @JoinColumn(name="group_id")
    @ManyToOne
    var group: Group,

    @OneToMany(mappedBy = "category",
        cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH],
        orphanRemoval = true
    )
    var discussions: MutableSet<Discussion> = mutableSetOf(),

): AbstractJpaEntity() {
    
}
