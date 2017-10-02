package lt.neworld.spanner.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import lt.neworld.spanner.Spanner;
import lt.neworld.spanner.Spans;

public class SampleJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        TextView textView = findViewById(R.id.text);

        textView.setMovementMethod(new LinkMovementMethod());

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_LONG).show();
            }
        };

        Spannable spannable = new Spanner()
                .append("Original text\n\n")
                .append("big\n", Spans.INSTANCE.sizePX(100))
                .append("big in DP\n", Spans.INSTANCE.sizeDP(30))
                .append("50% of original size\n", Spans.INSTANCE.scaleSize(0.5f))
                .append("bold\n", Spans.INSTANCE.bold())
                .append("italic\n", Spans.INSTANCE.italic())
                .append("bold and italic\n", Spans.INSTANCE.boldItalic())
                .append("custom typeface\n", Spans.INSTANCE.font("sans-serif-black"))
                .append("strike through\n", Spans.INSTANCE.strikeThrough())
                .append("underline\n", Spans.INSTANCE.underline())
                .append("background\n", Spans.INSTANCE.background(Color.YELLOW))
                .append("foreground\n", Spans.INSTANCE.foreground(Color.RED))
                .append("subscript\n", Spans.INSTANCE.subscript())
                .append("superscript\n", Spans.INSTANCE.superscript())
                .append(" \n", Spans.INSTANCE.image(getResources().getDrawable(R.drawable.ic_android_16dp)))
                .append("quite\n", Spans.INSTANCE.quote())
                .append("The quick brown fox jumps over the lazy dog\n", Spans.INSTANCE.bold(), Spans.INSTANCE.foreground(0xFF904f1c), Spans.INSTANCE.quote())
                .span("fox", Spans.INSTANCE.foreground(Color.RED))
                .span("dog", Spans.INSTANCE.foreground(Color.RED))
                .append("Custom\n", Spans.INSTANCE.custom(new CustomSpan()))
                .append("Click here\n", Spans.INSTANCE.click(onClickListener))
                .append("http://www.android.com\n", Spans.INSTANCE.url("http://www.android.com"));

        textView.setText(spannable);
    }
}