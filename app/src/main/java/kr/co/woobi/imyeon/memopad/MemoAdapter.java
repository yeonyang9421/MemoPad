package kr.co.woobi.imyeon.memopad;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

class MemoAdapter extends BaseAdapter {
    private  final List<Memo> mData;
    public MemoAdapter(List<Memo> mMemoList) {
        mData=mMemoList;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder viewHolder;
        //converView 재새용 되는 뷰
        if(convertView==null){
            viewHolder=new MemoAdapter.ViewHolder();

            //뷰를 새로 만들 때
            convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memo,parent,false);

            //레이아웃 들고 오기
            TextView titleTextView=(TextView)convertView.findViewById(R.id.titleTextView);
            TextView contentTextVie=(TextView)convertView.findViewById(R.id.contentTextView);


            //뷰 홀더에 넣는다
            viewHolder.titleTextView=titleTextView;
            viewHolder.contentTextView=contentTextVie;
            convertView.setTag(viewHolder);
        }else{
            //재사용 할때
            viewHolder=(ViewHolder)convertView.getTag();
        }

        //데이터
        Memo memo= mData.get(position);

        //화면에 뿌리기
        viewHolder.titleTextView.setText(memo.getTitle());
        viewHolder.contentTextView.setText(memo.getContent());

        return convertView;
    }

    //findViewById로 가져온 view들을 보관
    private static  class  ViewHolder{
        TextView titleTextView;
        TextView contentTextView;
    }

}
