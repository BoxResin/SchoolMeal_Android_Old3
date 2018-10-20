package winapi251.app.schoolmeal.model.school

/** 학교 API */
interface SchoolApi
{
	/**
	 * 학교를 검색한다.
	 * @param name 학교 이름
	 * @return 검색된 학교 목록
	 */
	suspend fun search(name: String): List<School>

	// 기본 동작 설정
	companion object : SchoolApi by MockSchoolApi
}
