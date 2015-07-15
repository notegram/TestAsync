package com.example.hidekix.testasync;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    Button testButton;
    TextView resultTextView;
    private MyAsync task_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        task_ = new MyAsync(this, resultTextView);
        //testButton.setOnClickListener(this);
        testButton = (Button)findViewById(R.id.startbutton);
        resultTextView = (TextView)findViewById(R.id.textView2);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Button) view).setEnabled(false);
                // 非同期処理を開始する
                task_.execute("sample");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    protected void findView(){
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
