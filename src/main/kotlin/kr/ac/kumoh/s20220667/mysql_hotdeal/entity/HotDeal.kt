package kr.ac.kumoh.s20220667.mysql_hotdeal.entity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "hotdeal")
data class HotDeal(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val title: String = "",

    val content: String? = null,

    val price: Int? = null,

    val url: String = "",

    val imageUrl: String? = null,

    val site: String = "",

    @Column(nullable = false)
    val postedAt: LocalDateTime = LocalDateTime.now(),

    // Category 연관관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    val category: Category,

    // User 연관관계 (글쓴이)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User
)
