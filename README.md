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
