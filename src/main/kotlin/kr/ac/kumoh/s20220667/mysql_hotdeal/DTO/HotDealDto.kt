package kr.ac.kumoh.s20220667.mysql_hotdeal.DTO
import kr.ac.kumoh.s20220667.mysql_hotdeal.entity.*

data class HotDealDto(
    val id: Long,
    val title: String,
    val content: String?,
    val price: Int?,
    val url: String,
    val imageUrl: String?,
    val site: String,
    val postedAt: String,
    val categoryName: String,   // Category의 name만
    val userName: String    // User의 nickname만
)

fun HotDeal.toDto(): HotDealDto = HotDealDto(
    id = this.id,
    title = this.title,
    content = this.content,
    price = this.price,
    url = this.url,
    imageUrl = this.imageUrl,
    site = this.site,
    postedAt = this.postedAt.toString(),
    categoryName = this.category.name,
    userName = this.user.username
)
