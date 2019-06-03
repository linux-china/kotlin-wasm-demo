/**
 * JQuery DSL for Kotlin
 *
 * @author leijuan
 */
import kotlinx.interop.wasm.dom.document
import kotlinx.wasm.jsinterop.JsValue
import kotlinx.wasm.jsinterop.KtFunction
import kotlinx.wasm.jsinterop.setter

/**
 * HTML Tag
 */
open class HTMLTag(wrapperJsValue: JsValue) : JsValue(wrapperJsValue.arena, wrapperJsValue.index) {
    fun html(html: String) = setter("innerHTML", html)
    fun text(text: String) = setter("innerText", text)
    fun attr(name: String) = getProperty(name).toString()
    fun attr(name: String, value: String) = setter(name, value)
}

//jquery api
fun jq(selector: String): JsValue {
    val id = if (selector.startsWith("#")) selector.substring(1) else selector
    return document.getElementById(id)
}

// JsValue extension methods
fun JsValue.asTag() = HTMLTag(this)

fun JsValue.onclick(lambda: KtFunction<Unit>) = setter("onclick", lambda)
fun JsValue.onmousedown(lambda: KtFunction<Unit>) = setter("onmousedown", lambda)
fun JsValue.onmouseup(lambda: KtFunction<Unit>) = this.setter("onmouseup", lambda)
fun JsValue.onmousemove(lambda: KtFunction<Unit>) = this.setter("onmousemove", lambda)

