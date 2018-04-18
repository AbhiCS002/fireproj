package com.example.abhilash.fireproj;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by abhilash on 18/4/18.
 */

public class Artist {


    String artistid;
    String artistname;
    String artistgenre;




    public  Artist()
    {

    }

    public Artist(String artistid, String artistname, String artistgenre) {
        this.artistid = artistid;
        this.artistname = artistname;
        this.artistgenre = artistgenre;
    }


    public String getArtistid() {
        return artistid;
    }

    public String getArtistname() {
        return artistname;
    }

    public String getArtistgenre() {
        return artistgenre;
    }
}
