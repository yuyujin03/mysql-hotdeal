package kr.ac.kumoh.s20220667.mysql_hotdeal.DTO

data class HotDealCreateRequest(
    val title: String,
    val content: String?,
    val price: Int?,
    val url: String,
    val imageUrl: String?,
    val site: String,
    val categoryId: Long,
    val userId: Long
)
