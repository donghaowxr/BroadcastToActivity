package lanuchapp.test.com.broadcasttoactivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by donghao on 2017/3/8.
 */

public class MyBroadCast extends BroadcastReceiver {
    private BRInteraction brInteraction;
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        //获取当前电量
        int current = bundle.getInt("level");
        //获取总电量（电池的电池容量）
        int total = bundle.getInt("scale");
        brInteraction.setText("当前电量：" + current + ",总电量：" + total);
    }

    public interface BRInteraction {
        public void setText(String content);
    }

    public void setBRInteractionListener(BRInteraction brInteraction) {
        this.brInteraction = brInteraction;
    }
}
