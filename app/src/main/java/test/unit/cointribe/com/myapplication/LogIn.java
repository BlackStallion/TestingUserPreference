package test.unit.cointribe.com.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cointribe.free.BuildData;
import com.cointribe.networks.CommonNetworkClass;
import com.com.cointribe.Interface.ResponseData;
import com.com.cointribe.utils.Constants;
import com.com.cointribe.utils.Log;
import com.com.cointribe.utils.TokenSavedData;
import com.com.cointribe.utils.UtilityConstant;
import com.google.common.cache.Cache;
import com.unit.test.LoginPresenter;
import com.unit.test.LoginService;
import com.unit.test.LoginView;

import org.json.JSONException;
import org.json.JSONObject;

import static android.widget.Toast.LENGTH_SHORT;

public class LogIn extends AppCompatActivity implements LoginView, View.OnClickListener,ResponseData {

    private EditText usernameView;
    private EditText passwordView;
    private LoginPresenter presenter;
    private Button btn_LogIn;
    ProgressDialog pDialog;
    private Context context=null;
    String TAG = "LogIn";
    int statusCode=0;
    boolean bool_response=false;
    Cache<String,String> cache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        usernameView = (EditText) findViewById(R.id.username);
        passwordView = (EditText) findViewById(R.id.password);
        btn_LogIn= (Button) findViewById(R.id.login);

        presenter = new LoginPresenter(this, new LoginService(this));
        context=LogIn.this;
        pDialog = new ProgressDialog(context);
        getAccessToken(context);
        btn_LogIn.setOnClickListener(this);
    }

    private void getAccessToken(Context context) {
        JSONObject params = new JSONObject();
        params = TokenSavedData.SetAccessTokenToJsonObject(context, params);
        int flags = Constants.FLAG_SHOW_LOGS | Constants.FLAG_SHOW_LOADER;
        new CommonNetworkClass(context).NetworkHandlerResponseData(context,flags,pDialog,Constants.TAUTH_SERVICE_INITIALIZE_TOKEN,Constants.ID_TOKEN,params);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override
    public String getUsername() {
        return usernameView.getText().toString();
    }

    @Override
    public void showUsernameError(int resId) {

        usernameView.setError(getString(resId));
    }

    @Override
    public String getPassword() {
        return passwordView.getText().toString();
    }

    @Override
    public void showPasswordError(int resId) {
        passwordView.setError(getString(resId));
    }

    @Override
    public void startMainActivity() {
//        new ActivityUtil(this).startMainActivity();

    }

    @Override
    public void showLoginError(int resId) {
        Toast.makeText(this, getString(resId), LENGTH_SHORT).show();
    }

    @Override
    public void showLogInSuc(int resId) {


        String strActivityName= BuildData.noOfActivityTesting("LogIn");
        Log.d(TAG,"ActivityName   "+strActivityName);

        try {
            UtilityConstant.StartActivity(LogIn.this,"test.unit.cointribe.com.myapplication."+strActivityName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View view) {

        presenter.onLoginClicked();
    }

    @Override
    public void responseData(int statusCode, String responseData, String PresentUrl, int URL_ID, boolean bool_response) {
        Log.d(TAG, "MAIDUL TESTING>>>>>>>>>>>>>>>>>>>>>>>>" + statusCode);
        switch (statusCode){
            case 200:
                switch (URL_ID){
                    case Constants.ID_TOKEN:
                        Log.d(TAG, "MAIDUL TESTING>>>>>>>>>>>>>>>>>>>>>>>>" + statusCode);
                        Log.d(TAG, "MAIDUL TESTING>>>>>>>>>>>>>>>>>>>>>>>> responseData \n" + responseData);
                        this.statusCode=statusCode;
                        this.bool_response=bool_response;

                        try {
                            JSONObject a = new JSONObject(responseData);
                            JSONObject b = a.getJSONObject("token");
                            TokenSavedData.savePreferencesToken("token", b.toString(), LogIn.this);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;
                    case Constants.ID_LOGIN:
                        this.bool_response=bool_response;
                        this.statusCode=statusCode;
                        presenter.setResponse(bool_response);

                        break;
                    default:
                        break;
                }
                break;
            case 400:
                Toast.makeText(context,"Bad Token ",Toast.LENGTH_SHORT).show();
                break;
            default:
                this.statusCode=statusCode;
        }
    }


//    public void uerLogIn(String username, String password) {
//        JSONObject params = new JSONObject();
//        params = TokenSavedData.SetAccessTokenToJsonObject(getApplicationContext(), params);
//        JSONObject a = new JSONObject();
//
//        try {
//            a.put("mobile", username);
//            a.put("pin", password);  //need to change
//            params.put("data", a);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        Log.e("login params", params.toString());
//        int flags = Constants.FLAG_SHOW_LOGS | Constants.FLAG_SHOW_LOADER;
//        new CommonNetworkClass(getApplicationContext()).NetworkHandlerResponseData(getApplicationContext(),flags,pDialog,Constants.URL_LOGIN,Constants.ID_TOKEN,params);
//
//
//
//    }
}
