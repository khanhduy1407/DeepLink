package tk.nkduy.deeplink.sample.library;

import tk.nkduy.deeplink.DeepLinkSpec;

@DeepLinkSpec(prefix = { "library://dld" })
public @interface LibraryDeepLink {
    String[] value();
}
