package com.chansos.rxandroid.kotlin.utils

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.support.v4.app.Fragment
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.chansos.rxandroid.kotlin.R
import java.io.File

class ImageLoader {
  companion object {
    private val cacheOptions = createDefaultOptions()
      .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
    private val noCacheOptions = createDefaultOptions()

    private fun createDefaultOptions(): RequestOptions {
      return RequestOptions()
        .placeholder(R.drawable.ic_svg_picture)
        .error(R.drawable.ic_svg_picture_error)
        .optionalCenterInside()
        .override(AppManager.getResources().getDimensionPixelSize(R.dimen.x720),
          AppManager.getResources().getDimensionPixelSize(R.dimen.y1080))
    }

    fun load(imageView: ImageView, imageUrl: String, activity: Activity) = loader(imageView, imageUrl, activity, false)

    fun noCacheLoad(imageView: ImageView, imageUrl: String, activity: Activity) = loader(imageView, imageUrl, activity, true)

    fun load(imageView: ImageView, imageUrl: String, fragment: Fragment) = loader(imageView, imageUrl, fragment, false)

    fun noCacheLoad(imageView: ImageView, imageUrl: String, fragment: Fragment) = loader(imageView, imageUrl, fragment, true)

    fun load(imageView: ImageView, imageResId: Int, activity: Activity) = loader(imageView, imageResId, activity, true)

    fun load(imageView: ImageView, imageResId: Int, fragment: Fragment) = loader(imageView, imageResId, fragment, true)

    fun load(imageView: ImageView, file: File, activity: Activity) = loader(imageView, file, activity, true)

    fun load(imageView: ImageView, file: File, fragment: Fragment) = loader(imageView, file, fragment, true)

    fun load(imageView: ImageView, drawable: Drawable, activity: Activity) = loader(imageView, drawable, activity, true)

    fun load(imageView: ImageView, drawable: Drawable, fragment: Fragment) = loader(imageView, drawable, fragment, true)

    private fun loader(imageView: ImageView, imageUrl: Any, obj: Any, isNoCache: Boolean = false) {
      val glide = when (obj) {
        is Fragment -> Glide.with(obj)
        is Activity -> Glide.with(obj)
        is View -> Glide.with(obj)
        else -> Glide.with(AppManager.last())
      }
      val options: RequestOptions = when (isNoCache) {
        true -> noCacheOptions
        false -> cacheOptions
      }
      val builder = when (imageUrl) {
        is File -> glide.load(imageUrl)
        is Uri -> glide.load(imageUrl)
        is Int -> glide.load(imageUrl)
        is Drawable -> glide.load(imageUrl)
        is Bitmap -> glide.load(imageUrl)
        else -> glide.load(imageUrl as String)
      }
      builder.apply(options).into(imageView)
    }
  }
}