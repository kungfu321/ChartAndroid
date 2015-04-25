package com.example.manh.chartandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by manh on 21/04/2015.
 */
public class TheNews extends Activity {
    private ListView listView;
    String[] data = {
            "Ra mắt Fast And Furious 7",
            "item 2",
            "item 3",
            "item 4",
            "item 5",
            "item 6",
            "item 7",
            "item 1",
            "item 2",
            "item 3",
            "item 4",
            "item 5",
            "item 6",
            "item 7"} ;

    Integer[] image = {R.drawable.user, R.drawable.abc_ab_share_pack_mtrl_alpha, R.drawable.abc_btn_check_material,
            R.drawable.abc_btn_check_to_on_mtrl_015, R.drawable.user, R.drawable.user,R.drawable.user,R.drawable.user,
            R.drawable.user, R.drawable.user, R.drawable.user, R.drawable.user, R.drawable.user,R.drawable.user};

    String[] time = {"03/02","02/03","05/06", "15/12","10/09","08/07",
            "07/08","06/05","04/03", "02/01","01/02","03/04", "04/05","05/06"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.the_news);
        listView = (ListView) findViewById(R.id.list_the_news);

        NewAdapter adapter = new NewAdapter(TheNews.this, data, image);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(TheNews.this, "BILLGATE", Toast.LENGTH_SHORT).show();

            }
        });
    }

    class NewAdapter extends ArrayAdapter {
        private Activity context;
        private String[] data;
        private Integer[] imageId;

        public NewAdapter(Activity context, String[] data, Integer[] imageId) {
            super(context, R.layout.item_thenews, data);
            this.context = context;
            this.data = data;
            this.imageId = imageId;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = context.getLayoutInflater();
            View view1 = inflater.inflate(R.layout.item_thenews, null, true);
            TextView textView = (TextView) view1.findViewById(R.id.text_message);
            textView.setText(data[position]);
            ImageView imageView = (ImageView) view1.findViewById(R.id.image_the_news);
            imageView.setImageResource(imageId[position]);
            ((TextView) view1.findViewById(R.id.text_time)).setText(time[position]);
            return view1;
        }
    }
}