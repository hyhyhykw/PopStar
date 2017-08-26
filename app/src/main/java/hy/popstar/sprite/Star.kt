package hy.popstar.sprite

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint

/**
 * Created time : 2017/8/26 12:10.
 * 星星 精灵类
 * x,y表示在数组中的位置
 * 通过数组位置，获取星星周围的情况
 * @author HY
 */
class Star(val x: Int,
           val y: Int,
           private val bitmap: Bitmap,
           val starColor: StarColor) {

    val height = bitmap.height
    val width = bitmap.width
    private var isSelect=false

    fun setSelect(isSelect:Boolean){
        this.isSelect=isSelect

    }
    fun draw(canvas: Canvas, paint: Paint) {

    }

}