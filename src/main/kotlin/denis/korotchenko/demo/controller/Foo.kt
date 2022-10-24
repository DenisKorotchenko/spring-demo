package denis.korotchenko.demo.controller


class Project(
    val tasks: MutableList<DefaultTask> = mutableListOf()
) {
    fun tasks(block: MutableList<DefaultTask>.() -> Unit) {

    }

    fun MutableList<DefaultTask>.register(name: String) {
        tasks.add(Task(name))
    }

    fun MutableList<DefaultTask>.withType(type: Class<in DefaultTask>): List<DefaultTask> {
        return tasks.filter { it::class == type }
    }
}

class Task(
    name: String,
) : DefaultTask(name)

abstract class DefaultTask(val name: String)


fun main() {
    val project = Project()
    project.apply {
        tasks {
            register("den")
        }
    }

}