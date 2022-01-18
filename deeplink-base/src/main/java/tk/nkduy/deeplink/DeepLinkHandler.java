package tk.nkduy.deeplink;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the annotated {@code Activity} will receive deep links and handle them. This
 * will tell DeepLinkDispatch to generate a {@code DeepLinkDelegate} class that forwards the
 * incoming {@code Intent} to the correct Activities annotated with {@link DeepLink}.
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.CLASS)
public @interface DeepLinkHandler {
  /**
   * A list of {@link DeepLinkModule} annotated classes used for collecting all the deep links in
   * an application. The generated {@code DeepLinkDelegate} class will query the provided modules
   * in order to decide which {@code Activity} should receive the incoming deep link.
   */
  Class<?>[] value();

  String ACTION = "tk.nkduy.deeplink.DEEPLINK_ACTION";
  String EXTRA_SUCCESSFUL = "tk.nkduy.deeplink.EXTRA_SUCCESSFUL";
  String EXTRA_URI = "tk.nkduy.deeplink.EXTRA_URI";
  String EXTRA_URI_TEMPLATE = "tk.nkduy.deeplink.EXTRA_URI_TEMPLATE";
  String EXTRA_ERROR_MESSAGE = "tk.nkduy.deeplink.EXTRA_ERROR_MESSAGE";
}
