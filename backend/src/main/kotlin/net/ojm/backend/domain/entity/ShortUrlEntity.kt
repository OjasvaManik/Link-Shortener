package net.ojm.backend.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "short_urls")
data class ShortUrlEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0,

    @Column(name = "short_url", nullable = false, unique = true)
    val shortUrl: String,

    @Column(name = "long_url", nullable = false)
    val longUrl: String,

)