package com.server.kt.common.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * 时间工具类
 *
 * @author maple
 * @version 1.0
 * @since 2019-02-24 17:34
 */
object DateUtils {
    val defaultSimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val simpleDateFormat = SimpleDateFormat()

    fun format2Str(date: Date):String {
        return defaultSimpleDateFormat.format(date)
    }
}

//将工具类使用拓展方式写入Date类中

/**
 * 使用指定方式格式化时间字符串
 */
fun Date.format2Str(pattern:String):String{
    DateUtils.simpleDateFormat.applyPattern(pattern)
    return DateUtils.simpleDateFormat.format(this)
}
/**
 * 使用默认方式格式化时间字符串
 */
fun Date.format2Str():String{
    return DateUtils.defaultSimpleDateFormat.format(this)
}