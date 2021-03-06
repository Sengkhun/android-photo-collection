package com.zaman.sengkhunlim.photocollection;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    private final List<Photo> photos;

    public class PhotoViewHolder extends RecyclerView.ViewHolder {

        TextView owner, dateTaken, description;
        ImageView thumbnail;

        PhotoViewHolder( View itemView ) {
            super(itemView);

            this.owner = itemView.findViewById( R.id.owner );
            this.dateTaken = itemView.findViewById( R.id.date_taken );
            this.thumbnail = itemView.findViewById( R.id.thumbnail );
            this.description = itemView.findViewById( R.id.description );

        }

    }

    public PhotoAdapter( List<Photo> photos ) {

        this.photos = photos;

    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from( context );
        View containerView = inflater.inflate( R.layout.adapter_photo, parent, false );

        return new PhotoAdapter.PhotoViewHolder( containerView );

    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {

        Photo currentPhoto = this.photos.get( position );

        holder.owner.setText( currentPhoto.getOwner() );
        holder.dateTaken.setText( currentPhoto.getDatetaken() );
        holder.description.setText( currentPhoto.getTitle() );

        // Image
        SimpleDraweeView image = (SimpleDraweeView) holder.thumbnail;
        image.setImageURI( currentPhoto.getUrlH() );

    }

    @Override
    public int getItemCount() { return this.photos.size(); }

}
