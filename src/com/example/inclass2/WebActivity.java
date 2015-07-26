/*********************************
 * InClass #2
 * FileName: WebActivity.java
 *********************************
 * Team Members:
 * Richa Kandlikar
 * Sai Phaninder Reddy Jonnala
 * *******************************
 */

package com.example.inclass2;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		
		WebView wv=(WebView) findViewById(R.id.wvMain);
		wv.getSettings().setJavaScriptEnabled(true);
		wv.setWebViewClient(new WebViewClient(){
			public boolean shouldOverrideUrlLoading(WebView view, String url){
				view.loadUrl(url);
				return false;
			}
		});
		
		if(getIntent().getExtras()!=null){
			String s = getIntent().getExtras().getString("URL");
			Log.d("DEBUG","URL2: "+s);
			wv.loadUrl(s);
		}
	}

}
