package kr.ac.kumoh.s20220667.mysql_hotdeal.repository

import kr.ac.kumoh.s20220667.mysql_hotdeal.entity.*
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(nickname: String): User?
}
