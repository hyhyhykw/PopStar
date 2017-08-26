package hy.popstar

import android.app.Application
import hy.popstar.utils.screenHeight
import hy.popstar.utils.screenWidth

/**
 * Created time : 2017/8/26 14:31.
 * @author HY
 */
class StarApp : Application() {

    override fun onCreate() {
        super.onCreate()
        screenHeight = screenHeight()
        screenWidth = screenWidth()
    }
}

var screenWidth = 0
var screenHeight = 0