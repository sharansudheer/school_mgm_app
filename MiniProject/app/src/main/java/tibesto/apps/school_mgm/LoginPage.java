package tibesto.apps.school_mgm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.Retrofit;


public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        = retrofit.create(.class);
//        Call<> call = .Call("","application/json");

        Button openFragSignUp = findViewById(R.id.bt_sign_up);
        openFragSignUp.setOnClickListener(v -> openFragment());

        Button openDash = findViewById(R.id.bt_login);
        openDash.setOnClickListener(v -> {
            // Intent to open SecondActivity
            Intent intent = new Intent(LoginPage.this, MainDashboard.class);
            startActivity(intent);
        });


    }
    private void openFragment() {
        SignUp signUpFragment = new SignUp();
        ConstraintLayout mainPage = findViewById(R.id.mainView);
        mainPage.setVisibility(View.GONE);

        // Replace the container with the new fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.signupFrag, signUpFragment)
                .addToBackStack(null) // Add to back stack for navigation
                .commit();
    }
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
            // Show main activity layout
            ConstraintLayout mainPage = findViewById(R.id.mainView);
            mainPage.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }
}