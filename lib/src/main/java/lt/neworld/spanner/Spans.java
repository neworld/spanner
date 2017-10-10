package lt.neworld.spanner;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.support.annotation.ColorInt;
import android.support.annotation.Dimension;
import android.support.annotation.FloatRange;
import android.support.annotation.RequiresApi;
import android.text.Layout;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ClickableSpan;
import android.text.style.DrawableMarginSpan;
import android.text.style.EasyEditSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.IconMarginSpan;
import android.text.style.ImageSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LocaleSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuggestionSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TabStopSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;

import java.util.Locale;

/**
 * @author Andrius Semionovas
 * @since 2017-10-01
 */

public class Spans {
    private Spans() {
        //hide
    }

    public static Span sizePX(@Dimension(unit = Dimension.PX) final int px) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new AbsoluteSizeSpan(px, false);
            }
        });
    }

    public static Span sizeDP(@Dimension(unit = Dimension.DP) final int dp) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new AbsoluteSizeSpan(dp, true);
            }
        });
    }

    public static Span scaleSize(@FloatRange(from = 0.0) final float proportion) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new RelativeSizeSpan(proportion);
            }
        });
    }

    public static Span scaleXSize(@FloatRange(from = 0.0) final float proportion) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new ScaleXSpan(proportion);
            }
        });
    }

    public static Span bold() {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new StyleSpan(Typeface.BOLD);
            }
        });
    }

    public static Span italic() {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new StyleSpan(Typeface.ITALIC);
            }
        });
    }

    public static Span boldItalic() {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new StyleSpan(Typeface.BOLD_ITALIC);
            }
        });
    }

    public static Span font(final String font) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new TypefaceSpan(font);
            }
        });
    }

    public static Span strikeThrough() {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new StrikethroughSpan();
            }
        });
    }

    public static Span underline() {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new UnderlineSpan();
            }
        });
    }

    public static Span background(@ColorInt final int color) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new BackgroundColorSpan(color);
            }
        });
    }

    public static Span foreground(@ColorInt final int color) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new ForegroundColorSpan(color);
            }
        });
    }

    public static Span subscript() {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new SubscriptSpan();
            }
        });
    }

    public static Span superscript() {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new SuperscriptSpan();
            }
        });
    }

    public static Span image(final Drawable drawable) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new ImageSpan(drawable);
            }
        });
    }

    public static Span image(final Drawable drawable, final int verticalAlignment) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new ImageSpan(drawable, verticalAlignment);
            }
        });
    }

    public static Span quote() {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new QuoteSpan();
            }
        });
    }

    public static Span quote(@ColorInt final int color) {
        return new Span(new SpanBuilder() {
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
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new ImageSpan(context, bitmap, verticalAlignment);
            }
        });
    }

    public static Span custom(SpanBuilder builder) {
        return new Span(builder);
    }

    public static Span click(final View.OnClickListener onClickListener) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new ClickableSpan() {
                    @Override
                    public void onClick(View view) {
                        onClickListener.onClick(view);
                    }
                };
            }
        });
    }

    public static Span url(final String url) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new URLSpan(url);
            }
        });
    }

    public static Span center() {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER);
            }
        });
    }

    public static Span alignmentOpposite() {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE);
            }
        });
    }

    public static Span alignmentNormal() {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new AlignmentSpan.Standard(Layout.Alignment.ALIGN_NORMAL);
            }
        });
    }

    public static Span bullet(final int gapWidth, final int color) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new BulletSpan(gapWidth, color);
            }
        });
    }

    public static Span bullet(final int gapWidth) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new BulletSpan(gapWidth);
            }
        });
    }

    public static Span bullet() {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new BulletSpan();
            }
        });
    }

    public static Span imageMargin(final Drawable drawable) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new DrawableMarginSpan(drawable);
            }
        });
    }

    public static Span imageMargin(final Drawable drawable, final int pad) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new DrawableMarginSpan(drawable, pad);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static Span edit(final PendingIntent pendingIntent) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new EasyEditSpan(pendingIntent);
            }
        });
    }

    public static Span imageMargin(final Bitmap image) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new IconMarginSpan(image);
            }
        });
    }

    public static Span imageMargin(final Bitmap image, final int pad) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new IconMarginSpan(image, pad);
            }
        });
    }

    public static Span leadingMargin(final int first, final int rest) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new LeadingMarginSpan.Standard(first, rest);
            }
        });
    }

    public static Span leadingMargin(final int first) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new LeadingMarginSpan.Standard(first);
            }
        });
    }

    public static Span blur(final float radius, final BlurMaskFilter.Blur style) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new MaskFilterSpan(new BlurMaskFilter(radius, style));
            }
        });
    }

    public static Span emboss(final float[] direction, final float ambient, final float specular, final float blurRadius) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new MaskFilterSpan(new EmbossMaskFilter(direction, ambient, specular, blurRadius));
            }
        });
    }

    public static Span tabStop(final int where) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new TabStopSpan.Standard(where);
            }
        });
    }

    public static Span appearance(final Context context, final int appearance) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new TextAppearanceSpan(context, appearance);
            }
        });
    }

    public static Span appearance(final Context context, final int appearance, final int colorList) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new TextAppearanceSpan(context, appearance, colorList);
            }
        });
    }

    public static Span appearance(final String family, final int style, final int size, final ColorStateList color, final ColorStateList linkColor) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new TextAppearanceSpan(family, style, size, color, linkColor);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static Span locale(final Locale locale) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new LocaleSpan(locale);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Span locale(final LocaleList localeList) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new LocaleSpan(localeList);
            }
        });
    }

    public static Span suggestion(final Context context, final String[] suggestions, final int flags) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new SuggestionSpan(context, suggestions, flags);
            }
        });
    }

    public static Span suggestion(final Locale locale, final String[] suggestions, final int flags) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new SuggestionSpan(locale, suggestions, flags);
            }
        });
    }

    public static Span suggestion(final Context context, final Locale locale, final String[] suggestions, final int flags, final Class<?> notificationTargetClass) {
        return new Span(new SpanBuilder() {
            @Override
            public Object build() {
                return new SuggestionSpan(context, locale, suggestions, flags, notificationTargetClass);
            }
        });
    }
}
