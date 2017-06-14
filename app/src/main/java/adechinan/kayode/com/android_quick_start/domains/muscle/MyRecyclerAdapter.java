package adechinan.kayode.com.android_quick_start.domains.muscle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atsk1618 on 4/5/2017.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MuscleViewHolder> {

    static Context context;
    private List<Muscle> muscles;

    public MyRecyclerAdapter(Context context, List<Muscle> muscles) {
        this.muscles = new ArrayList<Muscle>();
        this.context = context;
        this.muscles.addAll(muscles);
    }

    @Override
    public MuscleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_view, viewGroup, false);

        return new MuscleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MuscleViewHolder muscleViewHolder, int i) {
        Muscle muscle = muscles.get(i);
        muscleViewHolder.name.setText(muscle.getName());
        muscleViewHolder.imageID.setImageResource(muscle.getImageID());

    }

    @Override
    public int getItemCount() {
        return muscles.size();
    }


    public  class MuscleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        protected TextView name;
        protected ImageView imageID;
        protected ImageView overflow;
        protected CardView card;

    /*static Context context;*/

        public MuscleViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.title);
            imageID = (ImageView)itemView.findViewById(R.id.thumbnail);
            card = (CardView) itemView;
            overflow = (ImageView) itemView.findViewById(R.id.overflow);
            imageID.setOnClickListener(this);
            overflow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showPopupMenu(overflow);
                }
            });

        }

        @Override
        public void onClick(View view) {

        Intent intent = new Intent(context,DetailsMuscleActivity.class);
        Bundle extras = new Bundle();
        extras.putInt("position",getAdapterPosition());
        intent.putExtras(extras);
        context.startActivity(intent);


        }



    }


    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(context, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_muscle_context, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(context, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(context, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }




}