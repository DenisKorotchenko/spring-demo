package denis.korotchenko.adulthood

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class AdulthoodAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    open fun adulthoodChecker() = AdulthoodChecker()
}