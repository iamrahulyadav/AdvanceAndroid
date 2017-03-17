package spinc.advandroideg.dagger2.ui;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import spinc.advandroideg.R;
import spinc.advandroideg.dagger2.service.api.HelloService;
import spinc.advandroideg.dagger2.service.di.DaggerApplication;

public class Dagger2Activity extends AppCompatActivity implements View.OnClickListener {

    @Inject
    HelloService helloService;

    EditText userNameText;

    Button greetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerApplication.component().inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        greetButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.greet) {
            String greetMessage = helloService.greet(userNameText.getText().toString());

            Snackbar mySnackbar = Snackbar.make(this.findViewById(R.id.activity_main_container),
                    greetMessage,
                    Snackbar.LENGTH_LONG);

            mySnackbar.show();
        }
    }
}
