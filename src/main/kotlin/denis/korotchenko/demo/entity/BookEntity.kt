package denis.korotchenko.demo.entity

import javax.persistence.*

@Entity(name = "books")
@SequenceGenerator(allocationSize = 1, name = "books_seq", sequenceName = "books_seq")
data class BookEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_seq")
        val id: Int? = null,
        val title: String,

        @ManyToOne
        @MapsId
        val author: AuthorEntity
)
