package kr.ac.kumoh.s20220667.mysql_hotdeal.DTO
import kr.ac.kumoh.s20220667.mysql_hotdeal.entity.*

data class UserDto(
    val id: Long,
    val username: String
)

// Entity → DTO 변환
fun User.toDto(): UserDto = UserDto(
    id = this.id,
    username = this.username
)
