package lanuchapp.test.com.broadcasttoactivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyBroadCast.BRInteraction {

    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvShow = (TextView) findViewById(R.id.tv_show);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        MyBroadCast dianLiangBR = new MyBroadCast();
        registerReceiver(dianLiangBR, intentFilter);
        dianLiangBR.setBRInteractionListener(this);
    }

    @Override
    public void setText(String content) {
        tvShow.setText(content);
    }
}
