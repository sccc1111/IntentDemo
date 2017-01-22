package tmp.com.cn.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
    }

    public void openA1(View view) {
        Intent i = new Intent(MainActivity.this,AActivity.class);
        startActivity(i);
    }

    public void openA2(View view) {
        Intent i = new Intent();
        i.setAction("android.intent.action.DEMO_ACTIVITY");
        startActivity(i);
    }

    public void callPhone(View view) {
        Intent i = new Intent();
        Uri uri = Uri.parse("tel:"+editText.getText());
        i.setAction(Intent.ACTION_CALL);
        i.setData(uri);
        startActivity(i);
    }

    public void callSms(View view) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_SENDTO);
        Uri uri = Uri.parse("smsto:10086");
        i.putExtra("sms_body", editText.getText());
        i.setData(uri);
        startActivity(i);
    }
}
