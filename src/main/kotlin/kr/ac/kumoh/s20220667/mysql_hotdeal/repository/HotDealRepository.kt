package kr.ac.kumoh.s20220667.mysql_hotdeal.repository
import kr.ac.kumoh.s20220667.mysql_hotdeal.entity.Category
import kr.ac.kumoh.s20220667.mysql_hotdeal.entity.HotDeal
import kr.ac.kumoh.s20220667.mysql_hotdeal.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface HotDealRepository : JpaRepository<HotDeal, Long>{
    fun findByCategory(category: Category): List<HotDeal>
    fun findByUser(user: User): List<HotDeal>
    fun findByTitleContaining(keyword: String): List<HotDeal>
}


