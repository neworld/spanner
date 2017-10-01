@file:JvmName("Spans")

package lt.neworld.spanner

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.Dimension
import android.support.annotation.FloatRange
import android.text.style.*
import lt.neworld.spanner.internal.Function0

/**
 * @author Andrius Semionovas
 * @since 2017-08-01
 */

fun sizePX(@Dimension(unit = Dimension.PX) dp: Int) = Span(Function0 { AbsoluteSizeSpan(dp, false) })

fun sizeDP(@Dimension(unit = Dimension.DP) dp: Int) = Span(Function0 { AbsoluteSizeSpan(dp, true) })

fun scaleSize(@FloatRange(from = 0.0) proportion: Float) = Span(Function0 { RelativeSizeSpan(proportion) })

fun bold() = Span(Function0 { StyleSpan(Typeface.BOLD) })

fun italic() = Span(Function0 { StyleSpan(Typeface.ITALIC) })

fun boldItalic() = Span(Function0 { StyleSpan(Typeface.BOLD_ITALIC) })

fun font(font: String) = Span(Function0 { TypefaceSpan(font) })

fun strikeThrough() = Span(Function0 { StrikethroughSpan() })

fun underline() = Span(Function0 { UnderlineSpan() })

fun background(@ColorInt color: Int) = Span(Function0 { BackgroundColorSpan(color) })

fun foreground(@ColorInt color: Int) = Span(Function0 { ForegroundColorSpan(color) })

fun subscript() = Span(Function0 { SubscriptSpan() })

fun superscript() = Span(Function0 { SuperscriptSpan() })

@JvmOverloads
fun image(context: Context, bitmap: Bitmap, verticalAlignment: Int = ImageSpan.ALIGN_BOTTOM): Span {
    return Span(Function0 { ImageSpan(context, bitmap, verticalAlignment) })
}

fun image(drawable: Drawable) = Span(Function0 { ImageSpan(drawable) })

fun quote() = Span(Function0 { QuoteSpan() })

fun quote(@ColorInt color: Int) = Span(Function0 { QuoteSpan(color) })