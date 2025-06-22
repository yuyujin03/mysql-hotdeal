package kr.ac.kumoh.s20220667.mysql_hotdeal.repository
import kr.ac.kumoh.s20220667.mysql_hotdeal.entity.*
import org.springframework.data.jpa.repository.JpaRepository

interface BookmarkRepository : JpaRepository<Bookmark, Long> {
    fun findByUser(user: User): List<Bookmark>
    fun findByHotDeal(hotDeal: HotDeal): List<Bookmark>
    fun findByUserAndHotDeal(user: User, hotDeal: HotDeal): Bookmark?
}

