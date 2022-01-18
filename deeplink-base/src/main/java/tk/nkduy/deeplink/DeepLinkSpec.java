package tk.nkduy.deeplink;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Declare a specification for a type of DeepLink. For example:
 * <pre><code>
 * {@literal @}DeepLinkSpec(
 *    prefix = { "http://example.com", "https://example.com" })
 *  public{@literal @}interface WebDeepLink {
 *    String[] value();
 *  }
 * </code></pre>
 * <p>
 * <code>{@literal @}WebDeepLink({ "/foo", "/bar" })</code> will match any of
 * <ul>
 * <li>http://example.com/foo</li>
 * <li>https://example.com/foo</li>
 * <li>http://example.com/bar</li>
 * <li>https://example.com/bar</li>
 * </ul>
 */
@Target({ ElementType.ANNOTATION_TYPE })
// When using tools like Dexguard we require these annotations to still be inside the .dex files
// produced by D8 but because of this bug https://issuetracker.google.com/issues/168524920 they
// are not so we need to mark them as RetentionPolicy.RUNTIME.
@Retention(RetentionPolicy.RUNTIME)
public @interface DeepLinkSpec {
   String[] prefix();
}
