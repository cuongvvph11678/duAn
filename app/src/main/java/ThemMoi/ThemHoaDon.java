package ThemMoi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.manhinhchao.QLHoaDon;
import com.example.manhinhchao.QLTheLoai;
import com.example.manhinhchao.R;

public class ThemHoaDon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_hoa_don);
        setTitle("Thêm Hóa Đơn");
    }
    public  void  Themhd(View view){
        Intent intent =new Intent(ThemHoaDon.this, QLHoaDon.class);
        startActivity(intent);
    }
    public  void  Huyhd(View view){
        Intent intent =new Intent(ThemHoaDon.this,QLHoaDon.class);
        startActivity(intent);
    }
}