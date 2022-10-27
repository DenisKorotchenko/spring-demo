package denis.korotchenko.adulthood

open class AdulthoodChecker(private val properties: AdulthoodProperties) {
    fun check(age: Int) = age >= properties.age
}