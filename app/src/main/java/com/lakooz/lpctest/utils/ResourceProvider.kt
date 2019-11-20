package com.lakooz.lpctest.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build


class ResourceProvider(private val mContext: Context) {
    fun getDrawable(resId: Int): Drawable {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mContext.resources.getDrawable(resId, mContext.theme)
        } else {
            mContext.resources.getDrawable(resId)
        }
    }

}