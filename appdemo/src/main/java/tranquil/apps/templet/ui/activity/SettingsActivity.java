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

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;



import tranquil.apps.templet.R;

public class SettingsActivity extends AppCompatActivity{

    Button btnOK;
    EditText txtTo,br;
    EditText txtSubject;
    EditText txtMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);

        TextView mTxtTitle = (TextView) findViewById(R.id.txtTitle);
        mTxtTitle.setText(getString(R.string.Not));

        ActionBar actionBar = getSupportActionBar();
        btnOK = (Button) findViewById(R.id.btnOK);
        txtTo = (EditText) findViewById(R.id.etTo);
        br=(EditText)findViewById(R.id.editText);
        txtTo.requestFocus();
        txtSubject = (EditText) findViewById(R.id.etSubject);
        txtMessage = (EditText) findViewById(R.id.etMessage);
        btnOK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String to = "qlcev2k16@gmail.com";
                String subject="Registration";
                String Name=txtTo.getText().toString();
                String Event  = txtSubject.getText().toString();
                String College = txtMessage.getText().toString();

                    String Branch = br.getText().toString();
               // if(Name!=null&&Event!=""&&College!=""&&Branch!="") {
                    Intent mail = new Intent(Intent.ACTION_SEND);
                    mail.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                    mail.putExtra(Intent.EXTRA_SUBJECT, subject);
                    mail.putExtra(Intent.EXTRA_TEXT, "Name : " + Name + "\n" + "Event :" + Event + "\n" + "College :" + College + "\n" + "Branch & Sem :" + Branch);
                    mail.setType("message/rfc822");
                    startActivity(Intent.createChooser(mail, "Send email via:"));
                }
           // }
        });


        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
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
