package tranquil.apps.templet.adapter;

public class RowItem {

	private String title,prize,date;
	private int icon;

	public RowItem(String title,String prize,String date, int icon) {
		this.title = title;
		this.prize = prize;
		this.date= date;
		this.icon = icon;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getprize() {
		return prize;
	}

	public void setPrize(String prizew) {
		this.prize = prizew;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date =date;
	}



	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

}
