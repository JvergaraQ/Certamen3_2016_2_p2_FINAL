package cl.telematica.android.certamen3_p2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franciscocabezas on 11/18/16.
 */

public class ResultsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    public static final String RESULT = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String data = getIntent().getStringExtra(RESULT);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new DataAdapter(getList(data));
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<Show> getList(String result) {
        List<Show> shows = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(result);
            System.out.print(result);
            System.out.print(jsonArray);
            int size = jsonArray.length();
            for(int i = 0; i < size; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Show show = new Show();
                show.setShowTitle(jsonObject.optString("name"));
                shows.add(show);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return shows;
    }
}
