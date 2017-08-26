package hy.popstar

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.AttributeSet
import android.view.View
import hy.popstar.sprite.Round
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

    private val iconNone = BitmapFactory.decodeResource(resources, R.drawable.icon_none)

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

        val round = mStars[0][0].getRound()
        getRound(mStars[0][0],round)
    }

    private fun getRound(star: Star,round: Round) {
        val left = round.left
        if (null != left&&!left.isNull&&left.starColor==star.starColor) {
            getRound(left, left.getRound())
        }

        TODO()
        val right = round.right
        if (null != right) {
            getRound(right, right.getRound())
        }

        val top = round.top
        if (null != top) {
            getRound(top, top.getRound())
        }
        val bottom = round.bottom
        if (null != bottom) {
            getRound(bottom, bottom.getRound())
        }

        data.add(round)
    }


    private fun createStars() {
        mStars.clear()
        for (x in 0..9) {
            val starList = ArrayList<Star>()
            for (y in 0..9) {
                val num = random.nextInt(5)

                starList.add(Star(x, y, stars[num], colors[num]))
            }

            mStars.add(starList)
        }
    }

    companion object {
        val mStars = ArrayList<ArrayList<Star>>()

        private val data = ArrayList<Round>()
    }
}