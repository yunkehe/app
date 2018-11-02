package tk.yunheke.whereismycar;

import android.content.Context;
import android.content.Intent;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg;
    final String TAG = "TAG";
    private Button btn1;
    private Button btn2;
    private Context Mcontext;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "MainActivity --> onCreate");

        Mcontext = this;
        btn1 = (Button) findViewById(R.id.btnOpen1);
        btn2 = (Button) findViewById(R.id.btnOpen2);
        textView = (TextView) findViewById(R.id.textViewShowData);

        btn1.setOnClickListener(new OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent intent = new Intent(Mcontext, DemoActivity.class);
                // 启动activity
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mcontext, DemoActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    /**
     * @param requestCode 请求的标识
     * @param resultCode 第二个页面返回的标识
     * @param data 第二个页面回传的数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == 2){
            String text = data.getStringExtra("data");
            Log.i("TAG", text);

            textView.setText(text);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "MainActivity --> onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "MainActivity --> onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "MainActivity --> onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "MainActivity --> onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "MainActivity --> onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "MainActivity --> onRestart");
    }
}

