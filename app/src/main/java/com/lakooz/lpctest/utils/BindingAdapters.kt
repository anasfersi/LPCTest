package com.lakooz.lpctest.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.lakooz.lpctest.R

@BindingAdapter("imageUrlBinding")
fun setImageUrl(imageView: ImageView, url: String?) {
    var requestOptions = RequestOptions()
    requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))
    Glide.with(imageView).load(url)
        .apply(requestOptions)
        .error(R.drawable.ic_launcher_background)
        .into(imageView)
}


@BindingAdapter("amountBinding")
fun setAmount(textView: TextView, value: Float) {
    textView.text = value.toString()
}
