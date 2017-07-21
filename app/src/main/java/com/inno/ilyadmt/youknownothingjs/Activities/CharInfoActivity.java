package com.inno.ilyadmt.youknownothingjs.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.inno.ilyadmt.youknownothingjs.R;

/**
 * Created by mjazz on 21.07.2017.
 */

public class CharInfoActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_info);
        Intent intent = getIntent();

        TextView textView = (TextView)findViewById(R.id.tv_name_data);
        textView.setText(intent.getStringExtra("name"));

        textView = (TextView)findViewById(R.id.tv_culture_data);
        textView.setText(intent.getStringExtra("culture"));

        textView = (TextView)findViewById(R.id.tv_borndied_data);
        textView.setText(intent.getStringExtra("date"));

        textView = (TextView)findViewById(R.id.tv_aliases_data);
        textView.setText(intent.getStringExtra("aliases"));

        textView = (TextView)findViewById(R.id.tv_titles_data);
        textView.setText(intent.getStringExtra("titles"));

    }
}
