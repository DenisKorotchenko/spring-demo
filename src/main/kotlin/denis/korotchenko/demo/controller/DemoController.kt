package denis.korotchenko.demo.controller

import denis.korotchenko.adulthood.AdulthoodChecker
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController(val adulthoodChecker: AdulthoodChecker) {
    @GetMapping("/")
    fun helloWorld(): String {
        return "${adulthoodChecker.check(17)}"
    }
}