package com.example.util_framework.util

import android.graphics.Color
import android.text.TextUtils
import androidx.core.content.ContextCompat
import com.example.util_framework.app.APP
import java.lang.Exception

/**
 * des 颜色处理工具类
 *
 * @date 2020/03/07
 * @author: zs
 */
object ColorUtils {
    /**
     * 解析颜色
     *
     * @param colorStr
     * @param defaultColor
     * @return
     */
    fun parseColor(colorStr: String, defaultColor: Int): Int {
        var colorStr = colorStr
        return if (TextUtils.isEmpty(colorStr)) {
            defaultColor
        } else try {
            if (!colorStr.startsWith("#")) {
                colorStr = "#$colorStr"
            }
            Color.parseColor(colorStr)
        } catch (e: Exception) {
            defaultColor
        }
    }

    fun parseColor(colorStr: String): Int {
        var colorStr = colorStr
        return if (TextUtils.isEmpty(colorStr)) {
            0
        } else try {
            if (!colorStr.startsWith("#")) {
                colorStr = "#$colorStr"
            }
            Color.parseColor(colorStr)
        } catch (e: Exception) {
            0
        }
    }

    /**
     * 解析颜色
     *
     * @param color
     * @return
     */
    fun parseColor(color: Int): Int {
        return ContextCompat.getColor(APP.Companion.getContext(), color)
    }

    /**
     * 设置html字体色值
     *
     * @param text
     * @param color
     * @return
     */
    fun setTextColor(text: String, color: String): String {
        return "<font color=#$color>$text</font>"
    }
}