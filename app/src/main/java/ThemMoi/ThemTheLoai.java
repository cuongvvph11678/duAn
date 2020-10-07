package ThemMoi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.manhinhchao.QLNguoiDung;
import com.example.manhinhchao.QLTheLoai;
import com.example.manhinhchao.R;
import com.example.manhinhchao.ThemNguoiDung;

public class ThemTheLoai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_the_loai);
        setTitle("Thêm Thể Loại");
    }
    public  void  Themtl(View view){
        Intent intent =new Intent(ThemTheLoai.this, QLTheLoai.class);
        startActivity(intent);
    }
    public  void  Huytl(View view){
        Intent intent =new Intent(ThemTheLoai.this,QLTheLoai.class);
        startActivity(intent);
    }
}