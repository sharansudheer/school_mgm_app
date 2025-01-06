package tibesto.apps.school_mgm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    MaterialToolbar toolBar;
    Menu menu;
    NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dashboard_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_drawer_view);
        toolBar=findViewById(R.id.topAppBar);
        navigationView.bringToFront();
        toggle=new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        menu = navigationView.getMenu();
        menu.findItem(R.id.nav_login).setVisible(false);
//        menu.findItem(R.id.nav_home).setVisible(false);
        navigationView.setCheckedItem(R.id.navigation_drawer_view);
        toolBar=findViewById(R.id.topAppBar);
        setSupportActionBar(toolBar);

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        if (item.getItemId() == R.id.action_logout) {
            logOut();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void logOut() {}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int itemId = menuItem.getItemId();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}