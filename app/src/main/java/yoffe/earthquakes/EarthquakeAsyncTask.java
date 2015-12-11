package yoffe.earthquakes;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class EarthquakeAsyncTask extends AsyncTask<Void, Void,EarthquakeListing> {


    private RecyclerView recyclerView;
    private HttpURLConnection httpURLConnection;

    public EarthquakeAsyncTask(RecyclerView recyclerView) {

        this.recyclerView = recyclerView;
    }



    @Override
    protected EarthquakeListing doInBackground(Void... param)  {
        EarthquakeListing earthquakes = null;
        try {
            URL url = new URL("http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson");
            httpURLConnection = (HttpURLConnection) url.openConnection();
            Gson gson = new Gson();
            earthquakes = gson.fromJson(new InputStreamReader(httpURLConnection.getInputStream()), EarthquakeListing.class);

        } catch (IOException e) {
            return null;
            
        }


        return earthquakes;
    }

    @Override
    protected void onPostExecute(EarthquakeListing earthquakes) {
        EarthquakeAdapter adapter = new EarthquakeAdapter(earthquakes.getFeatures());
        recyclerView.setAdapter(adapter);
    }
}
