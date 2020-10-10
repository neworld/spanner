package lt.neworld.spanner

import android.support.annotation.RequiresApi
import android.text.SpannableStringBuilder
import android.text.TextUtils

class Spanner(text: CharSequence?) : SpannableStringBuilder(text) {
    constructor() : this("")

    override fun append(text: CharSequence?): Spanner {
        text ?: return this

        super.append(text)

        return this
    }

    override fun append(text: CharSequence?, start: Int, end: Int): Spanner {
        super.append(text, start, end)

        return this
    }

    override fun append(text: Char): Spanner {
        super.append(text)

        return this
    }

    override fun insert(where: Int, text: CharSequence?): Spanner {
        text ?: return this

        super.insert(where, text)

        return this
    }

    @RequiresApi(api = 21)
    override fun append(text: CharSequence?, what: Any?, flags: Int): Spanner {
        text ?: return this

        super.append(text, what, flags)

        return this
    }

    override fun replace(start: Int, end: Int, replace: CharSequence?): Spanner {
        replace ?: return this

        super.replace(start, end, replace)

        return this
    }

    override fun replace(start: Int, end: Int, replace: CharSequence?, tbstart: Int, tbend: Int): Spanner {
        replace ?: return this

        super.replace(start, end, replace, tbstart, tbend)

        return this
    }

    override fun delete(start: Int, end: Int): Spanner {
        super.delete(start, end)

        return this
    }

    fun append(text: CharSequence?, vararg spans: Span): Spanner {
        text ?: return this

        val start = length

        append(text)

        setSpans(start, length, *spans)

        return this
    }

    fun append(span: ImageSpan): Spanner {
        val start = length

        append(" ")

        setSpans(start, length, span)

        return this
    }

    fun insert(where: Int, text: CharSequence, vararg spans: Span): Spanner {
        super.insert(where, text)

        setSpans(where, where + text.length, *spans)

        return this
    }

    fun replace(start: Int, end: Int, text: CharSequence?, vararg spans: Span): Spanner {
        val text = text ?: ""

        super.replace(start, end, text)

        setSpans(start, start + text.length, *spans)

        return this
    }

    fun replace(search: CharSequence, replace: CharSequence, vararg spans: Span): Spanner {
        var start: Int

        while (true) {
            start = TextUtils.indexOf(this, search)
            if (start == -1) break
            replace(start, start + search.length, replace, *spans)
        }

        return this
    }

    fun setSpans(start: Int, end: Int, vararg spans: Span): Spanner {
        for (span in spans) {
            setSpan(span.buildSpan(), start, end, 0)
        }
        return this
    }

    fun span(search: CharSequence, vararg spans: Span): Spanner {
        span(0, search, *spans)

        return this
    }

    fun span(search: CharSequence, ignoreCase: Boolean = false, vararg spans: Span): Spanner {
        span(0, search, ignoreCase, *spans)

        return this
    }

    fun span(startIndex: Int, search: CharSequence, vararg spans: Span): Spanner {
        return span(startIndex, search, false, *spans)
    }

    fun span(startIndex: Int, search: CharSequence, ignoreCase: Boolean = false, vararg spans: Span): Spanner {
        if (TextUtils.isEmpty(search)) {
            setSpans(0, length, *spans)
            return this
        }

        val actualSearch = if (ignoreCase) {
            (search.toString() as java.lang.String).toLowerCase()
        } else {
            search
        }

        val actualThis = if (ignoreCase) {
            (toString() as java.lang.String).toLowerCase()
        } else {
            this
        }

        var lastPos: Int = startIndex - 1

        while (true) {
            lastPos = TextUtils.indexOf(actualThis, actualSearch, lastPos + 1)
            if (lastPos == -1) break

            setSpans(lastPos, lastPos + actualSearch.length, *spans)
        }

        return this
    }
}
