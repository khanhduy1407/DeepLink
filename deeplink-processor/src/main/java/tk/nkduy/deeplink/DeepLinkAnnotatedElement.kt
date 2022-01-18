package tk.nkduy.deeplink

import androidx.room.compiler.processing.XElement
import androidx.room.compiler.processing.XMemberContainer
import androidx.room.compiler.processing.XMethodElement
import androidx.room.compiler.processing.XTypeElement
import java.net.MalformedURLException

sealed class DeepLinkAnnotatedElement @Throws(MalformedURLException::class) constructor(
    val uri: String,
    val element: XElement,
    val annotatedClass: XMemberContainer
) {
    class MethodAnnotatedElement(uri: String, element: XMethodElement) : DeepLinkAnnotatedElement(uri, element, element.enclosingElement) {
        val method = element.name
    }

    class ActivityAnnotatedElement(uri: String, element: XTypeElement) : DeepLinkAnnotatedElement(uri, element, element)

    class HandlerAnnotatedElement(uri: String, element: XTypeElement) : DeepLinkAnnotatedElement(uri, element, element)

    init {
        DeepLinkUri.parseTemplate(uri)
            ?: throw MalformedURLException("Malformed Uri Template: $uri")
    }
}
