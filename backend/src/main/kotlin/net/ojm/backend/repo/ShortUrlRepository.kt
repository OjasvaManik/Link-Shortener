package net.ojm.backend.repo

import net.ojm.backend.domain.entity.ShortUrlEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShortUrlRepository : JpaRepository<ShortUrlEntity, Long> {

    fun findByShortUrl(shortUrl: String): ShortUrlEntity?

    fun findByLongUrl(longUrl: String): ShortUrlEntity?

}