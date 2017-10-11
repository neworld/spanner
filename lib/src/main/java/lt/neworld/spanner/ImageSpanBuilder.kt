package lt.neworld.spanner

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.text.style.DrawableMarginSpan
import android.text.style.IconMarginSpan

/**
 * @author Andrius Semionovas
 * @since 2017-10-11
 */
internal class ImageSpanBuilder(private val drawable: Drawable?, private val bitmap: Bitmap?, private val pad: Int?) : SpanBuilder {
    override fun build(): Any {
        return if (drawable != null && pad != null) {
            DrawableMarginSpan(drawable, pad)
        } else if (drawable != null) {
            DrawableMarginSpan(drawable)
        } else if (bitmap != null && pad != null) {
            IconMarginSpan(bitmap, pad)
        } else if (bitmap != null) {
            IconMarginSpan(bitmap)
        } else {
            throw RuntimeException("drawable or bitmap must be not null")
        }
    }
}