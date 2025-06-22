package kr.ac.kumoh.s20220667.mysql_hotdeal
import kr.ac.kumoh.s20220667.mysql_hotdeal.DTO.*
import kr.ac.kumoh.s20220667.mysql_hotdeal.repository.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hotdeals")
class HotDealController(
    private val hotDealService: HotDealService,
    private val hotDealRepository: HotDealRepository
) {
    /** 1. 핫딜 전체 목록 */
    @GetMapping
    fun list(): List<HotDealDto> = hotDealService.getAllHotDeals()


    @GetMapping("/db-check")
    fun dbCheck(): String {
        return try {
            val list = hotDealRepository.findAll()
            "hotDeal 개수: ${list.size}"
        } catch (e: Exception) {
            "DB 연결 실패: ${e.message}"
        }
    }




    /** 2. 핫딜 상세 조회 */
    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): HotDealDto? = hotDealService.getHotDeal(id)

    /** 3. 핫딜 등록 (샘플: 요청 바디 전체 전달) */
    @PostMapping
    fun create(@RequestBody dto: HotDealCreateRequest): HotDealDto? =
        hotDealService.createHotDeal(
            title = dto.title,
            content = dto.content,
            price = dto.price,
            url = dto.url,
            imageUrl = dto.imageUrl,
            site = dto.site,
            categoryId = dto.categoryId,
            userId = dto.userId
        )

    /** 4. 핫딜 삭제 */
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = hotDealService.deleteHotDeal(id)

    /** 5. 즐겨찾기 추가 */
    @PostMapping("/{id}/bookmark")
    fun addBookmark(
        @PathVariable id: Long,
        @RequestParam userId: Long
    ): Boolean = hotDealService.addBookmark(userId, id)

    /** 6. 즐겨찾기 삭제 */
    @DeleteMapping("/{id}/bookmark")
    fun removeBookmark(
        @PathVariable id: Long,
        @RequestParam userId: Long
    ): Boolean = hotDealService.removeBookmark(userId, id)

    /** 7. 특정 유저의 즐겨찾기 목록 */
    @GetMapping("/bookmarks")
    fun myBookmarks(@RequestParam userId: Long): List<BookmarkDto> =
        hotDealService.getBookmarks(userId)
}

