package denis.korotchenko.demo.controller


class Project(
    val tasks: MutableList<Task> = mutableListOf()
) {
    fun tasks(block: MutableList<Task>.() -> Unit) {

    }
}

class Task(
    val name: String
)


fun main() {
    Project().apply {
    }
}