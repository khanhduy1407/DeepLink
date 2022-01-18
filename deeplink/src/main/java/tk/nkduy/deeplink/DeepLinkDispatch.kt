package tk.nkduy.deeplink

import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Configure DeepLinkDispatch, such as for tests.
 */
object DeepLinkDispatch {
    /**
     * Executor for tk.nkduy.deeplink.ValidationUtilsKt.validateConfigurablePathSegmentReplacements
     */
    @JvmStatic
    var validationExecutor: Executor = Executors.newSingleThreadExecutor()
}
