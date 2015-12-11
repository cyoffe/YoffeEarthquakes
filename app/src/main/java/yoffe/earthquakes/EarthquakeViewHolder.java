package yoffe.earthquakes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class EarthquakeViewHolder extends RecyclerView.ViewHolder {
    private TextView placeLabel;
    private TextView place;
    private TextView timeLabel;
    private TextView time;
    private TextView magLabel;
    private TextView mag;


    public EarthquakeViewHolder(View itemView) {
        super(itemView);
        place = (TextView) itemView.findViewById(R.id.place);
        time = (TextView) itemView.findViewById(R.id.time);
        mag = (TextView) itemView.findViewById(R.id.mag);

    }

    public void bind(Feature earthquake){
        place.setText("LOCATION: " + earthquake.getProperties().getPlace());
        time.setText("TIME: " + String.valueOf(earthquake.getProperties().getTime()));
        mag.setText("MAGNITUDE: " +String.valueOf(earthquake.getProperties().getMag()));
    }
}
