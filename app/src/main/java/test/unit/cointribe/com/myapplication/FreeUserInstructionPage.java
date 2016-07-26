package test.unit.cointribe.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.common.cache.Cache;

public class FreeUserInstructionPage extends AppCompatActivity {
    Cache<String,String> cache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_user_instruction_page);

    }
}
