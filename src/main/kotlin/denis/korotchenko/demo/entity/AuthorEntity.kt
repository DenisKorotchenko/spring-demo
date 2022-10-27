package denis.korotchenko.demo.entity

import javax.persistence.*

@Entity(name = "authors")
@SequenceGenerator(allocationSize = 1, name = "authors_seq", sequenceName = "authors_seq")
data class AuthorEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authors_seq")
        val id: Int,
        val name: String
)