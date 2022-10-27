package denis.korotchenko.demo.controller

import denis.korotchenko.adulthood.AdulthoodChecker
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("adult")
class DemoController(val adulthoodChecker: AdulthoodChecker) {
    @GetMapping("check")
    fun check(@RequestBody request: AdultRequest): String {
        return "${adulthoodChecker.check(request.age)}"
    }
}

data class AdultRequest(
    val age: Int
)