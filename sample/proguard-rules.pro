# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/christian/Environment/android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Keep our custom deep links
-keep @interface tk.nkduy.deeplink.sample.AppDeepLink
-keepclasseswithmembers class * {
    @tk.nkduy.deeplink.sample.AppDeepLink <methods>;
}

-keep @interface tk.nkduy.deeplink.sample.WebDeepLink
-keepclasseswithmembers class * {
    @tk.nkduy.deeplink.sample.WebDeepLink <methods>;
}

-keep @interface tk.nkduy.deeplink.sample.WebPlaceholderDeepLink
-keepclasseswithmembers class * {
    @tk.nkduy.deeplink.sample.WebPlaceholderDeepLink <methods>;
}

# Need to keep as we use reflection to read this field to get the type.
-keepclassmembers class tk.nkduy.deeplink.sample.typeconversion.TypeConversionErrorHandlerCustomTypeDeepLinkActivity {
    java.util.List stringList;
}