[![](https://jitpack.io/v/neworld/spanner.svg)](https://jitpack.io/#neworld/spanner)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Spanner-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/6271)
[![Build Status](https://travis-ci.org/neworld/spanner.svg?branch=master)](https://travis-ci.org/neworld/spanner)

This lib provides simple and fluent API for creating [Android Spannable](https://developer.android.com/reference/android/text/Spannable.html).
Features:
- Simple and fluent API
- Helpers to create spans
- Small method footprint (<200 methods, 28kb AAR package)

This library focuses on building spannable. 
If you prefer put full text first and then apply spans, take a look at [another awesome library](https://github.com/jaychang0917/SimpleText)

#### Examples:

```java
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
        .append(" \n", image(getResources().getDrawable(R.drawable.ic_android_16dp)))
        .append("quite\n", quote())
        .append("The quick brown fox jumps over the lazy dog\n", bold(), foreground(0xFF904f1c), Spans.quote())
        .append("Custom\n", custom(new CustomSpan()))
        .append("Click here\n", click(onClickListener))
        .append("http://www.android.com\n", url("http://www.android.com"))
        ;
```

It looks like:

![preview](https://i.imgur.com/SRnNRdm.png?1)

You can manipulate text in many more ways:
```java
Spannable spannable = new Spanner("The quick brown fox jumps over the lazy dog")
        .span("fox", foreground(Color.RED)) // search and span by given text
        .replace("dog", "cat", strikeThrough()) // any number of spans
        .insert(5, "foo", bold(), italic()) // any number of spans
        .append("bar", underline()); // any number of spans
```

If you need custom span, you need span builder:
```
//java 7
Spannable spannable = new Spanner("The quick brown fox jumps over the lazy dog")
        .span("fox", custom(new SpanBuilder() {
                 @Override
                 public Object build() {
                     return new StyleSpan(Typeface.ITALIC);
                 }
             });
             
//java 8
Spannable spannable = new Spanner("The quick brown fox jumps over the lazy dog")
        .span("fox", custom(() -> new StyleSpan(Typeface.ITALIC));
        
//kotlin
val spannable = Spanner("The quick brown fox jumps over the lazy dog")
        .span("fox", custom { StyleSpan(Typeface.ITALIC) })
```

#### Reference

Spans:

|                         |                         |                       |
| ---                     | ---                     | ---                   |
| sizePx(int)             | background(int color)   | center()              |
| sizeDP(int)             | foreground(int color)   | alignmentOpposite()   |
| scaleSize(float)        | subscript()             | alignmentNormal()     |
| bold()                  | superscript()           | bullet(...)           |
| italic()                | image(...)              | imageMargin(...)      |
| boldItalic()            | click(listener)         | leadingMargin(...)    |
| font(String)            | url(url)                | edit(...)             |
| strikeThrough()         | custom(spanBuilder)     | emboss(...)           |
| underline()             | quote()                 | blur(...)             |
| tabStop(where)          | appearance(...)         | locale(...)           |
| suggestion(...)         |                         |                       |

Text manipulation:

| Methods                           | Description                                    |
| ---------------                   | ---------------------------                    |
| append(text, spans...)            | appends text                                   |
| replace(search, replace, spans...)| search and replace text                        |
| span(search, spans...)            | search text and apply spans                    |
| insert(pos, text, spans...)       | instert given text in given position           |

#### How to use
```
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
	
    dependencies {
        compile 'lt.neworld:spanner:v0.3.1'
    }
```

#### License

```
Copyright 2017 Andrius Semionovas

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```