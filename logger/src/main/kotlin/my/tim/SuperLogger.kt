package my.tim

class SuperLogger {

    enum class Level {
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    fun log(message: String, level: Level) {
        println(level.name + ": " + message)
    }

    //fun log(message: String) = log(message, Level.DEBUG)
}