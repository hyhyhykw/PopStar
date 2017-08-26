package hy.popstar

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.AttributeSet
import android.view.View
import hy.popstar.sprite.Star
import hy.popstar.sprite.StarColor
import hy.popstar.utils.random
import hy.popstar.utils.screenHeight
import hy.popstar.utils.screenWidth
import java.util.*

/**
 * Created time : 2017/8/26 14:10.
 * @author HY
 */
class PopStar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        View(context, attrs, defStyleAttr) {


    private val blueStar = BitmapFactory.decodeResource(resources, R.drawable.block_blue)
    private val greenStar = BitmapFactory.decodeResource(resources, R.drawable.block_green)
    private val purpleStar = BitmapFactory.decodeResource(resources, R.drawable.block_purple)
    private val redStar = BitmapFactory.decodeResource(resources, R.drawable.block_red)
    private val yellowStar = BitmapFactory.decodeResource(resources, R.drawable.block_yellow)
    private val selectStar = BitmapFactory.decodeResource(resources, R.drawable.block_select)

    private val colors = ArrayList<StarColor>()
    private val stars = ArrayList<Bitmap>()

    private val screenWidth = screenWidth()
    private val screenHeight = screenHeight()

    init {
        colors.add(StarColor.BLUE)
        colors.add(StarColor.GREEN)
        colors.add(StarColor.PURPLE)
        colors.add(StarColor.RED)
        colors.add(StarColor.YELLOW)

        stars.add(blueStar)
        stars.add(greenStar)
        stars.add(purpleStar)
        stars.add(redStar)
        stars.add(yellowStar)

        createStars()

    }


    private fun createStars() {
        mStars.clear()
        for (x in 9 downTo 0) {
            val starList = ArrayList<Star>()
            for (y in 0..9) {
                val num = random.nextInt(5)

                starList.add(Star(x, y, stars[num], colors[num]))
            }
        }
    }

    companion object {
        private val mStars = ArrayList<ArrayList<Star>>()
    }
}