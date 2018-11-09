package winapi251.app.schoolmeal.ui.main

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.TooltipCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_meal.*
import winapi251.app.schoolmeal.R

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

		// 툴팁 달기
		TooltipCompat.setTooltipText(btn_show_meal, getString(R.string.action_show_meal))
		TooltipCompat.setTooltipText(btn_show_nutrient_info, getString(R.string.action_show_nutrient_info))
		TooltipCompat.setTooltipText(btn_show_origin_info, getString(R.string.action_show_origin_info))
		TooltipCompat.setTooltipText(btn_copy_text, getString(R.string.action_copy_text))
		TooltipCompat.setTooltipText(btn_refresh_meal, getString(R.string.action_refresh_meal))

		// TODO 임시 코드
		title = "선린인터넷고등학교"
		toolbar.subtitle = "2018년 11월"
	}

	/** 옵션 메뉴를 생성해야 할 때 호출된다. */
	override fun onCreateOptionsMenu(menu: Menu): Boolean
	{
		menuInflater.inflate(R.menu.activity_main, menu)
		return true
	}
}
