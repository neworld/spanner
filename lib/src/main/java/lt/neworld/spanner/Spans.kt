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

/**
 * @author Andrius Semionovas
 * @since 2017-08-01
 */


fun sizePX(@Dimension(unit = Dimension.PX) dp: Int) = AbsoluteSizeSpan(dp, false)

fun sizeDP(@Dimension(unit = Dimension.DP) dp: Int) = AbsoluteSizeSpan(dp, true)

fun scaleSize(@FloatRange(from = 0.0) proportion: Float) = RelativeSizeSpan(proportion)

fun bold() = StyleSpan(Typeface.BOLD)

fun italic() = StyleSpan(Typeface.ITALIC)

fun boldItalic() = StyleSpan(Typeface.BOLD_ITALIC)

fun font(font: String) = TypefaceSpan(font)

fun strikeThrough() = StrikethroughSpan()

fun underline() = UnderlineSpan()

fun background(@ColorInt color: Int) = BackgroundColorSpan(color)

fun foreground(@ColorInt color: Int) = ForegroundColorSpan(color)

fun subscript() = SubscriptSpan()

fun superscript() = SuperscriptSpan()

@JvmOverloads
fun image(context: Context, bitmap: Bitmap, verticalAlignment: Int = ImageSpan.ALIGN_BOTTOM) = ImageSpan(context, bitmap, verticalAlignment)

fun image(drawable: Drawable) = ImageSpan(drawable)

fun quite() = QuoteSpan()

fun quite(@ColorInt color: Int) = QuoteSpan(color)