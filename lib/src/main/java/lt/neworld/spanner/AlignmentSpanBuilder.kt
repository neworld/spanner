package lt.neworld.spanner

import android.text.Layout
import android.text.style.AlignmentSpan

/**
 * @author Andrius Semionovas
 * @since 2017-10-11
 */
internal class AlignmentSpanBuilder(private val alignment: Layout.Alignment) : SpanBuilder {
    override fun build(): Any = AlignmentSpan.Standard(alignment)
}