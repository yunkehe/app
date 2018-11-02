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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class DemoActivity extends AppCompatActivity{
    private Button btn1;
    private EditText editText;
    private String text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_activity);

        btn1 = (Button) findViewById(R.id.demoBtn1);
        editText = (EditText) findViewById(R.id.demoEditText);


        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                text = editText.getText().toString();
                Log.i("TAG", text);

                Intent data = new Intent();
                data.putExtra("data", text);
                setResult(2, data);

                finish();
            }
        });
    }

}

