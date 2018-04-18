package com.example.abhilash.fireproj;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Artistlist extends ArrayAdapter<Artist> {

    private Activity context;
    private List<Artist> artistList;


    public Artistlist(Activity context,List<Artist> artistList)
    {
        super(context,R.layout.list_layout,artistList );
        this.context = context;
        this.artistList = artistList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textviewname);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.textViewgenre);
        Artist artist = artistList.get(position);
        textViewName.setText(artist.getArtistname());
        textViewGenre.setText(artist.getArtistgenre());
          return  listViewItem;

    }
}
