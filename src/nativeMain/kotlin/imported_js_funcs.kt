/**
 * imported JS functions
 *
 * @author linux_china
 */
import kotlinx.wasm.jsinterop.stringLengthBytes
import kotlinx.wasm.jsinterop.stringPointer

fun alert(text: String) {
    knjs__alert(stringPointer(text), stringLengthBytes(text))
}

@SymbolName("knjs__alert")
external fun knjs__alert(textPtr: Int, textLen: Int): Unit
