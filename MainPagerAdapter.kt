package mdk.mdapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import mdk.diaryapp.R
import mdk.mdapp.fragment.*


class MainPagerAdapter(fm: FragmentManager?, numOfTabs: Int, context: Context) : FragmentPagerAdapter(fm!!) {

    var numOfTabs: Int = 0
    var context: Context

    private val tabTitles = arrayOf("Của bạn", "TimeLine", "Nổi bật", "HashTag", "Lưu lại", "Sống")

    init {
        this.numOfTabs = numOfTabs
        this.context = context
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return CuaBanFragment()
            1 -> return TimeLineFragment()
            2 -> return NoiBatFragment()
            3 -> return HashTagFragment()
            4 -> return LuuLaiFragment()
            5 -> return SongFragment()
            else -> return CuaBanFragment()
        }
    }

    override fun getCount(): Int {
        return numOfTabs
    }

    fun getTabView(position: Int): View? {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        val v: View = LayoutInflater.from(context).inflate(R.layout.layout_tab_item, null)
        var textView = v.findViewById(R.id.textView_tabItem) as TextView
        textView.setText(tabTitles[position])
        return v
    }

}