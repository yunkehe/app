package tk.yunheke.whereismycar;

import android.content.Context;
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
import android.widget.ImageButton;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private AutoCompleteTextView acTextView;
    private MultiAutoCompleteTextView mulTextView;
    private String[] res = {"beijing1", "beijing2", "beijing3", "shanghai1", "shanghai2", "shenzhen1", "shenzhen2","shenzhen3"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 1. 初始化控件
         * 2. 需要一个适配器
         * 3. 初始化数据源--匹配文本框中输入的内容
         * 4. 将adaptor与当前autocomplete控件绑定
         */
        acTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, res);

        acTextView.setAdapter(adapter);


        mulTextView= (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        mulTextView.setAdapter(adapter);
        // 设置分隔符
        mulTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }

}

