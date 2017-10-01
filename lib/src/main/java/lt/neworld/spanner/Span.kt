package lt.neworld.spanner

/**
 * @author Andrius Semionovas
 * @since 2017-10-01
 */
class Span internal constructor(private val builder: SpanBuilder<Any>) {
    internal fun buildSpan() = builder.build()
}
