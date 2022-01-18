package tk.nkduy.deeplink

import tk.nkduy.deeplink.MetadataMasks.ComponentTypeHostMask
import tk.nkduy.deeplink.MetadataMasks.ComponentTypePathSegmentMask
import tk.nkduy.deeplink.MetadataMasks.ComponentTypeRootMask
import tk.nkduy.deeplink.MetadataMasks.ComponentTypeSchemeMask
import tk.nkduy.deeplink.NodeMetadata.Companion.isComponentTypeHost
import tk.nkduy.deeplink.NodeMetadata.Companion.isComponentTypePathSegment
import tk.nkduy.deeplink.NodeMetadata.Companion.isComponentTypeRoot
import tk.nkduy.deeplink.NodeMetadata.Companion.isComponentTypeScheme
import tk.nkduy.deeplink.base.MatchIndex

/**
 * Used to categorize a DeepLinkUri's components into the types: scheme, host, and path.
 *
 * All operations are happening on the UI thread by definition so it is ok to make the lazies
 * not thread safe for speed improvement.
 */
class SchemeHostAndPath(val uri: DeepLinkUri) {

    val matchList: List<UrlElement> = listOf(
        UrlElement(ComponentTypeRootMask, MatchIndex.ROOT_VALUE.toByteArray()),
        UrlElement(ComponentTypeSchemeMask, uri.scheme().toByteArray()),
        UrlElement(ComponentTypeHostMask, uri.encodedHost().toByteArray())
    ) + uri.encodedPathSegments().map { pathSegment ->
        UrlElement(ComponentTypePathSegmentMask, pathSegment.toByteArray())
    }
}

class UrlElement(val typeFlag: Byte, val value: ByteArray) {

    /**
     * This is for debugging, it's actually not called at runtime
     */
    override fun toString(): String {
        return "Type: ${typeToString()}, Value: ${String(value)}"
    }

    private fun typeToString(): String = when {
        isComponentTypeRoot(typeFlag) -> "root"
        isComponentTypeScheme(typeFlag) -> "scheme"
        isComponentTypeHost(typeFlag) -> "host"
        isComponentTypePathSegment(typeFlag) -> "path_segment"
        else -> "unknown"
    }
}
