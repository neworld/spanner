package lt.neworld.spanner

import android.text.style.StyleSpan
import java.util.*

internal class StyleSpanBuilder(private val style: Int) : SpanBuilder {
    override fun build(): Any = StyleSpan(style)
}
