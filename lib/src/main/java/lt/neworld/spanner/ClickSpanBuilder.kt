package lt.neworld.spanner

import android.text.style.ClickableSpan
import android.view.View

internal class ClickSpanBuilder(private val clickListener: View.OnClickListener) : SpanBuilder {
    override fun build(): Any = EasyClickableSpan(clickListener)

    private class EasyClickableSpan(private val clickListener: View.OnClickListener) : ClickableSpan() {
        override fun onClick(widget: View) {
            clickListener.onClick(widget)
        }
    }
}