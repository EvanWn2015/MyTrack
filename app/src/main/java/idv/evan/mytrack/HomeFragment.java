package idv.evan.mytrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

/**
 * Created by 淳彥 on 2015/11/21.
 */
public class HomeFragment extends Fragment {
    private TextClock tc_data;
    private TextView tv_total_diaries, tv_day_diaries, tv_total_pictures, tv_latest_data;
    private Button btn_added;
    private ViewPager viewPager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPager = (ViewPager) getActivity().findViewById(R.id.viewPager);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tc_data = (TextClock) view.findViewById(R.id.tc_data);
        tv_total_diaries = (TextView) view.findViewById(R.id.tv_total_diaries);
        tv_day_diaries = (TextView) view.findViewById(R.id.tv_day_diaries);
        tv_total_pictures = (TextView) view.findViewById(R.id.tv_total_pictures);
        tv_latest_data = (TextView) view.findViewById(R.id.tv_latest_data);
        btn_added = (Button) view.findViewById(R.id.btn_added);
        findView();
        return view;
    }


    public void findView() {

        tv_total_diaries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        tv_day_diaries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tv_total_pictures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tv_latest_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_added.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsFragment.class);
                startActivity(intent);
            }
        });

    }

//    @Override
//    public void onClick(View v) {
//        startActivity(new Intent(getActivity(), MapsFragment.class));
//        
//    }
}
