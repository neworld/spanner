package lt.neworld.spanner

import android.text.style.AbsoluteSizeSpan

/**
 * @author Andrius Semionovas
 * @since 2017-10-11
 */
internal class AbsoluteSizeSpanBuilder(private val size: Int, private val dip: Boolean) : SpanBuilder {
    override fun build(): Any = AbsoluteSizeSpan(size, dip)
}