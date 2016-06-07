package guy.droid.com.recyclercardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<String> names;
ArrayList<String> dest;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        animation = AnimationUtils.loadAnimation(this, R.anim.push_down_in);
        names = new ArrayList<>();
        dest = new ArrayList<>();


        names.add("Mohamed Rashik");
        names.add("Adarsh");
        names.add("Darsak");

        dest.add("Hybrid");
        dest.add("iOS");
        dest.add("Android");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new RecyclerAdaper(names,dest));
       // recyclerView.setAnimation(animation);


    }
}
