package idv.evan.mytrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;

/**
 * Created by 淳彥 on 2015/11/19.
 */
public class SettingFragment extends Fragment {
    private Spinner sp_language;
    private Switch sw_night_mode;
    private SeekBar sb_luminance;
    private Button btn_googlesingin;
    private DrawerLayout drawerLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_setting, container, false);
        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawerLayout);
        
        // 語言選擇 Spinner
        sp_language = (Spinner) view.findViewById(R.id.sp_language);
        
        sw_night_mode = (Switch) view.findViewById(R.id.sw_night_mode);
        
        // 明暗度調整 SeekBar
        sb_luminance = (SeekBar) view.findViewById(R.id.sb_luminance);
        sb_luminance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                drawerLayout.setBackgroundColor(Color.rgb(progress,progress,progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btn_googlesingin = (Button) view.findViewById(R.id.btn_googlesingin);

        btn_googlesingin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
