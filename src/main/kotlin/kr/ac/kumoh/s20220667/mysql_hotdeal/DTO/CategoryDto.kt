package kr.ac.kumoh.s20220667.mysql_hotdeal.DTO
import kr.ac.kumoh.s20220667.mysql_hotdeal.entity.Category

data class CategoryDto(
    val id: Long,
    val name: String
)

fun Category.toDto(): CategoryDto = CategoryDto(
    id = this.id,
    name = this.name
)
