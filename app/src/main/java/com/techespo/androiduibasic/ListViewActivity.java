package com.techespo.androiduibasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {
    String[] studentNameArray =  {"Ram","Jack","Pem","price","Harri","Lucky","Ram","Jack","Pem","price","Harri","Lucky"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView lvStudents = (ListView) findViewById(R.id.lv_student);
        MyStudentListAdapter adapter = new MyStudentListAdapter();
        lvStudents.setAdapter(adapter);
        lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                TextView tv = (TextView) view.findViewById(R.id.txt_name);
                tv.setText("Hello");
                Toast.makeText(ListViewActivity.this,"Your selectes student name is:"+ studentNameArray[position],
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    class MyStudentListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return studentNameArray.length;
        }

        @Override
        public Object getItem(int position) {
            return studentNameArray[position];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertedView, ViewGroup viewGroup) {

            View  view  = convertedView;
            if(view == null){
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                view  = inflater.inflate(R.layout.student_list_row_layout,null);

            }
            TextView tvName =  (TextView) view.findViewById(R.id.txt_name);
            tvName.setText(studentNameArray[position]);
            return view;
        }
    }
}
