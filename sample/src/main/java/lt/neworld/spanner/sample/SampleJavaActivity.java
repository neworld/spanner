package lt.neworld.spanner.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.widget.TextView;

import lt.neworld.spanner.Spanner;
import lt.neworld.spanner.Spans;

import static lt.neworld.spanner.Spans.background;
import static lt.neworld.spanner.Spans.bold;
import static lt.neworld.spanner.Spans.boldItalic;
import static lt.neworld.spanner.Spans.font;
import static lt.neworld.spanner.Spans.foreground;
import static lt.neworld.spanner.Spans.image;
import static lt.neworld.spanner.Spans.italic;
import static lt.neworld.spanner.Spans.quote;
import static lt.neworld.spanner.Spans.scaleSize;
import static lt.neworld.spanner.Spans.sizeDP;
import static lt.neworld.spanner.Spans.strikeThrough;
import static lt.neworld.spanner.Spans.subscript;
import static lt.neworld.spanner.Spans.superscript;
import static lt.neworld.spanner.Spans.underline;

public class SampleJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        TextView textView = findViewById(R.id.text);

        // @formatter:off
        Spannable spannable = new Spanner()
                .append("Original text\n\n")
                .append("big\n", Spans.sizePX(100))
                .append("big in DP\n", sizeDP(30))
                .append("50% of original size\n", scaleSize(0.5f))
                .append("bold\n", bold())
                .append("italic\n", italic())
                .append("bold and italic\n", boldItalic())
                .append("custom typeface\n", font("sans-serif-black"))
                .append("strike through\n", strikeThrough())
                .append("underline\n", underline())
                .append("background\n", background(Color.YELLOW))
                .append("foreground\n", foreground(Color.RED))
                .append("subscript\n", subscript())
                .append("superscript\n", superscript())
                .append(" \n", image(getResources().getDrawable(R.drawable.ic_android_16dp)))
                .append("quite\n", Spans.quote())
                .append("The quick brown fox jumps over the lazy dog\n", bold(), foreground(0xFF904f1c), Spans.quote())
                ;
        // @formatter:on

        textView.setText(spannable);
    }
}
