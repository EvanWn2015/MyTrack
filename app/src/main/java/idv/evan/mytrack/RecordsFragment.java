package idv.evan.mytrack;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 淳彥 on 2015/11/19.
 */
public class RecordsFragment extends Fragment {
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_records, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView) getView().findViewById(R.id.lv_records);
        List<RecordsVo> recordsList = new ArrayList<>();
        recordsList.add(new RecordsVo("2015-11-20", R.drawable.test, "台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2", "台北市政府衛生局今發布首波免費血鉛檢驗結果台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2"));
        recordsList.add(new RecordsVo("2015-11-20", R.drawable.test, "台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2", "台北市政府衛生局今發布首波免費血鉛檢驗結果台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2"));
        recordsList.add(new RecordsVo("2015-11-20", R.drawable.test, "台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2", "台北市政府衛生局今發布首波免費血鉛檢驗結果台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2"));
        recordsList.add(new RecordsVo("2015-11-20", R.drawable.test, "台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2", "台北市政府衛生局今發布首波免費血鉛檢驗結果台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2"));
        recordsList.add(new RecordsVo("2015-11-20", R.drawable.ic_add, "台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2", "台北市政府衛生局今發布首波免費血鉛檢驗結果台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2"));
        recordsList.add(new RecordsVo("2015-11-20", R.drawable.ic_add, "台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2", "台北市政府衛生局今發布首波免費血鉛檢驗結果台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2"));
        recordsList.add(new RecordsVo("2015-11-20", R.drawable.ic_add, "台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2", "台北市政府衛生局今發布首波免費血鉛檢驗結果台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2"));
        recordsList.add(new RecordsVo("2015-11-20", R.drawable.ic_add, "台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2", "台北市政府衛生局今發布首波免費血鉛檢驗結果台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2"));
        recordsList.add(new RecordsVo("2015-11-20", R.drawable.ic_add, "台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2", "台北市政府衛生局今發布首波免費血鉛檢驗結果台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2"));
        recordsList.add(new RecordsVo("2015-11-20", R.drawable.ic_add, "台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2", "台北市政府衛生局今發布首波免費血鉛檢驗結果台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2"));
        recordsList.add(new RecordsVo("2015-11-20", R.drawable.ic_add, "台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2", "台北市政府衛生局今發布首波免費血鉛檢驗結果台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2"));
        recordsList.add(new RecordsVo("2015-11-20", R.drawable.ic_add, "台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2", "台北市政府衛生局今發布首波免費血鉛檢驗結果台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2"));
        recordsList.add(new RecordsVo("2015-11-20", R.drawable.ic_add, "台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2", "台北市政府衛生局今發布首波免費血鉛檢驗結果台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2"));
        recordsList.add(new RecordsVo("2015-11-20", R.drawable.ic_add, "台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2", "台北市政府衛生局今發布首波免費血鉛檢驗結果台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2"));
        recordsList.add(new RecordsVo("2015-11-20", R.drawable.ic_add, "台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2", "台北市政府衛生局今發布首波免費血鉛檢驗結果台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2"));
        recordsList.add(new RecordsVo("2015-11-20", R.drawable.ic_add, "台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2", "台北市政府衛生局今發布首波免費血鉛檢驗結果台北市政府衛生局今發布首波免費血鉛檢驗結果，計有3名成人（1人台北、2"));
        
        listView.setAdapter(new RecordsAdapter(getActivity(), recordsList));
    }

    private class RecordsAdapter extends BaseAdapter {
        private List<RecordsVo> recordsList;
        private LayoutInflater inflater;
        private Context context;

        public RecordsAdapter(Context context, List<RecordsVo> recordsList) {
            this.context = context;
            this.recordsList = recordsList;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

//        public RecordsAdapter(RecordsFragment recordsFragment, List<Records> recordsList) {
//            this.recordsList = recordsList;
////            inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        }

        @Override
        public int getCount() {
            return recordsList.size();
        }

        @Override
        public Object getItem(int position) {
            return recordsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.listview_records, null);
                holder = new ViewHolder();
                holder.tv_records_date = (TextView) convertView.findViewById(R.id.tv_records_date);
                holder.iv_records_img = (ImageView) convertView.findViewById(R.id.iv_records_img);
                holder.tv_records_title = (TextView) convertView.findViewById(R.id.tv_records_title);
                holder.tv_records_content = (TextView) convertView.findViewById(R.id.tv_records_content);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            RecordsVo records = recordsList.get(position);
            holder.tv_records_date.setText(records.getDate());
            holder.iv_records_img.setImageResource(records.getImg());
            holder.tv_records_title.setText(records.getTitle());
            holder.tv_records_content.setText(records.getContent());

            return convertView;
        }

        private class ViewHolder {
            ImageView iv_records_img;
            TextView tv_records_title, tv_records_content, tv_records_date;
        }

    }

}
