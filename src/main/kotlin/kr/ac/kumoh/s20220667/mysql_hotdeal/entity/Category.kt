package kr.ac.kumoh.s20220667.mysql_hotdeal.entity
import jakarta.persistence.*

@Entity
data class Category(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val name: String = ""
)
