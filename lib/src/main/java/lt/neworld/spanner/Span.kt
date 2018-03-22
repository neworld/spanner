package lt.neworld.spanner

/**
 * @author Andrius Semionovas
 * @since 2017-10-01
 */
open class Span internal constructor(private val builder: SpanBuilder) {
    internal fun buildSpan() = builder.build()
}
