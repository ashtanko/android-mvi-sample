package com.twere.data.util

import android.util.Log
import java.util.*

var TAG: String = "KOTLIN_CLEAN"

fun log(vararg objects: Any) {
    Log.v(TAG, Arrays.toString(objects))
}
