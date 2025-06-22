package kr.ac.kumoh.s20220667.mysql_hotdeal.repository
import kr.ac.kumoh.s20220667.mysql_hotdeal.entity.*
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {
    fun findByName(name: String): Category?
}
