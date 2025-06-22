package kr.ac.kumoh.s20220667.mysql_hotdeal.entity
import jakarta.persistence.*

@Entity
data class Bookmark(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    // User 연관관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    // HotDeal 연관관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotdeal_id")
    val hotDeal: HotDeal,

    @Column(nullable = false)
    val createdAt: java.time.LocalDateTime = java.time.LocalDateTime.now()
)
