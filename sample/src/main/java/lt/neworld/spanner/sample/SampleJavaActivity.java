package lt.neworld.spanner.sample;

import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.LocaleList;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import lt.neworld.spanner.SpanBuilder;
import lt.neworld.spanner.Spanner;
import lt.neworld.spanner.Spans;

import static lt.neworld.spanner.Spans.*;

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
        Drawable drawable = getResources().getDrawable(R.drawable.ic_android_16dp);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth() * 2, drawable.getIntrinsicHeight() * 2);

        // @formatter:off
        Spannable spannable = new Spanner()
                .append("Original text\n\n")
                .append("Big and blurry\n", Spans.sizePX(100))
                .span("blurry", blur(5.0f, BlurMaskFilter.Blur.SOLID))
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
                .append("Image with custom bounds: ").append(image(drawable)).append("\n")
                .append("Image from resources: ").append(image(this, R.drawable.ic_android_16dp)).append("\n")
                .append("quite\n", quote())
                .append("The quick brown fox jumps over the lazy dog\n", bold(), foreground(0xFF904f1c), Spans.quote())
                .span("fox", foreground(Color.RED))
                .span("dog", foreground(Color.RED))
                .append("Custom\n", custom(new CustomSpan()))
                .append("Click here\n", click(onClickListener))
                .append("http://www.android.com\n", url("http://www.android.com"))
                ;
        // @formatter:on

        textView.setText(spannable);
    }
}

class CustomSpan implements SpanBuilder {
    @Override
    public Object build() {
        return new StyleSpan(Typeface.BOLD);
    }
}

