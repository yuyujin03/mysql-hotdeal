package kr.ac.kumoh.s20220667.mysql_hotdeal

import kr.ac.kumoh.s20220667.mysql_hotdeal.DTO.*
import kr.ac.kumoh.s20220667.mysql_hotdeal.entity.*
import kr.ac.kumoh.s20220667.mysql_hotdeal.repository.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class HotDealService(
    private val userRepository: UserRepository,
    private val categoryRepository: CategoryRepository,
    private val hotDealRepository: HotDealRepository,
    private val bookmarkRepository: BookmarkRepository
) {
    /** 핫딜 전체 목록 (최신순) */
    fun getAllHotDeals(): List<HotDealDto> =
        hotDealRepository.findAll()
            .sortedByDescending { it.postedAt }
            .map { it.toDto() }


    /** 핫딜 상세 조회 */
    fun getHotDeal(id: Long): HotDealDto? =
        hotDealRepository.findById(id).orElse(null)?.toDto()

    /** 핫딜 등록 */
    fun createHotDeal(
        title: String, content: String?, price: Int?, url: String,
        imageUrl: String?, site: String, categoryId: Long, userId: Long
    ): HotDealDto? {
        val user = userRepository.findById(userId).orElse(null) ?: return null
        val category = categoryRepository.findById(categoryId).orElse(null) ?: return null
        val hotDeal = HotDeal(
            title = title,
            content = content,
            price = price,
            url = url,
            imageUrl = imageUrl,
            site = site,
            postedAt = java.time.LocalDateTime.now(),
            category = category,
            user = user
        )
        return hotDealRepository.save(hotDeal).toDto()
    }

    /** 핫딜 삭제 */
    fun deleteHotDeal(id: Long) = hotDealRepository.deleteById(id)

    /** 즐겨찾기 추가 */
    @Transactional
    fun addBookmark(userId: Long, hotDealId: Long): Boolean {
        val user = userRepository.findById(userId).orElse(null) ?: return false
        val hotDeal = hotDealRepository.findById(hotDealId).orElse(null) ?: return false
        if (bookmarkRepository.findByUserAndHotDeal(user, hotDeal) != null) return false
        bookmarkRepository.save(Bookmark(user = user, hotDeal = hotDeal))
        return true
    }

    /** 즐겨찾기 삭제 */
    @Transactional
    fun removeBookmark(userId: Long, hotDealId: Long): Boolean {
        val user = userRepository.findById(userId).orElse(null) ?: return false
        val hotDeal = hotDealRepository.findById(hotDealId).orElse(null) ?: return false
        val bookmark = bookmarkRepository.findByUserAndHotDeal(user, hotDeal) ?: return false
        bookmarkRepository.delete(bookmark)
        return true
    }

    /** 유저별 즐겨찾기한 핫딜 목록 */
    fun getBookmarks(userId: Long): List<BookmarkDto> {
        val user = userRepository.findById(userId).orElse(null) ?: return emptyList()
        return bookmarkRepository.findByUser(user).map { it.toDto() }
    }
}

