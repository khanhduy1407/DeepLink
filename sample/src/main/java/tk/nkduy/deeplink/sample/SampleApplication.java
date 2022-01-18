package tk.nkduy.deeplink.sample;

import android.app.Application;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import tk.nkduy.deeplink.DeepLinkHandler;

public class SampleApplication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    IntentFilter intentFilter = new IntentFilter(DeepLinkHandler.ACTION);
    LocalBroadcastManager.getInstance(this).registerReceiver(new DeepLinkReceiver(), intentFilter);
  }
}
