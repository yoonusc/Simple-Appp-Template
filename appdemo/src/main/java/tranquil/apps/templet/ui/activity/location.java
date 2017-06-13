/*
 * Copyright 2015 Rudson Lima
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tranquil.apps.templet.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.net.Uri;
import android.widget.TextView;

import tranquil.apps.templet.R;

public class location extends AppCompatActivity implements View.OnClickListener{
    Button btnOK,pric,a,b;
    EditText txtTo,br;
    EditText txtSubject;
    EditText txtMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loca);

       /* TextView mTxtTitle = (TextView) findViewById(R.id.txtTitle);
        mTxtTitle.setText(getString(R.string.Not));*/
        pric = (Button) findViewById(R.id.button);
        a = (Button) findViewById(R.id.button2);
        b = (Button) findViewById(R.id.button3);
        TextView like = (TextView) findViewById(R.id.textView11);
        TextView web = (TextView) findViewById(R.id.textView12);
        pric.setOnClickListener(this);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        like.setOnClickListener(this);
        web.setOnClickListener(this);

        WebView wb=(WebView)findViewById(R.id.webView3);
        wb.setVerticalScrollBarEnabled(false);
        wb.setBackgroundColor(0X00FFFFFF);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.setWebViewClient(new WebViewClient());
        wb.loadUrl("https://www.google.com/maps/place/College+of+Engineering+Vadakara/@11.5640194,75.6508209,16z/data=!4m2!3m1!1s0x0000000000000000:0x358dba59247ac6b5?hl=en");







        ActionBar actionBar = getSupportActionBar();



        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

    }

    @Override
    public void onClick(View v) {

   switch (v.getId()) {
       case R.id.button:

           Intent intent = new Intent(Intent.ACTION_DIAL);
           intent.setData(Uri.parse("tel:9447235325"));
           startActivity(intent);
           break;

       case R.id.button2:
            intent = new Intent(Intent.ACTION_DIAL);
           intent.setData(Uri.parse("tel:9496352651"));
           startActivity(intent);
           break;
       case R.id.button3:
           intent = new Intent(Intent.ACTION_DIAL);
           intent.setData(Uri.parse("tel:9961115099"));
           startActivity(intent);
           break;
       case R.id.textView11:
           String url = "http://www.facebook.com/ql2k16";
           Intent i = new Intent(Intent.ACTION_VIEW);
           i.setData(Uri.parse(url));
           startActivity(i);
           break;
       case R.id.textView12:
           String url2 = "http://www.qlcev.com";
           Intent i2 = new Intent(Intent.ACTION_VIEW);
           i2.setData(Uri.parse(url2));
           startActivity(i2);
           break;



   }

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
