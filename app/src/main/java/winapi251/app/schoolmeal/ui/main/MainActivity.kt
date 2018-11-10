package winapi251.app.schoolmeal.ui.main

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.TooltipCompat
import com.github.sundeepk.compactcalendarview.CompactCalendarView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_meal.*
import winapi251.app.schoolmeal.R
import java.util.*
import java.util.Calendar.MONTH
import java.util.Calendar.YEAR

/** 메인 액티비티 */
class MainActivity : AppCompatActivity()
{
	/** 메인 액티비티가 생성될 때 호출된다. */
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		// 툴바 초기화
		setSupportActionBar(toolbar)

		// 초기 날짜 텍스트 설정
		val today = Calendar.getInstance()
		setToolbarDateText(today[YEAR], today[MONTH] + 1)

		// 날짜 선택 뷰 초기화
		date_picker.setListener(object: CompactCalendarView.CompactCalendarViewListener {
			override fun onDayClick(dateClicked: Date)
			{
			}

			/** 달력을 옆으로 넘길 때마다 호출된다. */
			override fun onMonthScroll(firstDayOfNewMonth: Date)
			{
				val calendar = Calendar.getInstance().apply { time = firstDayOfNewMonth }

				// 툴바 부제목 날짜 텍스트 변경
				setToolbarDateText(calendar[YEAR], calendar[MONTH] + 1)
			}
		})

		// 툴팁 달기
		TooltipCompat.setTooltipText(btn_show_meal, getString(R.string.action_show_meal))
		TooltipCompat.setTooltipText(btn_show_nutrient_info, getString(R.string.action_show_nutrient_info))
		TooltipCompat.setTooltipText(btn_show_origin_info, getString(R.string.action_show_origin_info))
		TooltipCompat.setTooltipText(btn_copy_text, getString(R.string.action_copy_text))
		TooltipCompat.setTooltipText(btn_refresh_meal, getString(R.string.action_refresh_meal))

		// TODO 임시 코드
		title = "선린인터넷고등학교"
	}

	/** 옵션 메뉴를 생성해야 할 때 호출된다. */
	override fun onCreateOptionsMenu(menu: Menu): Boolean
	{
		menuInflater.inflate(R.menu.activity_main, menu)
		return true
	}

	/** 툴바 부제목의 날짜 텍스트를 설정한다. */
	private fun setToolbarDateText(year: Int, month: Int)
	{
		toolbar.subtitle = "${year}년 ${month}월"
	}
}
