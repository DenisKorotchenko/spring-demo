package denis.korotchenko.adulthood

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(AdulthoodProperties::class)
@Configuration
open class AdulthoodAutoConfiguration {
    //open fun properties() = AdulthoodProperties()

    @Bean
    @ConditionalOnMissingBean
    open fun adulthoodChecker(properties: AdulthoodProperties) = AdulthoodChecker(properties)
}