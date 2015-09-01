package com.example.phananhnhat.ghephinh;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Random;


public class Play extends ActionBarActivity  implements View.OnClickListener{
    // Đây là thao tác vs Button , nhưng nếu với Image button thì phai sử dụng đến public static int[] Arr; để lưu giá trị các ô
    public static Button[] ArrBut;
    public static int[] Arr;
    public static int[][] TH_Doi = { {1,1,2,2,3,4,4,5,5,6,7,8},{2,4,3,5,6,5,7,6,8,9,8,9}};
    private  int Kiemtra(int[] a,int b){
        for (int i=0;i<a.length;i++){
            if (a[i] == b) return 1;
        }
        return -1;
    }
    private void CreateTag()
    {
//        Arr = new int[9];
//        for (int i=0;i<9;i++)
//        {
//
//            Arr[i]=i+1;
//        }
//        findViewById(R.id.map_1).setTag(1);
//        findViewById(R.id.map_2).setTag(2);
//        findViewById(R.id.map_3).setTag(3);
//        findViewById(R.id.map_4).setTag(4);
//        findViewById(R.id.map_5).setTag(5);
//        findViewById(R.id.map_6).setTag(6);
//        findViewById(R.id.map_7).setTag(7);
//        findViewById(R.id.map_8).setTag(8);
//        findViewById(R.id.map_9).setTag(9);
        int[] arr1 = new int[9];
        Random RD = new Random();
        int i = 0;
        while (i < 9)
        {
            int r = RD.nextInt(9) + 1;
            if (Kiemtra(arr1,r) == -1)
            {
                arr1[i] = r;
                i++;
            }
        }
        ArrBut = new Button[9];
        ArrBut[0] = (Button) findViewById(R.id.map_1);
        ArrBut[1] = (Button)   findViewById(R.id.map_2);
        ArrBut[2] = (Button)   findViewById(R.id.map_3);
        ArrBut[3] = (Button)   findViewById(R.id.map_4);
        ArrBut[4] = (Button)   findViewById(R.id.map_5);
        ArrBut[5] = (Button)   findViewById(R.id.map_6);
        ArrBut[6] = (Button)    findViewById(R.id.map_7);
        ArrBut[7] = (Button)    findViewById(R.id.map_8);
        ArrBut[8] = (Button)    findViewById(R.id.map_9);
        for (int j=0;j<9;j++){
            ArrBut[j].setTag(j+1);
            ArrBut[j].setText("" + arr1[j]);
        }
        Drawable a;
    }
    private void TaoAnh(Button img){
      img.setText(img.getTag().toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        CreateTag();
        findViewById(R.id.map_1).setOnClickListener(this);
        findViewById(R.id.map_2).setOnClickListener(this);
        findViewById(R.id.map_3).setOnClickListener(this);
        findViewById(R.id.map_4).setOnClickListener(this);
        findViewById(R.id.map_5).setOnClickListener(this);
        findViewById(R.id.map_6).setOnClickListener(this);
        findViewById(R.id.map_7).setOnClickListener(this);
        findViewById(R.id.map_8).setOnClickListener(this);
        findViewById(R.id.map_9).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
        return true;
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
    private int TimOTrong()
    {
        for (int i =0 ;i<9;i++){
            String c = ArrBut[i].getTag().toString();
            int k = Integer.parseInt(ArrBut[i].getText().toString());
            if (k == 9) return i+1;
        }
        return 0;
    }
    private void DoiCho(Button v1,Button v2){
        String a = v1.getText().toString();
        v1.setText(v2.getText().toString());
        v2.setText(a);
    }
    private boolean KiemTra()
    {
        for (int i=0;i<9;i++)
        {
            int a = Integer.parseInt(ArrBut[i].getText().toString());
            if (a!=i+1) return false;
        }
        return true;
    }
    @Override
    public void onClick(View v) {

        int Location =  Integer.parseInt(v.getTag().toString()) ;
        int location_empty = TimOTrong();
        boolean enable =false;
        for (int i=0;i<12;i++)
        {
            if ( (Location == TH_Doi[0][i] && location_empty == TH_Doi[1][i] )
                    ||(Location == TH_Doi[1][i] && location_empty == TH_Doi[0][i]) )
            {
                enable = true;
                Log.i("bbbbbbbbb","cccccc " +i);
            }
            Log.i("aaa","" + Location + ":" + location_empty);
        }
        if(enable == true)
        {
            DoiCho(ArrBut[Location-1],ArrBut[location_empty-1]);
            if(KiemTra()==true)
            {
                ((TextView) findViewById(R.id.team)).setText("Yes");
            }
        }

    }
}
