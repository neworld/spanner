package lt.neworld.spanner

import android.support.annotation.ColorInt
import android.text.style.BulletSpan

internal class BulletSpanBuilder(private val gapWidth: Int?, @ColorInt private val color: Int?) : SpanBuilder {
    override fun build(): Any {
        return if (gapWidth != null && color != null) {
            BulletSpan(gapWidth, color)
        } else if (gapWidth != null) {
            BulletSpan(gapWidth)
        } else {
            BulletSpan()
        }
    }
}