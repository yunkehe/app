//package tk.yunheke.whereismycar;
//
//import android.content.Context;
//import android.location.LocationProvider;
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.Menu;
//import android.view.MenuItem;
//
////定位信息
//import android.content.Intent;
//import android.location.Criteria;
//import android.location.GpsSatellite;
//import android.location.GpsStatus;
//import android.location.Location;
//import android.provider.Settings;
//import android.location.LocationManager;
//import android.location.LocationListener;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//import android.widget.EditText;
//
//import org.w3c.dom.Text;
//
//import java.util.Iterator;
//
//public class MainActivity2 extends AppCompatActivity {
//    private TextView gpsText;
//    private LocationManager lm;
//    private Button btnshow;
//    // 常量
//    private static final String TAG = "GpsActivity";
//
//    protected void onDestroy() {
//        super.onDestroy();
//        lm.removeUpdates(locationListener);
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    //  将布局xml文件引入到activity中
//        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        btnshow = (Button) findViewById(R.id.btn1);
//        btnshow.setOnClickListener(new OnClickListener(){
////            重写点击事件的处理方法
//            @Override
//            public void onClick(View v){
//                Toast.makeText(getApplicationContext(),"你点击了按钮", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        gpsText = (TextView) findViewById(R.id.textView1);
//        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//
//        if(!lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//            Toast.makeText(this, "请开启GPS导航。。。", Toast.LENGTH_SHORT).show();
////                返回开启GPS导航设置界面
//            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//            startActivityForResult(intent, 0);
//            return;
//        }
//
//        // 为获取地理位置信息时设置查询条件
//        String bestProvider = lm.getBestProvider(getCriteria(), true);
//        // 如果不设置查询要求，getLastKnownLocation方法传人的参数为LocationManager.GPS_PROVIDER
//        Location location = lm.getLastKnownLocation(bestProvider);
//        updateView(location);
//        // 监听状态
//        lm.addGpsStatusListener(listener);
//        // 绑定监听，有4个参数  
//// 参数1，设备：有GPS_PROVIDER和NETWORK_PROVIDER两种  
//// 参数2，位置信息更新周期，单位毫秒  
//// 参数3，位置变化最小距离：当位置距离变化超过此值时，将更新位置信息  
//// 参数4，监听  
//// 备注：参数2和3，如果参数3不为0，则以参数3为准；参数3为0，则通过时间来定时更新；两者为0，则随时刷新  
//// 1秒更新一次，或最小位移变化超过1米更新一次；  
//// 注意：此处更新准确度非常低，推荐在service里面启动一个Thread，在run中sleep(10000);然后执行handler.sendMessage(),更新位置  
//        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);
//    }
//
//    // 位置监听
//    private LocationListener locationListener = new LocationListener() {
//        // 位置信息变化时触发
//        @Override
//        public void onLocationChanged(Location location) {
//            updateView(location);
//            Log.i(TAG, "时间：" + location.getTime());
//            Log.i(TAG, "经度：" + location.getLongitude());
//            Log.i(TAG, "纬度：" + location.getLatitude());
//            Log.i(TAG, "海拔：" + location.getAltitude());
//        }
//
//        // GPS状态变化时触发
//        @Override
//        public void onStatusChanged(String provider, int status, Bundle extras) {
//            switch (status) {
//                // GPS状态可见时
//                case LocationProvider.AVAILABLE:
//                    Log.i(TAG, "当前GPS状态为可见状态");
//                    break;
//                case LocationProvider.OUT_OF_SERVICE:
//                    Log.i(TAG, "当前GPS状态为服务区外状态");
//                    break;
//                case LocationProvider.TEMPORARILY_UNAVAILABLE:
//                    Log.i(TAG, "当前GPS状态为暂停服务状态");
//                    break;
//            }
//        }
//
//        @Override
//        public void onProviderEnabled(String provider) {
//            Location location = lm.getLastKnownLocation(provider);
//            updateView(location);
//        }
//
//        @Override
//        public void onProviderDisabled(String provider) {
//            updateView(null);
//        }
//    };
//
//    //状态监听
//    GpsStatus.Listener listener = new GpsStatus.Listener() {
//        @Override
//        public void onGpsStatusChanged(int event) {
//            switch (event) {
//                // 第一次定位
//                case GpsStatus.GPS_EVENT_FIRST_FIX:
//                    Log.i(TAG, "第一次定位");
//                    break;
//                // 卫星状态改变
//                case GpsStatus.GPS_EVENT_SATELLITE_STATUS:
//                    Log.i(TAG, "卫星状态改变");
//                    // 获取当前状态
//                    GpsStatus gpsStatus = lm.getGpsStatus(null);
//                    // 获取卫星颗数的默认最大值
//                    int maxSatellites = gpsStatus.getMaxSatellites();
//                    // 创建一个迭代器保存所有卫星
//                    Iterator<GpsSatellite> iters = gpsStatus.getSatellites()
//                            .iterator();
//                    int count = 0;
//                    while (iters.hasNext() && count <= maxSatellites) {
//                        GpsSatellite s = iters.next();
//                        count++;
//                    }
//                    System.out.println("搜索到： " + count + "颗卫星");
//                    break;
//                // 定位启动
//                case GpsStatus.GPS_EVENT_STARTED:
//                    Log.i(TAG, "定位启动");
//                    break;
//
//                // 定位结束
//                case GpsStatus.GPS_EVENT_STOPPED:
//                    Log.i(TAG, "定位结束");
//                    break;
//            }
//        }
//    };
//
//    /**
//     * 实时更新文本内容
//     */
//    private void updateView(Location location) {
//        if (location != null) {
//            editText.setText("设备位置信息\n\n经度：");
//            editText.append(String.valueOf(location.getLongitude()));
//            editText.append("\n纬度");
//            editText.append(String.valueOf(location.getLatitude()));
//        } else {
//            // 清空EditText
//            editText.getEditableText().clear();
//        }
//    }
//
//    private Criteria getCriteria() {
//        Criteria criteria = new Criteria();
//        // 设置定位精确度 Criteria.ACCURACY_COARSE比较粗略，Criteria.ACCURACY_FINE则比较精细  
//        criteria.setAccuracy(Criteria.ACCURACY_FINE);
//        // 设置是否要求速度  
//        criteria.setSpeedRequired(false);
//        // 设置是否允许运营商收费  
//        criteria.setCostAllowed(false);
//        // 设置是否需要方位信息  
//        criteria.setBearingRequired(false);
//        // 设置是否需要海拔信息  
//        criteria.setAltitudeRequired(false);
//        // 设置对电源的需求  
//        criteria.setPowerRequirement(Criteria.POWER_LOW);
//        return criteria;
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    private LocationManager locationManager;
//}
