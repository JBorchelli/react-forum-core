package com.react_forum.kotlincore.entities

import javax.persistence.Table
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.CascadeType
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
@Table(name="discussions")
class Discussion(

    @Column(name="heading")
    var heading: String,

    @Column(name="text")
    var text: String?,

    @ManyToOne
    var category: Category,

    @OneToMany(mappedBy ="discussion", cascade = [CascadeType.ALL])
    var posts: MutableSet<Post> = mutableSetOf(),

): AbstractJpaEntity() {
    
}
