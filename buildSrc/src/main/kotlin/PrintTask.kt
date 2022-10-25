import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFile
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class PrintTask : DefaultTask() {

    @get:Input
    abstract val message: Property<String>

    @get:OutputFile
    @get:Optional
    abstract val file : RegularFileProperty

    init {
        group = "best"
        file.set(project.buildDir.resolve(name))
    }

    @TaskAction
    fun print() {
        val personName = project.extensions.getByType(PersonExtenction::class.java).name
        println(personName + " say: " + message.get())
        file.get().asFile.also {
            it.parentFile.mkdirs()
            it.createNewFile()
            it.writeText(message.get())
        }
    }
}