package com.inno.ilyadmt.youknownothingjs.Activities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.inno.ilyadmt.youknownothingjs.Adapters.CharListAdapter;
import com.inno.ilyadmt.youknownothingjs.Util.HttpHandler;
import com.inno.ilyadmt.youknownothingjs.Models.CharacterDAO;
import com.inno.ilyadmt.youknownothingjs.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int page, pageSize;
    private ProgressDialog pDialog;
    private String url = "https://www.anapioficeandfire.com/api/characters";
    String TAG = "MAINTAG";
    private ArrayList<CharacterDAO> characterDAOs;
    CharListAdapter charListAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        characterDAOs = new ArrayList<>();
        page = 1;
        pageSize = 20;
        new GetCharacterList().execute();

    }

    private class GetCharacterList extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (pDialog.isShowing())
                pDialog.dismiss();
            recyclerView = (RecyclerView)findViewById(R.id.rv_charlist);
            charListAdapter = new CharListAdapter(characterDAOs, MainActivity.this);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(charListAdapter);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            characterDAOs = new ArrayList<>();
            HttpHandler handler = new HttpHandler();
            String jsonStr = handler.makeServiceCall(buildURL());
            if (jsonStr != null) {
                try {

                    // Getting JSON Array node
                    JSONArray contacts = new JSONArray(jsonStr);

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);
                        String name = c.getString("name");
                        String url = c.getString("url");
                        String born = c.getString("born");
                        String died = c.getString("died");
                        String culture = c.getString("culture");
                        ArrayList<String> titles = new ArrayList<>();
                        for(int j = 0; j < c.getJSONArray("titles").length(); j++){
                            titles.add(c.getJSONArray("titles").getString(j));
                        }
                        ArrayList<String> aliases = new ArrayList<>();
                        for(int j = 0; j < c.getJSONArray("aliases").length(); j++){
                            aliases.add(c.getJSONArray("aliases").getString(j));
                        }

                        characterDAOs.add(new CharacterDAO(url, name, culture, born, died, titles, aliases));

                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }

            return null;
        }
    }

    private String buildURL(){
        return url + "?page=" + page + "&pageSize=" +pageSize;
    }

    public void nextPage(View view) {
        page++;
        new GetCharacterList().execute();
    }
    public void prevPage(View view) {
        if(page == 1){
            Toast.makeText(MainActivity.this, "You are on the first page!", Toast.LENGTH_SHORT).show();
        }
        else{
            page--;
            new GetCharacterList().execute();
        }
    }
}
