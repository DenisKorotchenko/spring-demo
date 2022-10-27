package denis.korotchenko.demo.repository

import denis.korotchenko.demo.entity.AuthorEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository: CrudRepository<AuthorEntity, Int> {
}