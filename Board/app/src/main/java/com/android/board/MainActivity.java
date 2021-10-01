package com.android.board;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
/*
    처음에 리스트뷰 안띄우는법 알아내기(해결)
    입력할때마다 리스트뷰를 추가하는법 알아보기

    오늘안것: addflag를 쓰면 이전 액티비티로 돌아가지 않게 된다.
    vi 편집기는 정말 x 같다.


 */
@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    private long backKeyPressedTime = 0; //뒤로 가기를 누른 시간
    ListviewAdapter adapter;
    ListView allList;
    ListView gongjiList;
    ListView bragList;
    ListView gominList;
    ListView mypostList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ListviewAdapter();

        ImageButton btnPen = (ImageButton) findViewById(R.id.btnPen);

        btnPen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
                startActivityForResult(intent, 100);
            }
        });



        final ArrayList<String> postList = new ArrayList<String>(); // 게시글 리스트 생성


          allList = (ListView) findViewById(R.id.listAll);
          gongjiList = (ListView) findViewById(R.id.listGongji);
          bragList = (ListView) findViewById(R.id.listBrag);
          gominList = (ListView) findViewById(R.id.listGomin);
          mypostList = (ListView) findViewById(R.id.listMypost);

          adapter = new ListviewAdapter();
          allList.setAdapter(adapter);
          gongjiList.setAdapter(adapter);
          bragList.setAdapter(adapter);
          gominList.setAdapter(adapter);
          mypostList.setAdapter(adapter);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabAll = tabHost.newTabSpec("ALL").setIndicator("전체");
        tabAll.setContent(R.id.tabAll);
        tabHost.addTab(tabAll);

        TabHost.TabSpec tabGongji = tabHost.newTabSpec("GONGJI").setIndicator("공지");
        tabGongji.setContent(R.id.tabGongji);
        tabHost.addTab(tabGongji);

        TabHost.TabSpec tabBrag = tabHost.newTabSpec("BRAG").setIndicator("자랑");
        tabBrag.setContent(R.id.tabBrag);
        tabHost.addTab(tabBrag);

        TabHost.TabSpec tabGomin = tabHost.newTabSpec("GOMIN").setIndicator("고민");
        tabGomin.setContent(R.id.tabGomin);
        tabHost.addTab(tabGomin);

        TabHost.TabSpec tabMypost = tabHost.newTabSpec("MYPOST").setIndicator("내글");
        tabMypost.setContent(R.id.tabMypost);
        tabHost.addTab(tabMypost);

        tabHost.setCurrentTab(0);




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 100) {
                String getTitle = data.getStringExtra("Title");// 글 제목
                String getDesc  = data.getStringExtra("Title");// 글 제목
                String getWriter = data.getStringExtra("Writer");// 작성자
                adapter.addItem(getTitle, getDesc , 0, getWriter, "2021-10-01"); // 리스트 추가
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "정상적으로 처리되었습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "처리 도중 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        /*
            뒤로 가기 두번 누르면 종료되는 메소드
         */
        //super.onBackPressed();
        if(System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(this, "뒤로 버튼을 한번 더 누르시면 종료됩니다.",
                    Toast.LENGTH_SHORT).show();
            return;

        }


        if(System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finish();
        }
    }
}