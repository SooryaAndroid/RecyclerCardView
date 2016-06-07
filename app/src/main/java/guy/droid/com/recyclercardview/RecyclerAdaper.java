package guy.droid.com.recyclercardview;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

import static android.os.Build.*;

/**
 * Created by admin on 6/7/2016.
 */
public class RecyclerAdaper extends RecyclerView.Adapter<RecyclerAdaper.ViewHolder> {
    ArrayList<String> names;
    ArrayList<String> desg;
    public RecyclerAdaper(ArrayList<String> names, ArrayList<String> dest) {
        this.names = names;
        this.desg = dest;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_child,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(names.get(position));
        holder.textView2.setText(desg.get(position));
       // holder.cardView.setAnimation(holder.animation);
        if(VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP)
        {
            holder.cardView.setStateListAnimator(holder.animator);

        }

    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView,textView2;
        CardView cardView;
        int v = VERSION.SDK_INT;

      StateListAnimator animator;
        public ViewHolder(View itemView) {
            super(itemView);


            textView = (TextView)itemView.findViewById(R.id.texts);
            textView2 = (TextView)itemView.findViewById(R.id.dest);
            cardView = (CardView)itemView.findViewById(R.id.cards);
            if(VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP)
            {
                animator = AnimatorInflater
                        .loadStateListAnimator(itemView.getContext(), R.anim.slide_in_right);

            }
            textView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println(names.get(getAdapterPosition()));
                }
            });

        }
    }
}
