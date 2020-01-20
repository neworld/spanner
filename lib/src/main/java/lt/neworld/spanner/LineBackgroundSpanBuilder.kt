package lt.neworld.spanner

import android.os.Build
import android.support.annotation.RequiresApi
import android.text.style.LineBackgroundSpan
import lt.neworld.spanner.SpanBuilder

@RequiresApi(api = Build.VERSION_CODES.Q)
class LineBackgroundSpanBuilder(private val color: Int): SpanBuilder {
    override fun build(): Any {
        return LineBackgroundSpan.Standard(color)
    }
}