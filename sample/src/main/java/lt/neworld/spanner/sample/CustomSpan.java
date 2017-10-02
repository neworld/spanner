package lt.neworld.spanner.sample;

import android.graphics.Typeface;
import android.text.style.StyleSpan;

import lt.neworld.spanner.SpanBuilder;

class CustomSpan implements SpanBuilder {
    @Override
    public Object build() {
        return new StyleSpan(Typeface.BOLD);
    }
}

