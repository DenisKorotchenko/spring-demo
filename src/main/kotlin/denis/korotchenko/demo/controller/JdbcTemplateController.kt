package denis.korotchenko.demo.controller

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.ResultSet
import kotlin.RuntimeException

@RestController
@RequestMapping("jdbc")
class JdbcTemplateController(
        val jdbcTemplate: JdbcTemplate
) {
    @PostMapping("create")
    fun createTables() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS authors (id IDENTITY PRIMARY KEY, name VARCHAR(255))")
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS books (id IDENTITY PRIMARY KEY, title VARCHAR(255), authorId INT, FOREIGN KEY (authorId) REFERENCES authors(id))")
    }

    @GetMapping("count")
    fun countAll(): Int? {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM test", Int::class.java)
    }

    @PostMapping("author")
    fun addAuthor(@RequestBody author: Author) {
        jdbcTemplate.update("INSERT INTO authors (name) VALUES (?)", author.name)
    }

    @PostMapping("book")
    fun addBook(@RequestBody book: Book) {
        jdbcTemplate.update("INSERT INTO books (title, authorId) VALUES (?, ?)", book.title, book.authorId)
    }

    @GetMapping("author/{id}")
    fun getAuthor(@PathVariable id: Int): Author {
        return jdbcTemplate.queryForObject("SELECT * FROM authors WHERE ID = ?", AuthorRowMapper(), id) ?: throw RuntimeException()
    }

    @GetMapping("book")
    fun getBooksWithAuthor(): List<BookWithAuthor> {
        return jdbcTemplate.query("SELECT b.id as b_id, b.title as title, a.id as a_id, a.name as name FROM books b LEFT JOIN authors a ON b.authorId = a.id", BooksWithAuthorRowMapper()) ?: throw RuntimeException()
    }

    open class Author {
        var id: Int = 0
        var name: String = ""
    }

    open class AuthorRowMapper: RowMapper<Author> {
        override fun mapRow(rs: ResultSet, rowNum: Int): Author? {
            val author = Author()
            author.id = rs.getInt("id")
            author.name = rs.getString("name")
            return author
        }
    }

    open class Book {
        var id: Int = 0
        var title: String = ""
        var authorId: Int = 0
    }

    open class BookWithAuthor {
        var id: Int = 0
        var title: String = ""
        lateinit var author: Author
    }

    open class BooksWithAuthorRowMapper: RowMapper<BookWithAuthor> {
        override fun mapRow(rs: ResultSet, rowNum: Int): BookWithAuthor? {
            val bookWithAuthor = BookWithAuthor()
            bookWithAuthor.id = rs.getInt("b_id")
            bookWithAuthor.title = rs.getString("title")
            bookWithAuthor.author = Author()
            bookWithAuthor.author.id = rs.getInt("a_id")
            bookWithAuthor.author.name = rs.getString("name")
            return bookWithAuthor
        }
    }
}