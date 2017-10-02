package lt.neworld.spanner.sample

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.TextView
import android.widget.Toast
import lt.neworld.spanner.Spanner
import lt.neworld.spanner.Spans

class SampleKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        val textView = findViewById<TextView>(R.id.text)

        textView.movementMethod = LinkMovementMethod()

        val onClickListener = View.OnClickListener { view -> Toast.makeText(view.context, "Clicked", Toast.LENGTH_LONG).show() }

        val spannable = Spanner()
                .append("Original text\n\n")
                .append("big\n", Spans.sizePX(100))
                .append("big in DP\n", Spans.sizeDP(30))
                .append("50% of original size\n", Spans.scaleSize(0.5f))
                .append("bold\n", Spans.bold())
                .append("italic\n", Spans.italic())
                .append("bold and italic\n", Spans.boldItalic())
                .append("custom typeface\n", Spans.font("sans-serif-black"))
                .append("strike through\n", Spans.strikeThrough())
                .append("underline\n", Spans.underline())
                .append("background\n", Spans.background(Color.YELLOW))
                .append("foreground\n", Spans.foreground(Color.RED))
                .append("subscript\n", Spans.subscript())
                .append("superscript\n", Spans.superscript())
                .append(" \n", Spans.image(resources.getDrawable(R.drawable.ic_android_16dp)))
                .append("quite\n", Spans.quote())
                .append("The quick brown fox jumps over the lazy dog\n", Spans.bold(), Spans.foreground(0xFF904f1c.toInt()), Spans.quote())
                .span("fox", Spans.foreground(Color.RED))
                .span("dog", Spans.foreground(Color.RED))
                .append("Custom\n", Spans.custom(CustomSpan()))
                .append("Click here\n", Spans.click(onClickListener))
                .append("http://www.android.com\n", Spans.url("http://www.android.com"))

        textView.text = spannable
    }
}
