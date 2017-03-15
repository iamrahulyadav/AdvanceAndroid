package spinc.advandroideg.dagger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.ButterKnife;
import spinc.advandroideg.R;

/**
 * Created by webwerks on 15/3/17.
 * https://blog.mindorks.com/introduction-to-dagger-2-using-dependency-injection-in-android-part-1-223289c2a01b#.9o1pc04lp
 * https://blog.mindorks.com/introduction-to-dagger-2-using-dependency-injection-in-android-part-2-b55857911bcd#.qgwcvp6ha
 *
 * https://mindorks.com/blogs
 *
 */

public class DaggerActivity extends AppCompatActivity implements View.OnClickListener {

    @Inject
    HelloService helloService;

    @InjectView(R.id.userNameText)
    EditText userNameText;

    @InjectView(R.id.greet)
    Button greetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
        DaggerApplication.component().inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        greetButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.greet) {
            String greetMessage = helloService.greet(userNameText.getText().toString());

            Snackbar mySnackbar = Snackbar.make( this.findViewById(R.id.activity_main_container),
                    greetMessage,
                    Snackbar.LENGTH_LONG);

            mySnackbar.show();
        }
    }
}