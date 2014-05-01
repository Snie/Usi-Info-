package com.example.labarista;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;

public class WaitActivity extends Activity {
	String[] tavolo1= {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ",};
	ListAdapter adapter = null;
	ListView card = null;
	int counter = 0;
	PopupMenu popup;
	PopupMenu popup2;
	int pos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wait);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wait, menu);
		return true;
	}
	

	public void ordine(View view) {
		setContentView(R.layout.order);
		card = (ListView)findViewById(R.id.listView1);
		popup = new PopupMenu(this, view);
		popup2 = new PopupMenu(this, view);
		getMenuInflater().inflate(R.menu.comanda, popup2.getMenu());
		
	
	
	card.setOnItemClickListener(
	        new OnItemClickListener()
	        {

	            @Override
	            public void onItemClick(AdapterView<?> arg0, View view,
	                    int position, long id) {
	                // TODO Auto-generated method stub
	            	pos = position;
	                Object o = card.getItemAtPosition(position);
	                String pen = o.toString();
	        		popup2.show();
	        		popup2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
	        			public boolean onMenuItemClick(MenuItem item) {
	        				switch(item.getItemId()){
	        				default:
	        					break;
	        				case R.id.command:
	        					String[] end = new String[tavolo1.length-1];
	        					for (int index=0; index < pos; index++){
	        						end[index] = tavolo1[index];
	        					}
	        					for (int index = pos+1; index < tavolo1.length; index ++){
	        						end[index-1] = tavolo1[index];
	        					}
	        					tavolo1 = end;
	        					card.setAdapter(asd(tavolo1));
	        					
	        				}
	        				
	        			    return true;
	        			}
	        		});
	            }   
	        }    
	        
	);}
	
	
	public void drinks(View view) {
		getMenuInflater().inflate(R.menu.bevande, popup.getMenu());
		popup.show();
		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
			    return true;
			}
		});
		popup = new PopupMenu(this, view);

	}
	public void entrances(View view) {
		getMenuInflater().inflate(R.menu.antipasti, popup.getMenu());
		popup.show();
		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
			    return true;
			}
		});
		popup = new PopupMenu(this, view);
	}
	public void seconds(View view) {
		getMenuInflater().inflate(R.menu.secondi, popup.getMenu());
		popup.show();
		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
			    return true;
			}
		});
		popup = new PopupMenu(this, view);
	}
	public void first(View view) {
		getMenuInflater().inflate(R.menu.primi, popup.getMenu());
		popup.show();
		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
			    return true;
			}
		});
		popup = new PopupMenu(this, view);
	}
	
	public void desserts(View view) {
		
		getMenuInflater().inflate(R.menu.dessert, popup.getMenu());
		popup.show();
		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				switch(item.getItemId()){
				default:
					break;
				case R.id.torta:
					tavolo1[counter]="Torta Della Nonna";
					card.setAdapter(asd(tavolo1));
					counter +=1;
					break;
				case R.id.panna:
					tavolo1[counter]="Panna Cotta";
					card.setAdapter(asd(tavolo1));
					counter +=1;
					break;
				case R.id.mer:
					tavolo1[counter]="Meringues";
					card.setAdapter(asd(tavolo1));
					counter +=1;
					break;
				case R.id.icec:
					tavolo1[counter]="Ice Cream";
					card.setAdapter(asd(tavolo1));
					counter +=1;
					break;
				case R.id.cres:
					tavolo1[counter]="Crepes suzettes";
					card.setAdapter(asd(tavolo1));
					counter +=1;
					break;
				}
				
			    return true;
			}
		});	
		popup = new PopupMenu(this, view);
	}
	public ListAdapter asd(String[] mona){
		adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1,tavolo1);
		return adapter;
	}


	
	

	


}
