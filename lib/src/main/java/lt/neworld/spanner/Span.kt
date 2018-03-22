package lt.neworld.spanner

open class Span internal constructor(private val builder: SpanBuilder) {
    internal fun buildSpan() = builder.build()
}
