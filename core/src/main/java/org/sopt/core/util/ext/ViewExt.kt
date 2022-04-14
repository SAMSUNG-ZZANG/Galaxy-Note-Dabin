package org.sopt.core.util.ext

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils

fun View.startAnimation(context: Context, value: Int) {
    startAnimation(AnimationUtils.loadAnimation(context, value))
}
