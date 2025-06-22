package kr.ac.kumoh.s20220667.mysql_hotdeal.DTO

import kr.ac.kumoh.s20220667.mysql_hotdeal.entity.Bookmark

data class BookmarkDto(
    val id: Long,
    val userId: Long,
    val userName: String,
    val hotDealId: Long,
    val hotDealTitle: String,
    val createdAt: String
)

fun Bookmark.toDto(): BookmarkDto = BookmarkDto(
    id = this.id,
    userId = this.user.id,
    userName = this.user.username,
    hotDealId = this.hotDeal.id,
    hotDealTitle = this.hotDeal.title,
    createdAt = this.createdAt.toString()
)
