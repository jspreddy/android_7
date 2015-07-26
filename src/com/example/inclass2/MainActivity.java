/*********************************
 * InClass #2
 * FileName: MainActivity.java
 *********************************
 * Team Members:
 * Richa Kandlikar
 * Sai Phaninder Reddy Jonnala
 * *******************************
 */


package com.example.inclass2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button btnGo;
	RadioGroup rgMain;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rgMain= (RadioGroup) findViewById(R.id.rgMain);
		
		for(int i=0;i<Data.NEWS.size();i++){
			RadioButton rb=new RadioButton(this);
			rb.setText(Data.NEWS.get(i).title);
			rb.setId(i);
			rgMain.addView(rb);
		}
		
		btnGo=(Button) findViewById(R.id.btnGo);
		btnGo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d("DEBUG","btnClicked");
				int checkedId=rgMain.getCheckedRadioButtonId();
				if(checkedId==-1){
					Log.d("DEBUG","Nothing checked");
					Context context = getApplicationContext();
					CharSequence text = "Please select one of the above.";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
				else{
					Log.d("DEBUG","checked: "+checkedId);
					Intent i = new Intent(MainActivity.this, WebActivity.class);
					String url=Data.NEWS.get(checkedId).url;
					i.putExtra("URL", url);
					Log.d("DEBUG","URL: "+url);
					startActivity(i);
				}
			}
		});
		
	}

}
