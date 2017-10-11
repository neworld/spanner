package lt.neworld.spanner

import android.text.style.StyleSpan
import java.util.*

/**
 * @author Andrius Semionovas
 * @since 2017-10-11
 */

internal class StyleSpanBuilder(private val style: Int) : SpanBuilder {
    override fun build(): Any = StyleSpan(style)
}
