package winapi251.app.schoolmeal.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
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
		setToolbarDateText(Calendar.getInstance().time)

		// 날짜 선택 뷰 초기화
		date_picker.setListener(object: CompactCalendarView.CompactCalendarViewListener {
			override fun onDayClick(dateClicked: Date)
			{
			}

			/** 달력을 옆으로 넘길 때마다 호출된다. */
			override fun onMonthScroll(firstDayOfNewMonth: Date)
			{
				// 툴바 부제목 날짜 텍스트 변경
				setToolbarDateText(firstDayOfNewMonth)
			}
		})

		// 달력 접기 버튼 클릭 리스너 설정
		btn_drop_up_calendar.setOnClickListener {
			// 달력을 숨기고 달력 열기 메뉴를 보여준다.
			calendar_group.visibility = View.GONE
			toolbar.menu.findItem(R.id.action_drop_down_calendar).isVisible = true

			// 툴바 부제목을 숨긴다.
			toolbar.subtitle = ""
		}

		// 툴팁 달기
		TooltipCompat.setTooltipText(btn_drop_up_calendar, getString(R.string.action_drop_up_calendar))
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

	/** 옵션 메뉴를 클릭할 때 호출된다. */
	override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId)
	{
		// 달력 열기
		R.id.action_drop_down_calendar ->
		{
			// 달력을 보여주고 달력 열기 메뉴를 숨긴다.
			calendar_group.visibility = View.VISIBLE
			item.isVisible = false

			// 툴바 부제목 날짜 텍스트 변경
			setToolbarDateText(date_picker.firstDayOfCurrentMonth)
			true
		}
		else -> false
	}

	/** 툴바 부제목의 날짜 텍스트를 설정한다. */
	private fun setToolbarDateText(date: Date)
	{
		val calendar = Calendar.getInstance().apply { time = date }
		toolbar.subtitle = "${calendar[YEAR]}년 ${calendar[MONTH] + 1}월"
	}
}
