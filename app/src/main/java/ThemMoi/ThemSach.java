package ThemMoi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.manhinhchao.QLNguoiDung;
import com.example.manhinhchao.QLSach;
import com.example.manhinhchao.R;
import com.example.manhinhchao.ThemNguoiDung;

public class ThemSach extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sach);
        setTitle("Thêm Sách");
    }
    public  void  Themsach(View view){
        Intent intent =new Intent(ThemSach.this, QLSach.class);
        startActivity(intent);
    }
    public  void  Huysach(View view){
        Intent intent =new Intent(ThemSach.this, QLSach.class);
        startActivity(intent);
    }
}