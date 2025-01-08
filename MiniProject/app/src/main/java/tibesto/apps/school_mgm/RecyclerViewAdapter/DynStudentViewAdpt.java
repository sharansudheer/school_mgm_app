package tibesto.apps.school_mgm.RecyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import java.util.List;

public class DynStudentViewAdpt  extends RecyclerView.Adapter<DynStudentViewAdpt.StudentViewHolder> {

    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_card, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.studentName.setText(student.getFirstName() + " " + student.getLastName());
        holder.messageStatus.setText("Messages");
        holder.feeStatus.setText("Fee Status");

        // Click listener for the card
        holder.cardView.setOnClickListener(v -> {
            // Handle card click
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView studentName, messageStatus, feeStatus;
        MaterialCardView cardView;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.studentName);
            messageStatus = itemView.findViewById(R.id.messageStatus);
            feeStatus = itemView.findViewById(R.id.feeStatus);
            cardView = (MaterialCardView) itemView;
        }
    }
}

