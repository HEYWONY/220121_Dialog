package com.example.a220121_pop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String items[] = {"MacBook", "iMac", "iPadPro12.9", "iPhone pro 13"};
    private boolean status[] = {false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mOnClick(View v) {
        AlertDialog.Builder builder; //핸드폰 쓰다보면 경고창 뜨는 걸 볼 수 있는데 그 틀

        switch (v.getId()) {
            case R.id.btnDialog1:
                builder = new AlertDialog.Builder(this); // 자기 자신을 객체에 넣겠다
                builder.setTitle("대화상자1");
                builder.setIcon(R.drawable.apple_tree);
                builder.setMessage(Html.fromHtml("사과나무가 보이십니까?" + "<b>헤헤<b>" + "축하드립니다"));
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                break;

            case R.id.btnDialog2:
                builder = new AlertDialog.Builder(this);
                setTitle("대화상자2");
                builder.setIcon(R.drawable.love);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
                break;

            case R.id.btnDialog3:
                builder = new AlertDialog.Builder(this);
                setTitle("대화상자3");
                builder.setIcon(R.drawable.hourglass);
                builder.setSingleChoiceItems(items, -1,  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
                        // dialog.dismiss(); // 누르면 바로 닫히는 명령어
                    }
                });

                builder.setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.create().show();
                break;

            case R.id.btnDialog4:
                builder = new AlertDialog.Builder(this);
                setTitle("대화상자4");
                builder.setIcon(R.drawable.education);
                builder.setMultiChoiceItems(items, status, new DialogInterface.OnMultiChoiceClickListener() {
                   public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                       status[which] = isChecked;
                   }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, status[0] + "," + status[1]  + "," + status[2]
                                + "," + status[3], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
                break;
        }
    }
}