build: jsinterop
  ./gradlew build

run:
  npx live-server --watch=build/bin/native,index.html

jsinterop:
  /Users/linux_china/.konan/kotlin-native-macos-1.3.50/bin/jsinterop -pkg kotlinx.interop.wasm.dom  -o build/klib/kotlinx.interop.wasm.dom-jsinterop.klib -target wasm32