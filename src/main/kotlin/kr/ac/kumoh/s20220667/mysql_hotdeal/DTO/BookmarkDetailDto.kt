package kr.ac.kumoh.s20220667.mysql_hotdeal.DTO

data class BookmarkDetailDto(
    val bookmarkId: Long,
    val userId: Long,
    val username: String,
    val hotDealId: Long,
    val title: String,
    val price: Int?,
    val site: String,
    val createdAt: java.time.LocalDateTime
)
