package tranquil.apps.templet.ui.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import tranquil.apps.templet.R;

/**
 * Created by investo on 24/02/16.
 */

public class circle extends Activity {

    private ImageView imageViewRound;
    private ImageView imageViewOval;
    private ImageView imageViewTriangle;
    private ImageView imageViewHexaGon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitmain);
        imageViewRound = (ImageView) findViewById(R.id.imageView_round);


        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.jm);

        imageViewRound.setImageBitmap(icon);


    }
    }