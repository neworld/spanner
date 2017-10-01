package lt.neworld.spanner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Dimension;
import android.support.annotation.FloatRange;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;

/**
 * @author Andrius Semionovas
 * @since 2017-10-01
 */

public class Spans {
    private Spans() {
        //hide
    }

    public static Span sizePX(@Dimension(unit = Dimension.PX) final int px) {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new AbsoluteSizeSpan(px, false);
            }
        });
    }

    public static Span sizeDP(@Dimension(unit = Dimension.DP) final int dp) {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new AbsoluteSizeSpan(dp, true);
            }
        });
    }

    public static Span scaleSize(@FloatRange(from = 0.0) final float proportion) {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new RelativeSizeSpan(proportion);
            }
        });
    }

    public static Span bold() {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new StyleSpan(Typeface.BOLD);
            }
        });
    }

    public static Span italic() {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new StyleSpan(Typeface.ITALIC);
            }
        });
    }

    public static Span boldItalic() {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new StyleSpan(Typeface.BOLD_ITALIC);
            }
        });
    }

    public static Span font(final String font) {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new TypefaceSpan(font);
            }
        });
    }

    public static Span strikeThrough() {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new StrikethroughSpan();
            }
        });
    }

    public static Span underline() {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new UnderlineSpan();
            }
        });
    }

    public static Span background(@ColorInt final int color) {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new BackgroundColorSpan(color);
            }
        });
    }

    public static Span foreground(@ColorInt final int color) {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new ForegroundColorSpan(color);
            }
        });
    }

    public static Span subscript() {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new SubscriptSpan();
            }
        });
    }

    public static Span superscript() {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new SuperscriptSpan();
            }
        });
    }

    public static Span image(final Drawable drawable) {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new ImageSpan(drawable);
            }
        });
    }

    public static Span quote() {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new QuoteSpan();
            }
        });
    }

    public static Span quote(@ColorInt final int color) {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new QuoteSpan(color);
            }
        });
    }

    public static Span image(Context context, Bitmap bitmap) {
        return image(context, bitmap, ImageSpan.ALIGN_BOTTOM);
    }

    public static Span image(final Context context, final Bitmap bitmap, final int verticalAlignment) {
        return new Span(new SpanBuilder<Object>() {
            @Override
            public Object build() {
                return new ImageSpan(context, bitmap, verticalAlignment);
            }
        });
    }
}
