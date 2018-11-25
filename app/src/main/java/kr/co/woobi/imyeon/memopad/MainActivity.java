package kr.co.woobi.imyeon.memopad;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_NEW_MOMO = 1000;
    private static final String TAG = MainActivity.class.getSimpleName();

    private List<Memo> mMemoList;
    private  MemoAdapter mAdapte;
    private ListView mMemoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMemoListView=(ListView)findViewById(R.id.memo_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MemoActivity.class);
                startActivityForResult(intent, REQUEST_CODE_NEW_MOMO);
            }
        });

        //데이터
        mMemoList=new ArrayList<>();
        //어댑터
        mAdapte=new MemoAdapter(mMemoList);
        mMemoListView.setAdapter(mAdapte);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_NEW_MOMO){
            if(resultCode==RESULT_OK){
                String title=data.getStringExtra("title");
                String content=data.getStringExtra("content");
                mMemoList.add(new Memo(title,content));
                mAdapte.notifyDataSetChanged();

                Log.d(TAG,"onActivityResult : "+title + "," +content);
                Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "취소 되었습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
