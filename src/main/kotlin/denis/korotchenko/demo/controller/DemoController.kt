package denis.korotchenko.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {
    @GetMapping("/")
    fun helloWorld(): String {
        return "Hello world!"
    }
}