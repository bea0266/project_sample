package com.android.board;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class WriteActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write);

        Button clearBtn = (Button) findViewById(R.id.clearBtn);
        Button writeBtn = (Button) findViewById(R.id.writeBtn);
        EditText etTitle = (EditText) findViewById(R.id.etTitle);
        EditText etDesc = (EditText) findViewById(R.id.etDesc);
        EditText etWrite = (EditText) findViewById(R.id.etDesc);

        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WriteActivity.this, MainActivity.class);
                intent.putExtra("Title", etTitle.getText().toString());
                intent.putExtra("Description", etDesc.getText().toString());
                intent.putExtra("Writer", etWrite.getText().toString());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
