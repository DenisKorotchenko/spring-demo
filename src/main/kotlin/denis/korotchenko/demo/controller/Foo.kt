package denis.korotchenko.demo.controller


class Project(
    val tasks: MutableList<DefaultTask> = mutableListOf()
) {
    fun tasks(block: MutableList<DefaultTask>.() -> Unit) {

    }

    inline fun <reified T : DefaultTask> MutableList<DefaultTask>.register(name: String): T {
        val task = T::class.constructors.first().call(name)
        tasks.add(MyTask(name))
        return task
    }

    inline fun <reified T : DefaultTask> MutableList<DefaultTask>.withType(): List<T> =
        tasks.filterIsInstance<T>()

    inline fun <reified T : DefaultTask> MutableList<DefaultTask>.named(
        name: String,
        noinline block: (T.() -> Unit)? = null
    ): T =
        withType<T>().first { it.name == name }.apply { block?.let { it() } }

}

class MyTask(
    name: String
) : DefaultTask(name)

abstract class DefaultTask(val name: String) {
    var group = "other"
}


fun main() {
    val project = Project()
    project.apply {
        tasks {
            register<MyTask>("den")
            withType<MyTask>()
            named<MyTask>("den") {
                group = "best"
            }
        }
    }

}