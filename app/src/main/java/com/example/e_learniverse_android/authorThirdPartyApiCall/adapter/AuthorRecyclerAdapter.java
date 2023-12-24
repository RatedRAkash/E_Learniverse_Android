package com.example.e_learniverse_android.authorThirdPartyApiCall.adapter;

/**
 * Created by AnantaAkashPodder on 24/12/2023.
 */

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_learniverse_android.R;
import com.example.e_learniverse_android.dto.AuthorResponseDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthorRecyclerAdapter extends RecyclerView.Adapter<AuthorRecyclerAdapter.MyViewHolder> implements Filterable {

    private static final String TAG = "AuthorRecyclerAdapter";
    int count = 0;

    //Class er instanceVariables BEGIN
    public List<AuthorResponseDto> authorList;
    List<AuthorResponseDto> authorsListAll; //Filter kora chara Movie er list
    private AuthorRecyclerViewClickInterface authorRecyclerViewClickInterface;
    //Class er instanceVariables END


    public AuthorRecyclerAdapter(List<AuthorResponseDto> authorList, AuthorRecyclerViewClickInterface authorRecyclerViewClickInterface) {
        this.authorList = authorList;
        this.authorsListAll = new ArrayList<>(authorList); //"new" operator nah diya emni this.moviesListAll=moviesList dile... khali REFERENCE pass huito fole... moviesList change korle pore moviesListAll oo change hoya jabe... tai NEW operator use kore amra complete NEW Object create korlam
        System.out.println(authorsListAll);
        this.authorRecyclerViewClickInterface = authorRecyclerViewClickInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.i(TAG, "onCreateViewHolder: " + count++);

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    //
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.authorIDTextView.setText(authorList.get(position).getId().toString());
        holder.textViewName.setText("Name: " + authorList.get(position).getName());
        holder.rowCountAgeTextView.setText("Age: " + authorList.get(position).getAge().toString());
    }

    @Override
    public int getItemCount() {
        return authorList.size();
    }


    //FILTER er Method
    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {

        //"performFiltering" Method BACKGROUD Thread ee kaaj kore
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<AuthorResponseDto> filteredList = new ArrayList<>();

            if(charSequence.toString().isEmpty())
            {
                filteredList.addAll(authorsListAll);
            }
            else
            {
                for(AuthorResponseDto movie: authorsListAll)
                {
                    if(movie.getName().toLowerCase().contains(charSequence.toString().toLowerCase()))
                    {
                        filteredList.add(movie);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;
        }

        //"publishResults" Method UI Thread ee kaaj kore
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            authorList.clear();
            authorList.addAll((Collection<? extends AuthorResponseDto>) filterResults.values);
            notifyDataSetChanged();
        }
    };
    //FILTER Method END



    //MYVIEWHOLDER CLASS BEGIN
    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewName, rowCountAgeTextView, authorIDTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

//            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            rowCountAgeTextView = itemView.findViewById(R.id.rowCountAgeTextView);
            authorIDTextView = itemView.findViewById(R.id.authorIDTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    authorRecyclerViewClickInterface.onItemClick(getAdapterPosition());
                }
            });


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

//                    moviesList.remove(getAdapterPosition()); // Amader created LIST theke Movie ta delete korlam
//                    notifyItemRemoved(getAdapterPosition()); //Eita mane holo Recycler View er theke ROW ta delete kore dilam
                    authorRecyclerViewClickInterface.onLongItemClick(getAdapterPosition());

                    return true; //Item ta nidristio POSITION ee tai "True" return kortase
                }
            });

        }


    }
    //MYVIEWHOLDER CLASS END


}