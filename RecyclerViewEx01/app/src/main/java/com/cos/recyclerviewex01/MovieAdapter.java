package com.cos.recyclerviewex01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private static final String TAG = "MovieAdapter";
    private List<Movie> items = new ArrayList<>();

    public void addItem(Movie movie) {
        items.add(movie);
    }

    // ① 틀만 만들어서 ViewHolder에 담아줌!
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // ListView의 getView와 같은 역할로, 화면에 뷰를 그려줌
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    // ② 틀에 데이터만 계속 바꾸어서 넣어줌(데이터 바인딩)!
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = items.get(position);
        holder.setItem(movie);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // ViewHolder : View들의 책꽂이로, View들을 모아둔다. 내부 클래스로 만들기
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // 규칙 1
        private TextView tvTitle;
        private ImageView ivImgResource;

        public MyViewHolder(@NonNull View itemView) {
            // 화면 사이즈만큼만 ViewHolder에 알아서 담아줌
            super(itemView);
            // 규칙 2 - 틀 그릴 때(onCreateViewHolder)는 여기를 호출
            tvTitle = itemView.findViewById(R.id.tv_title);
            ivImgResource = itemView.findViewById(R.id.iv_img_resource);

        }

        // 규칙 3 - 데이터 바인딩(onBindViewHolder)은 여기를 호출
        public void setItem(Movie movie) {
            tvTitle.setText(movie.getTitle());
            ivImgResource.setImageResource(movie.getImageResource());
        }
    }
}
