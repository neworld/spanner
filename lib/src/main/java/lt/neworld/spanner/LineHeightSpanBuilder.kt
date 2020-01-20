package lt.neworld.spanner

import android.os.Build
import android.support.annotation.RequiresApi
import android.text.style.LineHeightSpan
import lt.neworld.spanner.SpanBuilder

@RequiresApi(api = Build.VERSION_CODES.Q)
class LineHeightSpanBuilder(private val height: Int): SpanBuilder {
    override fun build(): Any {
        return LineHeightSpan.Standard(height)
    }
}