tasks {
    val foo = register<PrintTask>("foo") {
        message.set(name)
    }
    val bar = register<PrintTask>("bar") {
        message.set(foo.map { it.message.get() })
    }
}

extensions.create("person", PersonExtenction::class)

extensions.getByType(SourceSetContainer::class.java).also {
    it.create("integrationTest"){
    }
}