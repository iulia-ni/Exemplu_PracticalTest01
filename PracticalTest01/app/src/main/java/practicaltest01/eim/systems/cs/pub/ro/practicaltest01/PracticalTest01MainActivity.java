package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01MainActivity extends AppCompatActivity {
    private EditText leftEditText;
    private EditText rightEditText;
    private Button leftButton;
    private Button rightButton;
    private Button navigateButton;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.left_button:
                    int leftNumberOfClicks = Integer.parseInt(leftEditText.getText().toString());
                    leftNumberOfClicks++;
                    leftEditText.setText(String.valueOf(leftNumberOfClicks));
                    break;
                case R.id.right_button:
                    int rightNumberOfClicks = Integer.parseInt(rightEditText.getText().toString());
                    rightNumberOfClicks++;
                    rightEditText.setText(String.valueOf(rightNumberOfClicks));
                    break;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

        leftEditText = findViewById(R.id.left_edit_text);
        rightEditText = findViewById(R.id.right_edit_text);
        leftButton = findViewById(R.id.left_button);
        leftButton.setOnClickListener(buttonClickListener);
        rightButton = findViewById(R.id.right_button);
        rightButton.setOnClickListener(buttonClickListener);
        navigateButton = findViewById(R.id.navigate_button);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("leftCount", leftEditText.getText().toString());
        savedInstanceState.putString("rightCount", rightEditText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("leftCount")) {
            leftEditText.setText(savedInstanceState.getString("leftCount"));
        } else {
            leftEditText.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("rightCount")) {
            rightEditText.setText(savedInstanceState.getString("rightCount"));
        } else {
            rightEditText.setText(String.valueOf(0));
        }
    }
}
