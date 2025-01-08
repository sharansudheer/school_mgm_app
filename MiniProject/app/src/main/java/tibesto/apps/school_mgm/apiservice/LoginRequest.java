package tibesto.apps.school_mgm.apiservice;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface LoginRequest {
        //endpoint /login/teachers
        @POST("/login/teachers")
        Call<Void> login(@Body LoginRequest loginRequest);
}
