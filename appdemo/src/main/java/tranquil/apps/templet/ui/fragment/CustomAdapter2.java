package tranquil.apps.templet.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tranquil.apps.templet.R;
import tranquil.apps.templet.adapter.RowItem;

public class CustomAdapter2 extends BaseAdapter {

	Context context;
	List<RowItem> rowItem;

	CustomAdapter2(Context context, List<RowItem> rowItem) {
		this.context = context;
		this.rowItem = rowItem;

	}

	@Override
	public int getCount() {

		return rowItem.size();
	}

	@Override
	public Object getItem(int position) {

		return rowItem.get(position);
	}

	@Override
	public long getItemId(int position) {

		return rowItem.indexOf(getItem(position));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(R.layout.list_item2, null);
		}

		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imageView_round);
		TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
		TextView prize = (TextView) convertView.findViewById(R.id.prize);
		TextView  Date = (TextView) convertView.findViewById(R.id.date);



		RowItem row_pos = rowItem.get(position);
		// setting the image resource and title
		imgIcon.setImageResource(row_pos.getIcon());
		txtTitle.setText(row_pos.getTitle());
		prize.setText(row_pos.getprize());
		Date.setText(row_pos.getDate());

		return convertView;

	}

}
