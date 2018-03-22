package lt.neworld.spanner

import android.text.style.AbsoluteSizeSpan

internal class AbsoluteSizeSpanBuilder(private val size: Int, private val dip: Boolean) : SpanBuilder {
    override fun build(): Any = AbsoluteSizeSpan(size, dip)
}