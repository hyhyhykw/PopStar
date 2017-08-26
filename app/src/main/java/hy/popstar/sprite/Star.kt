package hy.popstar.sprite

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import hy.popstar.PopStar

/**
 * Created time : 2017/8/26 12:10.
 * 星星 精灵类
 * x,y表示在数组中的位置
 * 通过数组位置，获取星星周围的情况
 * @author HY
 */
class Star(val x: Int,
           val y: Int,
           private var bitmap: Bitmap,
            var starColor: StarColor) {

    val height = bitmap.height
    val width = bitmap.width
    private var isSelect = false
    private var selectBm: Bitmap? = null
     var isNull=false

    fun select(selectBm: Bitmap) {
        isSelect = true
        this.selectBm = selectBm
    }

    fun draw(canvas: Canvas, paint: Paint) {
        if (null != selectBm) {

        }

    }

    fun destroy(noneBm: Bitmap) {
        starColor = StarColor.NONE
        isSelect = false
        bitmap = noneBm
        selectBm = null
        isNull=true
    }

    fun getRound():Round{
        val round = Round()
        //todo
        if (x==0){
            round.top=null
        }else{
            round.top=PopStar.mStars[x-1][y]
        }

        if (x==10){
            round.bottom=null
        }else{
            round.bottom=PopStar.mStars[x+1][y]
        }
        if (y==0){
            round.left=null
        }else{
            round.left=PopStar.mStars[x][y-1]
        }
        if (y==10){
            round.right=null
        }else{
            round.right=PopStar.mStars[x][y+1]
        }


        return round
    }
}