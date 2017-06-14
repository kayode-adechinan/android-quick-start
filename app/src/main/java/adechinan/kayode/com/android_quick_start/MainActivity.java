package adechinan.kayode.com.android_quick_start;

import adechinan.kayode.com.android_quick_start.domains.category.CategoryAdapter;
import adechinan.kayode.com.android_quick_start.domains.category.CategoryPojo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CategoryPojo categoryPojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryPojo = new CategoryPojo();
        categoryPojo.setImage("bulgar");
        categoryPojo.setText("Bulgar");
        categoryPojo.save();

        recyclerView = (RecyclerView)findViewById(R.id.category_menu);
        GridLayoutManager mGrid = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mGrid);
        recyclerView.setHasFixedSize(true);

        List<CategoryPojo> imageSugar = CategoryPojo.listAll(CategoryPojo.class);

        CategoryAdapter mAdapter = new CategoryAdapter(this, imageSugar);
        recyclerView.setAdapter(mAdapter);
    }
}
