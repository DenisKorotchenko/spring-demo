package denis.korotchenko.demo.controller

import denis.korotchenko.adulthood.AdulthoodChecker
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("adult")
class DemoController(val adulthoodChecker: AdulthoodChecker) {
    @PostMapping("check")
    fun check(@RequestBody request: AdultRequest): String {
        return "${adulthoodChecker.check(request.age)}"
    }
}

data class AdultRequest(
    val age: Int
)