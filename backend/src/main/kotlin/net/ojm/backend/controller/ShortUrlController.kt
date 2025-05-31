package net.ojm.backend.controller

import jakarta.servlet.http.HttpServletResponse
import net.ojm.backend.domain.dto.ShortUrlRequest
import net.ojm.backend.service.ShortUrlService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/shorturl")
class ShortUrlController (
    private val service: ShortUrlService
) {

    @PostMapping
    fun createShortUrl(@RequestBody request: ShortUrlRequest) : ResponseEntity<String> {
        val shortCode = service.createShortUrl(request.longUrl)
        return ResponseEntity.ok("http://localhost:8080/api/shorturl/$shortCode")
    }

    @GetMapping("/{shortCode}")
    fun redirect(@PathVariable shortCode: String, response: HttpServletResponse) {
        val longUrl = service.resolve(shortCode)
        if (longUrl == null) {
            response.sendError(404)
            return
        }
        response.sendRedirect(longUrl)
    }


}