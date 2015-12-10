package idv.evan.mytrack;

import android.app.Activity;
import android.app.Dialog;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by 淳彥 on 2015/11/19.
 */
public class MapsFragment extends Activity implements OnMapReadyCallback {

    //    private FloatingActionButton fab_locate;
    private ImageButton ib_locate;
    private Marker marker;
    private GoogleMap map;
    private LocationManager locationManager;
    private Dialog addedDialog;
    private UiSettings uiSettings;
    private double lat, lng;
    private String title = "";
    private String snippet = "";
    private int zoom = 8;
    private LatLng latlng = new LatLng(23.635789, 120.926956);

    // dialog view
    private EditText et_title, et_address, edt_url, et_phone, et_snippet;
    private RatingBar rb_rating;
    private TextView tv_rating;
    private ImageView iv_add;
    private Button btn_commit, btn_clear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_maps);
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        findView();

    }

    public void findView() {
        ib_locate = (ImageButton) findViewById(R.id.ib_locate);
        // 點擊後map上出現Marker
        ib_locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtainLatLng();
                drawMarker();
                Snackbar.make(v, lat + ", " + lng, Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    // 初始化地圖
    private void initMap() {
        // 檢查GoogleMap物件是否存在
        if (map == null) {
            // 從SupportMapFragment取得GoogleMap物件
            map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            if (map != null) {
                setupMap();
            }
        }
    }

    // 完成鏡頭焦點相關設定
    private void setupMap() {

        CameraPosition cameraPosition = new CameraPosition.Builder()
                // 鏡頭焦點在台灣中心
                .target(latlng)
                        // 地圖縮放層級定為8
                .zoom(zoom)
                .build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        map.animateCamera(cameraUpdate);

        // 如果不套用自訂InfoWindowAdapter會自動套用預設訊息視窗
        map.setInfoWindowAdapter(new MyInfoWindowAdapter());

        MyMarkerListener listener = new MyMarkerListener();
        // 註冊OnMarkerClickListener，當標記被點擊時會自動呼叫該Listener的方法
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                showAddedDialog();
                return true;
            }
        });
        // 註冊OnInfoWindowClickListener，當標記訊息視窗被點擊時會自動呼叫該Listener的方法
        map.setOnInfoWindowClickListener(listener);
        // 註冊OnMarkerDragListener，當標記被拖曳時會自動呼叫該Listener的方法
        map.setOnMarkerDragListener(listener);

        mapUiSetting();

    }

    // MapUI設定
    private void mapUiSetting() {
        uiSettings = map.getUiSettings();
        map.setMyLocationEnabled(false); // 顯示/隱藏自己位置
        uiSettings.setMyLocationButtonEnabled(false); // 顯示/隱藏自己位置按鈕
        map.setMyLocationEnabled(false); // 顯示/隱藏自己位置圖層，如果未開啓則自己位置按鈕也無法顯示
        map.setTrafficEnabled(false); // 顯示/隱藏交通流量
        uiSettings.setZoomControlsEnabled(true); // 顯示縮放按鈕
        uiSettings.setCompassEnabled(true); // 顯示/隱藏指北針
        uiSettings.setScrollGesturesEnabled(true); // 開啟/關閉地圖捲動手勢
        uiSettings.setTiltGesturesEnabled(true); // 開啟/關閉地圖3D手勢
        uiSettings.setRotateGesturesEnabled(true); // 開啟/關閉地圖旋轉手勢

    }


    // 取得當前位置
    private void obtainLatLng() {
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
        }

    }


    // 畫出Marker
    private void drawMarker() {
        map.clear();
        // 新增座標錨點
        marker = map.addMarker(new MarkerOptions()
                        .position(new LatLng(lat, lng))
                        .visible(true)
                        .title("Click to Added")
                        .snippet("點擊編輯內容")
                        .draggable(true) // 可拖曳
                        .anchor(0.5f, 1.0f) //錨點位置設為圖片中心
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_descriptor))
                

        );
        
        // 直接開啟marker信息視窗
        marker.showInfoWindow();
        zoom = 15;
        latlng = new LatLng(lat, lng);
        setupMap();

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        // 載入Map顯示整個台灣
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 8));
    }

    // 對話視窗元件
    private void showAddedDialog() {
        addedDialog = new Dialog(MapsFragment.this, R.style.selectorDialog);
        addedDialog.setCancelable(true);
        addedDialog.setContentView(R.layout.dialog_added);
        Window dialogWindow = addedDialog.getWindow();
        dialogWindow.setGravity(Gravity.CENTER);

        WindowManager wm = getWindowManager();
        Display d = wm.getDefaultDisplay();
        WindowManager.LayoutParams p = dialogWindow.getAttributes();
        // Dialog是窗外明暗度
        p.dimAmount = 0.7f; // 0.1f ~ 1.0f
        p.height = (int) (d.getHeight() * 0.8);
        p.width = (int) (d.getWidth() * 0.9);
        dialogWindow.setAttributes(p);


//        dataEntry();
        addedDialog.show(); // 顯示Dialog
    }


    private class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
        private final View infoWindow;

        MyInfoWindowAdapter() {
            infoWindow = LayoutInflater.from(MapsFragment.this)
                    .inflate(R.layout.custom_infowindow, null);
        }

        @Override
        public View getInfoWindow(Marker marker) {

            ImageView ivLogo = ((ImageView) infoWindow.findViewById(R.id.iv_logo));
            ivLogo.setImageResource(R.drawable.ic_add);
            
            String title = marker.getTitle();
            TextView tvTitle = ((TextView) infoWindow.findViewById(R.id.tv_title));
            tvTitle.setText(title);

            String snippet = marker.getSnippet();
            TextView tvSnippet = ((TextView) infoWindow.findViewById(R.id.tv_snippet));
            tvSnippet.setText(snippet);
            
            return infoWindow;
        }

        @Override
        public View getInfoContents(Marker marker) {
            return null;
        }
    }

    // Dialog 輸入資料
    private void dataEntry() {
        et_title = (EditText) findViewById(R.id.et_title);
        et_address = (EditText) findViewById(R.id.et_address);
        edt_url = (EditText) findViewById(R.id.edt_url);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_snippet = (EditText) findViewById(R.id.et_snippet);
        rb_rating = (RatingBar) findViewById(R.id.rb_rating);
        tv_rating = (TextView) findViewById(R.id.tv_rating);
        iv_add = (ImageView) findViewById(R.id.iv_add);
        btn_commit = (Button) findViewById(R.id.btn_commit);
        btn_clear = (Button) findViewById(R.id.btn_clear);

        // 評分 RatingBar
        rb_rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

        // 新增照片
        iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // 提交內容
        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // 清除內容
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_title.setText("");
                et_address.setText("");
                edt_url.setText("");
                et_phone.setText("");
                et_snippet.setText("");
                rb_rating.setRating(0.0f);
                tv_rating.setText("0.0");

            }
        });


    }


    // 點擊Marker監聽事件
    private class MyMarkerListener implements GoogleMap.OnMarkerClickListener,
            GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerDragListener {
        @Override
        // 點擊標記的訊息視窗
        public void onInfoWindowClick(Marker marker) {
        }

        @Override
        // 點擊地圖上的標記
        public boolean onMarkerClick(Marker marker) {
            return false;
        }

        @Override
        // 開始拖曳標記
        public void onMarkerDragStart(Marker marker) {

        }

        @Override
        // 拖曳標記過程中會不斷呼叫此方法
        public void onMarkerDrag(Marker marker) {

        }

        @Override
        // 結束拖曳標記
        public void onMarkerDragEnd(Marker marker) {
            Toast.makeText(MapsFragment.this, "" + lat + lng, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        initMap();
    }


    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_maps, container, false);
//        return view;
//    }

}
