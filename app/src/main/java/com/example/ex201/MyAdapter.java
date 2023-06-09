package com.example.ex201;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<UserEntity> list;
    public MyAdapter(List<UserEntity> list) {
        this.list = list;
    }
//    1. 어뎁터 생성하기 - 아이템뷰를 생성하기위함
//    1-1.리사이클러뷰의 어뎁터를 상속받는 마이어뎁터 생성

    public class ViewHolder extends RecyclerView.ViewHolder {
//        2. 뷰홀더 생성 - 아이템뷰를 저장하는 재활용되는 객체
//        2-1. 텍스트뷰 등의 객체 id를 참조
        private final TextView textView;
        Button button_up;
        Button button_down;
        Button button_del;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.textView);
            button_up=(Button) itemView.findViewById(R.id.button3);
            button_down=(Button) itemView.findViewById(R.id.button4);
            button_del=(Button) itemView.findViewById(R.id.button5);

            button_up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println(textView.getText()+" 의 버튼1클릭 ok ");
                }
            });

            button_down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("버튼2클릭 ok ");
                }
            });

            button_del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    System.out.println("삭제전 어레이리스트 :"+arrayList);
//                    System.out.println("삭제할 항목 :"+textView.getText().toString());
//                    System.out.println("새로고침할 항목의 인덱스 :"+arrayList.indexOf(textView.getText().toString()));
//                    int index = arrayList.indexOf(textView.getText().toString());
//                    arrayList.remove(textView.getText().toString());
//                    System.out.println("삭제후 어레이리스트 :"+arrayList);
//                    notifyItemRemoved(index);
//                    System.out.println(arrayList);
//                    System.out.println("버튼3클릭 ok ");
                }
            });

        }
//        public TextView getTextView() {
//            return textView;
//        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        3. onCreateViewHolder 작성 - 뷰홀더를 리턴해줌
//        3-1.리스트 아이템의 ui를 정하는 뷰를 만듬
//        3-2.뷰홀더에 만든뷰를 담아 리턴함
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_ex1,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        4. onBindViewHolder 작성 - 데이터를 넣어줌
//        4-1. 뷰홀더의 텍스트뷰등의 객체에 데이터를 받아서 넣음
        holder.textView.setText(list.get(position).Name);


    }

    @Override
    public int getItemCount() {
//        5. getItemCount 작성 - 데이터의 아이템의 총갯수
//        return .size() , length() . . .
        return list.size();
    }


}
