package com.hishd.bottomactionsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.hishd.actionsheet.ActionSheet;

public class MainActivity extends AppCompatActivity {

    private ActionSheet actionSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomSheet();

        findViewById(R.id.btnExit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionSheet.show(getSupportFragmentManager(),"ACTION_SHEET");
            }
        });
    }

    private void setupBottomSheet() {
        actionSheet = new ActionSheet();
        actionSheet.setTitle(this, "Exit Application")
                .setMessage(this, "Are you sure you want to exit from the application ?")
                .setMainTopAction(this, "Exit", ActionSheet.ActionType.DESTRUCTIVE, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        actionSheet.dismiss();
                    }
                })
                .setMainBottomAction(this, "Back", ActionSheet.ActionType.NORMAL, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        actionSheet.dismiss();
                    }
                })
                .setDefaultBottomAction(this, "Cancel", ActionSheet.ActionType.NORMAL, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        actionSheet.dismiss();
                    }
                });
    }
}