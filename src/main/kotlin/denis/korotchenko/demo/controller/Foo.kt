package denis.korotchenko.demo.controller


class Project(
    val providers: MutableList<Provider<DefaultTask>> = mutableListOf()
) {
    fun tasks(block: MutableList<Provider<DefaultTask>>.() -> Unit) {
        providers.apply(block)
    }

    inline fun <reified T : DefaultTask> MutableList<Provider<DefaultTask>>.register(name: String): Provider<T> {
        val provider = Provider<T>(name)
        providers.add(provider as Provider<DefaultTask>)
        return provider
    }

    inline fun <reified T : DefaultTask> MutableList<Provider<DefaultTask>>.withType(): List<Provider<T>> =
        providers.filterIsInstance<Provider<T>>()

    inline fun <reified T : DefaultTask> MutableList<Provider<DefaultTask>>.named(
        name: String,
        noinline block: (T.() -> Unit)? = null
    ): Provider<T> =
        withType<T>().first { it.name == name }.apply { block?.let { configure { it() } } }

}

class MyTask(
    name: String
) : DefaultTask(name) {
    init {
        println("Init()")
    }
}

abstract class DefaultTask(val name: String) {
    var group = "other"
}

class Provider<T: DefaultTask>(val name: String) {

    val actions = mutableListOf<T.() -> Unit>()

    fun configure(action: T.() -> Unit) {
        actions.add(action)
    }

    inline fun <reified R: T> get(): T {
        val task = R::class.constructors.first().call(name)
        actions.forEach {
            task.apply(it)
        }
        return task
    }
}

fun main() {
    val project = Project()
    project.apply {
        tasks {
            register<MyTask>("den")
            withType<MyTask>()
            named<MyTask>("den") {
                group = "best"
            }.get<MyTask>()
        }
    }

}