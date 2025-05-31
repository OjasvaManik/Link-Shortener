package net.ojm.backend.service

import net.ojm.backend.domain.entity.ShortUrlEntity
import net.ojm.backend.repo.ShortUrlRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ShortUrlService (
    private val repo: ShortUrlRepository
) {

    fun createShortUrl(longUrl: String) : String {
        val exist = repo.findByLongUrl(longUrl)
        if (exist != null) {
            return exist.shortUrl
        }

        val newShortUrl = UUID.randomUUID().toString().substring(0, 6)
        repo.save(ShortUrlEntity(shortUrl = newShortUrl, longUrl = longUrl))

        return newShortUrl
    }

    fun resolve(shortUrl: String): String? {
        val entity = repo.findByShortUrl(shortUrl)
        return entity?.longUrl
    }

}