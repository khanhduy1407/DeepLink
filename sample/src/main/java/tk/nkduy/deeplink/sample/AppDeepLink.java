package tk.nkduy.deeplink.sample;

import tk.nkduy.deeplink.DeepLinkSpec;

@DeepLinkSpec(prefix = { "app://nkduy" })
public @interface AppDeepLink {
  String[] value();
}

