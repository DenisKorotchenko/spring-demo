package denis.korotchenko.adulthood

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "adult")
open class AdulthoodProperties {
    var age = 18
}
