package lt.neworld.spanner

import android.text.style.LeadingMarginSpan
import lt.neworld.spanner.SpanBuilder

internal class LeadingMarginSpanBuilder(private val everyOrFirst: Int, private val rest: Int?) : SpanBuilder {
    override fun build(): Any {
        return if (rest != null) {
            LeadingMarginSpan.Standard(everyOrFirst, rest)
        } else {
            LeadingMarginSpan.Standard(everyOrFirst)
        }
    }
}