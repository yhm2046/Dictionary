package com.example.smalt.dictionary;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

/**
 * date：2016.6.16
 *function： 获取本机安装的所有apk的包名列名，并按照字母顺序排列
 * 参考：
 * http://blog.csdn.net/eieihihi/article/details/45956653
 * http://www.cnblogs.com/riskyer/p/3320357.html
 */
public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private String pName,cName;
    private TextView tvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //add by wangp@2016.6.16
        //获取所有应用
        tvShow=(TextView)findViewById(R.id.tvShow);
        tvShow.setMovementMethod(ScrollingMovementMethod.getInstance());
        List<ApplicationInfo> apps = getPackageManager().getInstalledApplications(
                PackageManager.GET_SIGNATURES);
        tvShow.append("本机共有"+apps.size()+"个软件，如下：");
        for(int i=0;i<apps.size();i++)
        {
            pName=apps.get(i).packageName;
            cName=apps.get(i).className;
            tvShow.append("包名："+pName+"\n类名："+cName+"\n");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
