package lt.neworld.spanner

import android.text.style.LeadingMarginSpan

internal class LeadingMarginSpanBuilder(private val everyOrFirst: Int, private val rest: Int?) : SpanBuilder {
    override fun build(): Any {
        return if (rest != null) {
            LeadingMarginSpan.Standard(everyOrFirst, rest)
        } else {
            LeadingMarginSpan.Standard(everyOrFirst)
        }
    }
}