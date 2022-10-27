package denis.korotchenko.demo.controller

import denis.korotchenko.demo.entity.AuthorEntity
import denis.korotchenko.demo.entity.BookEntity
import denis.korotchenko.demo.repository.AuthorRepository
import denis.korotchenko.demo.repository.BookRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("jpa")
class JpaController(
        val authorRepository: AuthorRepository,
        val bookRepository: BookRepository
) {
    @PostMapping("author")
    fun addAuthor(@RequestBody author: JdbcTemplateController.Author) {
        authorRepository.save(AuthorEntity(author.id, author.name))
    }

    @PostMapping("book")
    fun addBook(@RequestBody book: JdbcTemplateController.Book) {
        bookRepository.save(BookEntity(book.id, book.title, authorRepository.findById(book.authorId).orElseThrow()))
    }

    @GetMapping("author/{id}")
    fun getAuthor(@PathVariable id: Int): AuthorEntity {
        return authorRepository.findById(id).orElseThrow()
    }

    @GetMapping("book")
    fun getBooksWithAuthor(): List<BookEntity> {
        return bookRepository.findAll().toList()
    }

}