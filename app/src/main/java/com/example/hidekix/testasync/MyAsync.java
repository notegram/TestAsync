package com.example.hidekix.testasync;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hidekix on 2015/07/05.
 */
public class MyAsync extends AsyncTask<String,Integer, String> {

    private String TAG = "MyAsync";
    private TextView rsultView_;
    private ProgressDialog progressDialog_;
    private Activity uiActivity_;

    public MyAsync(Activity activity, TextView textView) {
        super();
        uiActivity_ = activity;
        rsultView_ = textView;
    }

    @Override
    protected void onPreExecute() {
        Log.d(TAG,"onPreExecute");
        progressDialog_ = new ProgressDialog(uiActivity_);
        progressDialog_.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog_.setIndeterminate(false);
        progressDialog_.show();
    }

    @Override
    protected String doInBackground(String... params) {
        //do nothing
        long i,ii;
        long i2=0;
        Log.d(TAG,"doInBackground");
        for(i=0;i < 0xffffffff;i++){

            for(ii=0;ii<0x1000;ii++){
                i2++;
            }
        }
        try{
            Thread.sleep(1000);;
            onProgressUpdate(50);
            Thread.sleep(1000);
            onProgressUpdate(100);

        }catch (InterruptedException e) {
            // TODO Auto-generated catch block
        }


        if(i2>0)
        {
            return "1";
        }else {
            return "2";
        }
    }
    @Override
    protected void onProgressUpdate(Integer... values ) {
        Log.d(TAG,"onProgressUpdate");
        progressDialog_.incrementProgressBy(values[0]);
        return;
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d(TAG,"onPostExecute");
        progressDialog_.dismiss();
       // rsultView_.setText("Done!");

    }

}
