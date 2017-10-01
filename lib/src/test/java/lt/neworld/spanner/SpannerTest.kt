package lt.neworld.spanner

import android.graphics.Typeface
import android.text.Spannable
import android.text.TextUtils
import android.text.style.StyleSpan
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.lang.StringBuilder

/**
 * @author Andrius Semionovas
 * @since 2017-08-01
 */
@RunWith(RobolectricTestRunner::class)
class SpannerTest {
    @Test
    fun init() {
        var builder = Spanner()
        assertEquals("", builder.toString())

        builder = Spanner("test")
        assertEquals("test", builder.toString())
    }

    @Test
    fun append() {
        val builder = Spanner("test ")
        builder.append("foo")
        assertEquals("test foo", builder.toString())

        builder.append(' ')
        assertEquals("test foo ", builder.toString())

    }

    @Test
    fun append_withSpan() {
        val builder = Spanner("test ")

        val span = StyleSpan(Typeface.NORMAL)
        builder.append("bar", span)
        assertEquals("test bar", builder.toString())
        assertArrayEquals(arrayOf(span), builder.getSpans())
        assertSpans("test <StyleSpan>bar</StyleSpan>", builder)

        builder.append(" abc ", 1, 2)
        assertEquals("test bara", builder.toString())
    }

    @Test
    fun insert() {
        val builder = Spanner("ab")

        val span = StyleSpan(Typeface.NORMAL)
        builder.insert(1, " foo ", span)
        assertEquals("a foo b", builder.toString())
        assertSpans("a<StyleSpan> foo </StyleSpan>b", builder)

        builder.insert(1, " bar")
        assertEquals("a bar foo b", builder.toString())

        builder.insert(1, "abc", 1, 2)
        assertEquals("ab bar foo b", builder.toString())
    }

    @Test
    fun replace() {
        val builder = Spanner("faa {replace}")

        var span = StyleSpan(Typeface.NORMAL)
        builder.replace(1, 3, "oo", span)
        assertEquals("foo {replace}", builder.toString())
        assertSpans("f<StyleSpan>oo</StyleSpan> {replace}", builder)

        span = StyleSpan(Typeface.NORMAL)
        builder.replace("{replace}", "bar", span)
        assertEquals("foo bar", builder.toString())

        assertSpans("f<StyleSpan>oo</StyleSpan> <StyleSpan>bar</StyleSpan>", builder)
    }

    @Test
    fun nonExistingReplace() {
        val builder = Spanner("foo bar")

        builder.replace("not exist", "good text", StyleSpan(Typeface.NORMAL))
        assertEquals("foo bar", builder.toString())
        assertSpans("foo bar", builder)
    }

    @Test
    fun appendNull() {
        val builder = Spanner("foo")

        builder.append(null)
        assertEquals("foo", builder.toString())

        builder.append(null, StyleSpan(Typeface.NORMAL))
        assertEquals("foo", builder.toString())
    }

    @Test
    fun replaceWithNull() {
        val builder = Spanner("bar")

        builder.replace(1, 3, null, StyleSpan(Typeface.NORMAL))
        assertEquals("b", builder.toString())
    }

    fun assertSpans(expected: String, actual: Spanner) {
        assertEquals(expected, actual.debugSpans())
    }

    fun Spannable.debugSpans(): String {
        val all = getSpans()

        val debugText = StringBuilder(toString())

        var delta = 0

        fun insert(index: Int, text: CharSequence) {
            debugText.insert(index + delta, text)
            delta += text.length
        }

        all.forEach {
            val start = getSpanStart(it)
            val end = getSpanEnd(it)
            val name = it.javaClass.simpleName

            insert(start, "<$name>")
            insert(end, "</$name>")
        }

        return debugText.toString()
    }

    fun Spannable.getSpans() = getSpans(0, length - 1)

    fun Spannable.getSpans(start: Int, end: Int) = getSpans(start, end, Any::class.java)!!
}