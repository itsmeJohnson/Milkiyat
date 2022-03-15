package com.johnsonsoftwares.milkiyat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.johnsonsoftwares.milkiyat.Adapters.CardListAdapter;
import com.johnsonsoftwares.milkiyat.Adapters.CardTopPicksAdapter;
import com.johnsonsoftwares.milkiyat.Adapters.CatogoriesAdapter;
import com.johnsonsoftwares.milkiyat.Adapters.LatestListAdapter;
import com.johnsonsoftwares.milkiyat.Adapters.SubListAdapter;
import com.johnsonsoftwares.milkiyat.model.Categories;
import com.johnsonsoftwares.milkiyat.model.Items;
import com.johnsonsoftwares.milkiyat.model.Listings;
import com.johnsonsoftwares.milkiyat.model.SubItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigationView;
    RequestQueue requestQueue;
    String url = WebUrls.TESTURL;
    ArrayList<Categories> categoriesArrayList;
    ArrayList<Items> itemsArrayList;
    ArrayList<Listings> listingsArrayList;
    ArrayList<SubItems> subItemsArrayList;
    RecyclerView cardsRecyclerView, listings, categoriestRecycler;
    CardListAdapter cardListAdapter;
    CatogoriesAdapter catogoriesAdapter;
    CardTopPicksAdapter cardTopPicks;
    SubListAdapter subListAdapter;
    LatestListAdapter latestListAdapter;
    TextView txt_top_picks, txtlatest;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemsArrayList = new ArrayList<>();
        listingsArrayList = new ArrayList<>();
        subItemsArrayList = new ArrayList<>();
        categoriesArrayList = new ArrayList<>();

        inits();
        requestQueue = Volley.newRequestQueue(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.themebackground));
        getDataFromApi();



    }

    private void getDataFromApi() {
        progressDialog.setMessage("Please wait");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    int count = 0;
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray categoriesArray = jsonObject.getJSONArray("categories");
                    for(int k=0;k<categoriesArray.length();k++){
                        JSONObject category = categoriesArray.getJSONObject(k);
                        String name = category.getString("name");
                        String slug = category.getString("slug");
                        String icon = category.getString("icon");
                        categoriesArrayList.add(new Categories(name,slug,icon));
                    }
                    catogoriesAdapter = new CatogoriesAdapter(categoriesArrayList,MainActivity.this);
                    categoriestRecycler.setHasFixedSize(true);
                    categoriestRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                    categoriestRecycler.setItemAnimator(new DefaultItemAnimator());
                    categoriestRecycler.setAdapter(catogoriesAdapter);



                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    listingsArrayList.clear();
                    subItemsArrayList.clear();
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject data = jsonArray.getJSONObject(i);
                        if(data.getString("type").equals(datas.slides)){
                            JSONArray items = data.getJSONArray("items");
                            for(int j=0;j<items.length();j++){
                                JSONObject item = items.getJSONObject(j);
                                //Log.d("res", item.toString());
                                itemsArrayList.add(new Items(item.getString("title"),item.getString("image"),item.getString("link")));
                            }

                        }
                        if(data.getString("type").equals(datas.listing)){
                            count ++;
                            String type = data.getString("type");
                            String title = data.getString("title");
                            String summary = data.getString("summary");
                            String icon = data.getString("icon");
                            String two_line = data.getString("two_line");
                            JSONArray items = data.getJSONArray("items");
                            for(int item=0;item<items.length();item++){
                                JSONObject itemObject = items.getJSONObject(item);
                                String itemTitle = itemObject.getString("title");
                                int min_price = itemObject.getInt("min_price");
                                int price = itemObject.getInt("price");
//                                convertPrice(price);
                                String listing_id = itemObject.getString("listing_id");
                                String created_since = itemObject.getString("created_since");
                                String updated_since = itemObject.getString("updated_since");
                                String category_slug = itemObject.getString("category_slug");
                                String slug = itemObject.getString("slug");
                                String thumbnail = itemObject.getString("thumbnail");
                                String is_spam = itemObject.getString("is_spam");
                                String is_premium = itemObject.getString("is_premium");
                                String is_verified = itemObject.getString("is_verified");
                                String expiry_date = itemObject.getString("expiry_date");
                                String offer = itemObject.getString("offer");
                                String is_chat_allowed = itemObject.getString("is_chat_allowed");
                                String is_offensive = itemObject.getString("is_offensive");
                                String is_auction = itemObject.getString("is_auction");
                                String out_kashmir = itemObject.getString("out_kashmir");
                                String viewers = itemObject.getString("viewers");
                                String status = itemObject.getString("status");
                                String locality = itemObject.getString("locality");
                                String city = itemObject.getString("city");
                                String posted = itemObject.getString("posted");
                                String in_wishlist = itemObject.getString("in_wishlist");
                                subItemsArrayList.add(new SubItems(itemTitle,min_price,price,listing_id,created_since,updated_since,category_slug,slug,thumbnail,is_spam,is_premium,is_verified,expiry_date,offer,is_chat_allowed,is_offensive,is_auction,out_kashmir,viewers,status,locality,city,posted,in_wishlist));

                            }
                            listingsArrayList.add(new Listings(type,title,summary,icon,two_line,subItemsArrayList));

                            Log.d("itemsres",title+ " "+type + " "+summary+ " ");
                            //cardTopPicks = new CardTopPicksAdapter(itemsArrayList,MainActivity.this);
//                            cardTopPics.setHasFixedSize(true);
//                            cardTopPics.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
//                            cardTopPics.setItemAnimator(new DefaultItemAnimator());
//                            cardTopPics.setAdapter(cardTopPicks);
                        }


                    }

                    subListAdapter = new SubListAdapter(listingsArrayList,MainActivity.this);
                    listings.setHasFixedSize(true);
                    listings.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
                    listings.setItemAnimator(new DefaultItemAnimator());
                    listings.setAdapter(subListAdapter);
                    //
                    Log.d("resArray",itemsArrayList.toString());
                    cardListAdapter = new CardListAdapter(itemsArrayList,MainActivity.this);
                    cardsRecyclerView.setHasFixedSize(true);
                    cardsRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                    cardsRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    cardsRecyclerView.setAdapter(cardListAdapter);
                    progressDialog.dismiss();
                    //Top Pics

                    //Latest Pics
//                    latestListAdapter = new LatestListAdapter(itemsArrayList,MainActivity.this);
//                    cardlatest.setHasFixedSize(true);
//                    cardlatest.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
//                    cardlatest.setItemAnimator(new DefaultItemAnimator());
//                    cardlatest.setAdapter(latestListAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, ""+error, Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        });
        requestQueue.add(stringRequest);
    }




    private void inits() {
        progressDialog = new ProgressDialog(this);
        txt_top_picks = findViewById(R.id.text_top_picks);
        txtlatest = findViewById(R.id.text_latest);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        cardsRecyclerView = findViewById(R.id.cardsrecyclerview);
        categoriestRecycler = findViewById(R.id.category_recyclerview);
        listings = findViewById(R.id.listings);
       // cardTopPics = findViewById(R.id.card_top_picks);
        //cardlatest = findViewById(R.id.card_latest);

    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                //Toast.makeText(this, "You are in Home Screen", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.explore:
                Toast.makeText(this, "Under development", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.saved:
                Toast.makeText(this, "Under Development", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.notifications:
                Toast.makeText(this, "Under Development", Toast.LENGTH_SHORT).show();

                return true;
        }
        return false;
    }
}