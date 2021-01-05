package com.americanairlines.myfourthapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.americanairlines.myfourthapplication.R;
import com.americanairlines.myfourthapplication.model.Pizza;
import com.americanairlines.myfourthapplication.view.adapter.PizzaItemAdapter;
import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements PizzaItemAdapter.PizzaDelegate {

    //Imagine this was from a web server - We will be creating mock data
    Pizza extravaganza = new Pizza(
            "Extravaganza",
            24.99, 1000,
            "Mushrooms, Pepperoni, Goat Cheese, Truffles, Spanish Cheese, Gold Flakes, Made with Fiji Water",
            "https://www.thevintagenews.com/wp-content/uploads/2019/04/italian-pizza-with-tomatoes-cheese-and-spices-picture-id514937122-1280x720.jpg");

    Pizza chickenCheese = new Pizza(
            "Chicken Cheese",
            29.99,
            780,
            "Mushrooms, Chicken, Goat Cheese, Calamari, Dried Tuna, Spanish Cheese, Edible Diamond Dust",
            "https://blog.williams-sonoma.com/wp-content/uploads/2019/01/rcp_w19d1_buffalo-chicken-pizza.jpg");

    Pizza vegan = new Pizza(
            "Vegan",
            23.99,
            560,
            "Spinach from Thailand, Goat Cheese, Spanish Cheese, Gold Flakes, Made with Fiji Water",
            "https://cookieandkate.com/images/2016/01/kale-pesto-pizza-recipe-2-1100x1650.jpg");

//      with ArrayAdapter - simple list items(like strings)
//    private String[] pizzas = new String[]{extravaganza.getPizzaFlavor(), chickenCheese.getPizzaFlavor(), vegan.getPizzaFlavor()};
//    private List<String> availablePizzas = Arrays.asList(pizzas);

    //With Base Adapter - more complex items (like custom data classes)
    private Pizza[] pizzas = new Pizza[]{extravaganza, chickenCheese, vegan};
    private List<Pizza> availablePizzas = Arrays.asList(pizzas);
    //EOF mock data setup..

    private ListView pizzaView;
    //private ArrayAdapter<String> pizzaAdapter; //ArrayAdapter

    private PizzaItemAdapter pizzaAdapter = new PizzaItemAdapter(availablePizzas, this);

    private ImageView pizzaImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizzaView = findViewById(R.id.pizza_listview);
        pizzaImageView = findViewById(R.id.pizza_imageview);

        //With ArrayAdapter
        //pizzaAdapter = new ArrayAdapter<String>(this, R.layout.pizza_flavor_layout_item, R.id.pizza_textview, availablePizzas);
        //pizzaView.setAdapter(pizzaAdapter);

        //Set an onclick listener for the click events on 0ur listView...
        //With ArrayAdapter...
//        pizzaView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
//                //Every time the user clicks an item - it displays a toast of the item selected...
//                String name = availablePizzas.get(index);
//                Toast.makeText(HomeActivity.this, name, Toast.LENGTH_SHORT).show();
//
//            }
//        });

        //With Base Adapter
        pizzaView.setAdapter(pizzaAdapter);

    }

    @Override
    public void selectPizza(Pizza selectedPizza) {
        Toast.makeText(HomeActivity.this, selectedPizza.getPizzaFlavor(), Toast.LENGTH_SHORT).show();

        Glide.with(this)
                .load(selectedPizza.getImageUrl())
                .into(pizzaImageView);

    }
}





















