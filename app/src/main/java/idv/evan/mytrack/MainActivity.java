package idv.evan.mytrack;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "fragment";

    //    private FrameLayout frameLayout;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private FloatingActionButton floatingActionButton;
    private ViewPager viewPager;
    private CircleImageView user_profile;
    private byte[] pic;
    private File file;
    private static final int REQUEST_TAKE_PIC = 0;
    private static final int REQUEST_PICK_PIC = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupDrawerLayout();
//        initFAB();
        changeUserAvatar();
        
    }

    private void setupDrawerLayout() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem Item) {

                switch (Item.getItemId()) {
                    case R.id.drawer_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.drawer_records:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.drawer_albums:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.drawer_settings:
                        viewPager.setCurrentItem(3);
                        break;
                }
                Snackbar.make(viewPager, Item.getTitle() + "pressed", Snackbar.LENGTH_LONG).show();
                Item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                navigationView.getMenu().getItem().setChecked(true);
            }
        };

        drawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }

//    private void initFAB() {
//        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            
//            @Override
//            public void onClick(View v) {
//
//                
////                setContentView(R.layout.fragment_maps);
////                Snackbar.make(frameLayout, "FAB Clicked", Snackbar.LENGTH_SHORT).show();
//            }
//        });
//    }


    public void changeUserAvatar() {
        user_profile = (CircleImageView) findViewById(R.id.user_profile);
        // 頭像點擊,可更換頭像
        user_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQUEST_PICK_PIC);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_TAKE_PIC:
                    Bitmap bitmapPic = BitmapFactory.decodeFile(file.getPath());
                    user_profile.setImageBitmap(bitmapPic);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmapPic.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    pic = baos.toByteArray();
                    break;
                case REQUEST_PICK_PIC:
                    Uri uri = intent.getData();
                    String[] columns = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(uri, columns,
                            null, null, null);
                    if (cursor.moveToFirst()) {
                        String imagePath = cursor.getString(0);
                        cursor.close();
                        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
                        user_profile.setImageBitmap(bitmap);
                    }
                    break;
            }
        }
    }

    public boolean isIntentAvailable(Context context, Intent intent) {
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> list = pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

    private class PagerAdapter extends FragmentPagerAdapter {
        public List<Fragment> fragmentList;

        public PagerAdapter(FragmentManager fm) {
            super(fm);

            fragmentList = new ArrayList<>();
            fragmentList.add(new HomeFragment());
            fragmentList.add(new RecordsFragment());
            fragmentList.add(new AlbumsFragment());
            fragmentList.add(new SettingFragment());
        }

        @Override
        public Fragment getItem(int position) {
            
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

}
