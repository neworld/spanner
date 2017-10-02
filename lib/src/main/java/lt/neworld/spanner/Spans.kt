package lt.neworld.spanner

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.Dimension
import android.support.annotation.FloatRange
import android.text.style.*
import android.view.View

/**
 * @author Andrius Semionovas
 * *
 * @since 2017-10-01
 */

object Spans {

    fun sizePX(@Dimension(unit = Dimension.PX) px: Int): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return AbsoluteSizeSpan(px, false)
            }
        })
    }

    fun sizeDP(@Dimension(unit = Dimension.DP) dp: Int): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return AbsoluteSizeSpan(dp, true)
            }
        })
    }

    fun scaleSize(@FloatRange(from = 0.0) proportion: Float): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return RelativeSizeSpan(proportion)
            }
        })
    }

    fun bold(): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return StyleSpan(Typeface.BOLD)
            }
        })
    }

    fun italic(): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return StyleSpan(Typeface.ITALIC)
            }
        })
    }

    fun boldItalic(): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return StyleSpan(Typeface.BOLD_ITALIC)
            }
        })
    }

    fun font(font: String): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return TypefaceSpan(font)
            }
        })
    }

    fun strikeThrough(): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return StrikethroughSpan()
            }
        })
    }

    fun underline(): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return UnderlineSpan()
            }
        })
    }

    fun background(@ColorInt color: Int): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return BackgroundColorSpan(color)
            }
        })
    }

    fun foreground(@ColorInt color: Int): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return ForegroundColorSpan(color)
            }
        })
    }

    fun subscript(): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return SubscriptSpan()
            }
        })
    }

    fun superscript(): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return SuperscriptSpan()
            }
        })
    }

    fun image(drawable: Drawable): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return ImageSpan(drawable)
            }
        })
    }

    fun quote(): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return QuoteSpan()
            }
        })
    }

    fun quote(@ColorInt color: Int): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return QuoteSpan(color)
            }
        })
    }

    @JvmOverloads fun image(context: Context, bitmap: Bitmap, verticalAlignment: Int = ImageSpan.ALIGN_BOTTOM): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return ImageSpan(context, bitmap, verticalAlignment)
            }
        })
    }

    fun custom(builder: SpanBuilder): Span {
        return Span(builder)
    }

    fun click(onClickListener: View.OnClickListener): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return object : ClickableSpan() {
                    override fun onClick(view: View) {
                        onClickListener.onClick(view)
                    }
                }
            }
        })
    }

    fun url(url: String): Span {
        return Span(object : SpanBuilder {
            override fun build(): Any {
                return URLSpan(url)
            }
        })
    }
}