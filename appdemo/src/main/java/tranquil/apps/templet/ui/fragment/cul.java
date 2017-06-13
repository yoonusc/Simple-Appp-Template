/*
 * Copyright 2015 Rudson Lima
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tranquil.apps.templet.ui.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tranquil.apps.templet.R;
import tranquil.apps.templet.adapter.RowItem;

public class cul extends ListFragment  implements AdapterView.OnItemClickListener {

    private boolean mSearchCheck;
    private static final String TEXT_FRAGMENT = "TEXT_FRAGMENT";
	ListView list;
	View rootView;
	int imgid;
	String[] menutitles;
	String[] prize;
	String[] date;
	TypedArray menuIcons;

	CustomAdapter2 adapter;
	private List<RowItem> rowItems;

	public static cul newInstance(String text){
		cul mFragment = new cul();
		Bundle mBundle = new Bundle();
		mBundle.putString(TEXT_FRAGMENT, text);
		mFragment.setArguments(mBundle);
		return mFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub		
		View rootView = inflater.inflate(R.layout.fragcul, container, false);

		TextView mTxtTitle = (TextView) rootView.findViewById(R.id.txtTitle);
		// mTxtTitle.setText(getArguments().getString(TEXT_FRAGMENT));

		//rootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		return inflater.inflate(R.layout.fragcul, null, false);
	}

	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);
		menutitles = getResources().getStringArray(R.array.eventcul);
		menuIcons = getResources().obtainTypedArray(R.array.iconcul);
		prize=getResources().getStringArray(R.array.prizcul);
		date=getResources().getStringArray(R.array.datecul);

		rowItems = new ArrayList<RowItem>();

		for (int i = 0; i < menutitles.length; i++) {
			RowItem items = new RowItem(menutitles[i], prize[i],date[i],menuIcons.getResourceId(
					i, -1));

			rowItems.add(items);
		}

		adapter = new CustomAdapter2(getActivity(), rowItems);
		setListAdapter(adapter);
		getListView().setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
							long id) {

		Toast.makeText(getActivity(), menutitles[position], Toast.LENGTH_SHORT)
				.show();

	}
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.menu, menu);
        
        //Select search item
        final MenuItem menuItem = menu.findItem(R.id.menu_search);
        menuItem.setVisible(true);

        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint(this.getString(R.string.search));

        ((EditText) searchView.findViewById(R.id.search_src_text))
                .setHintTextColor(getResources().getColor(R.color.nliveo_white));
        searchView.setOnQueryTextListener(onQuerySearchView);

		menu.findItem(R.id.menu_add).setVisible(true);

		mSearchCheck = false;	
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {

		case R.id.menu_add:
           // Toast.makeText(getActivity(), R.string.add, Toast.LENGTH_SHORT).show();
			break;

		case R.id.menu_search:
			mSearchCheck = true;
           // Toast.makeText(getActivity(), R.string.search, Toast.LENGTH_SHORT).show();
			break;
		}
		return true;
	}	

   private SearchView.OnQueryTextListener onQuerySearchView = new SearchView.OnQueryTextListener() {
       @Override
       public boolean onQueryTextSubmit(String s) {
           return false;
       }

       @Override
       public boolean onQueryTextChange(String s) {
           if (mSearchCheck){
               // implement your search here
           }
           return false;
       }
   };
}
