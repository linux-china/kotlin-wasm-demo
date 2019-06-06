/**
 * imported JS functions
 *
 * @author linux_china
 */
import kotlinx.wasm.jsinterop.*

fun alert(text: String) {
    knjs__alert(stringPointer(text), stringLengthBytes(text))
}

@SymbolName("knjs__alert")
external fun knjs__alert(textPtr: Int, textLen: Int): Unit


@SymbolName("Konan_js_getStringChar")
external fun getStringChar(arena: Arena, obj: Object, index: Int): Int

open class JsString(arena: Arena, index: Object) : JsValue(arena, index) {
    constructor(jsValue: JsValue) : this(jsValue.arena, jsValue.index)

    fun getString(): String {
        val length = this.getInt("length")
        var result = ""
        for (i in 0..length - 1) {
            result += getStringChar(arena, index, i).toChar()
        }
        return result;
    }
}