package tk.nkduy.deeplink;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Register a class or method to handle a deep link.
 * <pre><code>
 * {@literal @}DeepLink(uri);
 * </code></pre>
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.CLASS)
public @interface Test {
  String IS_DEEP_LINK = "is_deep_link_flag";
  String URI = "deep_link_uri";
  String REFERRER_URI = "android.intent.extra.REFERRER";

  int value();
}
