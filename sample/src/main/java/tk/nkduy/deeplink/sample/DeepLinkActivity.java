package tk.nkduy.deeplink.sample;

import android.app.Activity;
import android.os.Bundle;

import tk.nkduy.deeplink.DeepLinkHandler;
import tk.nkduy.deeplink.sample.benchmarkable.BenchmarkDeepLinkModule;
import tk.nkduy.deeplink.sample.benchmarkable.BenchmarkDeepLinkModuleRegistry;
import tk.nkduy.deeplink.sample.kaptlibrary.KaptLibraryDeepLinkModule;
import tk.nkduy.deeplink.sample.kaptlibrary.KaptLibraryDeepLinkModuleRegistry;
import tk.nkduy.deeplink.sample.library.LibraryDeepLinkModule;
import tk.nkduy.deeplink.sample.library.LibraryDeepLinkModuleRegistry;

import java.util.HashMap;
import java.util.Map;

@DeepLinkHandler({SampleModule.class, LibraryDeepLinkModule.class, BenchmarkDeepLinkModule.class, KaptLibraryDeepLinkModule.class})
public class DeepLinkActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //    Debug.startMethodTracing("deeplink.trace",90000000);
    Map configurablePlaceholdersMap = new HashMap();
    configurablePlaceholdersMap.put("configPathOne", "somePathThree");
    configurablePlaceholdersMap.put("configurable-path-segment-one", "");
    configurablePlaceholdersMap.put("configurable-path-segment", "");
    configurablePlaceholdersMap.put("configurable-path-segment-two", "");
    configurablePlaceholdersMap.put("configPathOne", "somePathOne");
    DeepLinkDelegate deepLinkDelegate = new DeepLinkDelegate(
        new SampleModuleRegistry(), new LibraryDeepLinkModuleRegistry(), new BenchmarkDeepLinkModuleRegistry(), new KaptLibraryDeepLinkModuleRegistry(), configurablePlaceholdersMap);
    deepLinkDelegate.dispatchFrom(this);
    //    Debug.stopMethodTracing();
    finish();
  }
}
