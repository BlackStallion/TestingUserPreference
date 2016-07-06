package test.unit.cointribe.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class JSONSAMPLE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        String JSONSample="[{\"id\":\"487745454\",\"barcode\":\"84555453\",\"items\":{\"12456788\":{\"id\":\"12456788\",\"name\":\"Item1\"},\"12456789\":{\"id\":\"12456789\",\"name\":\"Item2\"}}},{\"id\":\"487745455\",\"barcode\":\"84555453\",\"items\":{\"12456788\":{\"id\":\"12456788\",\"name\":\"Item1\"},\"12456791\":{\"id\":\"12456789\",\"name\":\"Item10\"}}}]";
//        Gson gson = new Gson();
//        MainModel modelJsonSample=new MainModel();
//        modelJsonSample = gson.fromJson(JSONSample, MainModel.class);

       // Log.d("modelJsonSample","modelJsonSample>>>"+modelJsonSample.getModelJsonSample().get(0).getItems().get(0).getName());

        try {
            JSONObject jsnobject = new JSONObject(JSONSample);
            Iterator iterator = jsnobject.keys();



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
