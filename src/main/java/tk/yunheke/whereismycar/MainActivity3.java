//package tk.yunheke.whereismycar;
//
//import android.content.Context;
//import android.location.LocationProvider;
//import android.os.Bundle;
//import android.os.PersistableBundle;
//import android.support.annotation.Nullable;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.Toast;
//
//public class MainActivity3 extends AppCompatActivity implements OnClickListener {
//    private Button loginButton;
//    private ImageButton imgBtn;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        loginButton = (Button) findViewById(R.id.btn1);
//        imgBtn = (ImageButton) findViewById(R.id.imgBtn1);
//
//        /**
//         * 通过匿名内部类实现监听
//         */
//        loginButton.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("我的应用被点击了");
//            }
//        });
//
////        imgBtn.setOnClickListener(new MyOnClickListener3() {
////            @Override
////            public void onClick(View view) {
////                super.onClick(view);
////                Toast.makeText(MainActivity.this, "imageButton被点击了", 1).show();
////            }
////        });
//
//        // 接口方式实现监听事件
//        imgBtn.setOnClickListener(this);
//
//    }
//
//    public void onClick(View v) {
//        Log.i("Tag", "第三种方式实现");
//    }
//}
//
///**
// * OnClickListener是一个接口
// */
//class MyOnClickListener3 implements OnClickListener {
//    public void onClick(View view) {
//        view.setAlpha(0.5f);
//        Log.i("Tag", "父类的onclick事件");
//    }
//}
//
