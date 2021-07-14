package com.udacity

import android.animation.AnimatorSet
import android.view.View
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart

/**
 * Created by heinhtet deevvdd@gmail.com on 12,July,2021
 */
fun AnimatorSet.disableInteractionWhenLoading(view: View) = apply {
    doOnStart { view.isEnabled = false }
    doOnEnd { view.isEnabled = true }
}