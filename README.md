WebAssembly Demo with Kotlin
============================
WebAssembly demo with Kotlin Multiplatform.

# Features

* DOM operation: jsinterop for wasm32 and API is here https://kotlinlang.org/api/latest/jvm/stdlib/kotlinx.wasm.jsinterop/index.html
* Canvas drawing
* JQuery DSL

# How to run
Please refer justfile.

* Run build:  ./gradlew clean build
* In IDEA, right click index.html and open in Chrome

# Call customized JS functions from WebAssembly

* Create js functions and call konan.libraries.push() to push them into libraries in xxx.wasm.js as following:
```
 konan.libraries.push ({
            knjs__alert: function(textPtr, textLen) {
                  var text = toUTF16String(textPtr, textLen);
                  window.alert(text)
              }
        });
```

* Then create Kotlin stubs for JS functions.
```
fun alert(text: String) {
    knjs__alert(stringPointer(text), stringLengthBytes(text))
}

@SymbolName("knjs__alert")
external fun knjs__alert(textPtr: Int, textLen: Int): Unit

```

# Todo

* XMLHttpRequest and  WebClient for WebAssembly
* More DOM API
* customized JS functions for WebAssembly

# References

* WebAssembly Home: https://webassembly.org/
* Web APIs: https://developer.mozilla.org/en-US/docs/Web/API
* Kotlin Multiplatform Programming: https://kotlinlang.org/docs/reference/multiplatform.html
* WebAssembly Specifications: https://webassembly.github.io/spec/
* wabt: The WebAssembly Binary Toolkit https://github.com/WebAssembly/wabt
