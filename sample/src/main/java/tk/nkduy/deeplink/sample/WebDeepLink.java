package tk.nkduy.deeplink.sample;

import tk.nkduy.deeplink.DeepLinkSpec;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@DeepLinkSpec(prefix = { "http://nkduy.tk", "https://nkduy.tk" })
// When using tools like Dexguard we require these annotations to still be inside the .dex files
// produced by D8 but because of this bug https://issuetracker.google.com/issues/168524920 they
// are not so we need to mark them as RetentionPolicy.RUNTIME.
@Retention(RetentionPolicy.RUNTIME)
public @interface WebDeepLink {
  String[] value();
}
