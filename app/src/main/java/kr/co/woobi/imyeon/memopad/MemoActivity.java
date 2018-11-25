package kr.co.woobi.imyeon.memopad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class MemoActivity extends AppCompatActivity {
    private EditText mTitleEditText, mContentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        mTitleEditText=findViewById(R.id.edit_title);
        mContentEditText =findViewById(R.id.edite_content);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_memo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_save:
                save();
                return true;
            case R.id.actio_cancel:
                cacel();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void cacel() {
        setResult(RESULT_CANCELED);
        finish();
    }

    private void save() {
        Intent intent= new Intent();
        intent.putExtra("title", mTitleEditText.getText().toString());
        intent.putExtra("content", mContentEditText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
