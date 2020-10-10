package lt.neworld.spanner

import android.text.Spannable
import lt.neworld.spanner.Spans.bold
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

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

        builder.append("bar", bold())
        assertEquals("test bar", builder.toString())
        assertSpans("test <StyleSpan>bar</StyleSpan>", builder)

        builder.append(" abc ", 1, 2)
        assertEquals("test bara", builder.toString())
    }

    @Test
    fun insert() {
        val builder = Spanner("ab")

        builder.insert(1, " foo ", bold())
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

        builder.replace(1, 3, "oo", bold())
        assertEquals("foo {replace}", builder.toString())
        assertSpans("f<StyleSpan>oo</StyleSpan> {replace}", builder)

        builder.replace("{replace}", "bar", bold())
        assertEquals("foo bar", builder.toString())

        assertSpans("f<StyleSpan>oo</StyleSpan> <StyleSpan>bar</StyleSpan>", builder)
    }

    @Test
    fun nonExistingReplace() {
        val builder = Spanner("foo bar")

        builder.replace("not exist", "good text", bold())
        assertEquals("foo bar", builder.toString())
        assertSpans("foo bar", builder)
    }

    @Test
    fun appendNull() {
        val builder = Spanner("foo")

        builder.append(null)
        assertEquals("foo", builder.toString())

        builder.append(null, bold())
        assertEquals("foo", builder.toString())
    }

    @Test
    fun replaceWithNull() {
        val builder = Spanner("bar")

        builder.replace(1, 3, null, bold())
        assertEquals("b", builder.toString())
    }

    @Test
    fun span_text() {
        assertSpans("", Spanner().span("", bold()))
        assertSpans("<StyleSpan>foo</StyleSpan>", Spanner().append("foo").span("", bold()))
        assertSpans("foo <StyleSpan>bar</StyleSpan>", Spanner().append("foo bar").span("bar", bold()))
        assertSpans("foo", Spanner().append("foo").span("bar", bold()))
        assertSpans(
                expected = "<StyleSpan>bar</StyleSpan> foo <StyleSpan>bar</StyleSpan>",
                actual = Spanner().append("bar foo bar").span("bar", bold())
        )
    }

    @Test
    fun span_text_ignoreCase() {
        assertSpans(
                expected = "foo <StyleSpan>BAR</StyleSpan>",
                actual = Spanner("foo BAR").span("bar", ignoreCase = true, spans = bold())
        )
        assertSpans("foo", Spanner().append("foo").span("bar", bold()))
        assertSpans(
                expected = "<StyleSpan>bAR</StyleSpan> foo <StyleSpan>Bar</StyleSpan>",
                actual = Spanner().append("bAR foo Bar").span("bar", ignoreCase = true, spans = bold())
        )
    }

    @Test
    fun replace_multiple() {
        val spanner = Spanner("foo bar foo")
                .replace("foo", "bar", bold())

        assertSpans(
                "<StyleSpan>bar</StyleSpan> bar <StyleSpan>bar</StyleSpan>",
                spanner
        )
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