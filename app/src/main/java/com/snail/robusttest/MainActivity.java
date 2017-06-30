package com.snail.robusttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.meituan.robust.Patch;
import com.meituan.robust.PatchExecutor;
import com.meituan.robust.RobustCallBack;
import com.meituan.robust.patch.RobustModify;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private TextView mResultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResultTxt = (TextView) findViewById(R.id.textView);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PatchExecutor(getApplicationContext(),
                        new PatchManipulateImp(), new RobustCallBack() {
                    @Override
                    public void onPatchListFetched(boolean result, boolean isNet) {
                        Log.d(TAG, "onPatchListFetched() called with: result = [" + result + "], isNet = [" + isNet + "]");
                    }

                    @Override
                    public void onPatchFetched(boolean result, boolean isNet, Patch patch) {
                        Log.d(TAG, "onPatchFetched() called with: result = [" + result + "], isNet = [" + isNet + "], patch = [" + patch + "]");
                    }

                    @Override
                    public void onPatchApplied(boolean result, Patch patch) {
                        Log.d(TAG, "onPatchApplied() called with: result = [" + result + "], patch = [" + patch + "]");
                        mResultTxt.setText("result-->"+result);
                    }

                    @Override
                    public void logNotify(String log, String where) {
                        Log.d(TAG, "logNotify() called with: log = [" + log + "], where = [" + where + "]");
                    }

                    @Override
                    public void exceptionNotify(Throwable throwable, String where) {
                        Log.d(TAG, "exceptionNotify() called with: throwable = [" + throwable + "], where = [" + where + "]");
                    }
                }).start();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RobustActivity.class));
            }
        });

    }
}
