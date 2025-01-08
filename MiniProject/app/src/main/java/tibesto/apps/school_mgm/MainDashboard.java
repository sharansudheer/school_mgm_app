package tibesto.apps.school_mgm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;
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

    //////MAIN CODE ////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_drawer_view);
        toolBar = findViewById(R.id.topAppBar);
        navigationView.bringToFront();
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
//        menu = navigationView.getMenu();
//        menu.findItem(R.id.nav_login).setVisible(false);
//        menu.findItem(R.id.nav_home).setVisible(false);
        navigationView.setCheckedItem(R.id.navigation_drawer_view);
        toolBar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolBar);

        Button manageStd = findViewById(R.id.mgStudentButton);
        manageStd.setOnClickListener(v -> {
            Toast.makeText(MainDashboard.this, "MainDashboard Button clicked!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainDashboard.this, AddBatch.class);
            startActivity(intent);
        });
        MaterialCardView messages = findViewById(R.id.messagesCard);

        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainDashboard.this, "MainDashboard Button clicked!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainDashboard.this, AddBatch.class);
                startActivity(intent);
            }
        });
    }


    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int itemId = menuItem.getItemId();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}