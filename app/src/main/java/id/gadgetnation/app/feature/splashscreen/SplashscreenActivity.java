package id.gadgetnation.app.feature.splashscreen;

import android.content.Intent;
import android.os.Bundle;

import com.bhargavms.dotloader.DotLoader;

import butterknife.BindView;
import id.gadgetnation.app.R;
import id.gadgetnation.app.base.BaseActivity;
import id.gadgetnation.app.feature.MainActivity;

public class SplashscreenActivity extends BaseActivity{

    @BindView(R.id.dotLoader)
    DotLoader dotLoader;

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                next();
            }
        }, 2500);

        dotLoader.postDelayed(new Runnable() {
            @Override
            public void run() {
                dotLoader.setNumberOfDots(4);
            }
        }, 2500);
    }

    private void next() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected int setView() {
        return R.layout.activity_splashscreen;
    }
}
