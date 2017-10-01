package lt.neworld.spanner

import lt.neworld.spanner.internal.Function0

/**
 * @author Andrius Semionovas
 * @since 2017-10-01
 */
class Span internal constructor(private val builder: Function0<Any>) {
    internal fun buildSpan() = builder()
}
