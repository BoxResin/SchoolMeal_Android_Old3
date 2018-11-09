package winapi251.app.schoolmeal.model.school

import kotlinx.coroutines.delay
import winapi251.app.schoolmeal.model.Area
import winapi251.app.schoolmeal.model.school.School.Code
import winapi251.app.schoolmeal.model.school.School.Course

/** 가짜 학교 API */
object MockSchoolApi : SchoolApi
{
	override suspend fun search(name: String): List<School>
	{
		delay(3000)

		return listOf(
				School(Code("B100000925"), Course.ELEMENTARY, name = "서울선린초등학교",
						address = "서울특별시 강동구 진황도로61길 29", area = Area.SEN),

				School(Code("B100002350"), Course.MIDDLE, name = "선린중학교",
						address = "서울특별시 용산구 원효로97길 33-4", area = Area.SEN),

				School(Code("B100000658"), Course.HIGH, name = "선린인터넷고등학교",
						address = "서울특별시 용산구 원효로97길 33-4", area = Area.SEN)
		).filter { school -> name in school.name }
	}
}
