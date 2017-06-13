package tranquil.apps.templet.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import tranquil.apps.templet.R;


public class splas extends Activity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            setContentView(R.layout.spl);

            Thread timer = new Thread(){
                public void run(){
                    try{
                        sleep(3000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }finally{
                        Intent openMainActivity= new Intent(splas.this,MainActivity.class);
                        startActivity(openMainActivity);
                    }
                }
            };
            timer.start();
        }

        @Override
        protected void onPause() {
            // TODO Auto-generated method stub
            super.onPause();
            finish();
        }

    }
