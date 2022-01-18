package tk.nkduy.deeplink.sample.typeconversion

import android.content.Context
import android.util.Log
import tk.nkduy.deeplink.DeepLink
import tk.nkduy.deeplink.handler.DeepLinkHandler
import tk.nkduy.deeplink.handler.DeepLinkParamType
import tk.nkduy.deeplink.handler.DeeplinkParam

const val TAG = "DeepLinkTypeConversion"

@DeepLink("http://testing.com/typeConversion/{number}/{color}")
object TypeConversionTestDeepLinkHandler : DeepLinkHandler<TypeConversionTestArgs> {
    override fun handleDeepLink(context: Context, deepLinkArgs: TypeConversionTestArgs) {
        Log.d(TAG, "TypeConversionTestDeepLinkHandler with $deepLinkArgs")
    }
}

@DeepLink("http://testing.com/typeConversionParameter/{number}/{list}")
object TypeConversionTestWihtParametrizedTypeDeepLinkHandler : DeepLinkHandler<TypeConversionTestParametrizedArgs> {
    override fun handleDeepLink(context: Context, deepLinkArgs: TypeConversionTestParametrizedArgs) {
        Log.d(TAG, "TypeConversionTestWihtParametrizedTypeDeepLinkHandler with $deepLinkArgs")
    }
}

data class TypeConversionTestParametrizedArgs(
    @DeeplinkParam(name = "number", type = DeepLinkParamType.Path)val number: Long,
    @DeeplinkParam(name = "list", type = DeepLinkParamType.Path)val list: List<String>
)

data class TypeConversionTestArgs(
    @DeeplinkParam(name = "number", type = DeepLinkParamType.Path)val number: Long,
    @DeeplinkParam(name = "color", type = DeepLinkParamType.Path)val color: ComparableColorDrawable
)
