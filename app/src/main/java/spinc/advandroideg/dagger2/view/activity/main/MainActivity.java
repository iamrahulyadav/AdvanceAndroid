package spinc.advandroideg.dagger2.view.activity.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.test.xyz.daggersample.view.navdrawer.FragmentDrawer;
import com.test.xyz.daggersample.R;

public class MainActivity extends ActionBarActivity implements FragmentDrawer.FragmentDrawerListener {
    private final static String TAG = MainActivity.class.getSimpleName();
    private final static int REPO_LIST_FRAG = 0;
    private final static int WEATHER_FRAG = 1;
    private final static int FRAGMENT_COUNT = WEATHER_FRAG + 1;
    private final static String CURRENT_FRAGMENT = "currentFragment";

    private final Fragment[] fragments = new Fragment[FRAGMENT_COUNT];

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    private int currentFragment = REPO_LIST_FRAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        hideAllFragments();

        // display the first navigation drawer view on app launch
        if (savedInstanceState != null) {
            currentFragment = savedInstanceState.getInt(CURRENT_FRAGMENT);
        }

        showFragment(currentFragment);
    }

    private void hideAllFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragments[0] = fragmentManager.findFragmentById(R.id.repolist_frag);
        fragments[1] = fragmentManager.findFragmentById(R.id.main_frag);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        for (int i = 0; i < fragments.length; ++i) {
            fragmentTransaction.hide(fragments[i]);
        }

        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        showFragment(position);
    }

    private void showFragment(int fragmentIndex) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        String title = "";

        switch (fragmentIndex) {
            case REPO_LIST_FRAG:
                title = getString(R.string.nav_item_repo_list);
                break;
            case WEATHER_FRAG:
                title = getString(R.string.nav_item_main);
                break;
            default:
                break;
        }

        for (int i = 0; i < fragments.length; i++) {
            if (i == fragmentIndex) {
                transaction.show(fragments[i]);
            } else {
                transaction.hide(fragments[i]);
            }
        }

        transaction.commit();
        currentFragment = fragmentIndex;
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onSaveInstanceState(Bundle savedState) {
        savedState.putInt(CURRENT_FRAGMENT, currentFragment);
        super.onSaveInstanceState(savedState);
    }
}