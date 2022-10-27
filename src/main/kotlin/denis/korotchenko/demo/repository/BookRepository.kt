package denis.korotchenko.demo.repository

import denis.korotchenko.demo.entity.BookEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: CrudRepository<BookEntity, Int> {
}