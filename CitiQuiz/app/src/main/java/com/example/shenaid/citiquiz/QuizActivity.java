package com.example.shenaid.citiquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mText;
    private int mCurrentIndex = 0;
    private static final String INDEX = "index";

    private Question[] mQuestions = new Question[]{
            new Question(true, R.string.question_pledge, R.string.toast_pledge),
            new Question(true, R.string.quesiton_flag, R.string.toast_flag),
            new Question(false, R.string.question_decl, R.string.toast_decl),
            new Question(false, R.string.question_prcl, R.string.toast_prcl),
            new Question(true, R.string.question_abr, R.string.toast_abr),

    };

    private void setQuestion(){
        int currQuestion = mQuestions[mCurrentIndex].getResID();
        mText.setText(currQuestion);
    }
    private void checkAnswer(boolean ans){
        if (mQuestions[mCurrentIndex].getAnswer() == ans) {
            Toast.makeText(this, mQuestions[mCurrentIndex].getToast(), Toast.LENGTH_LONG).show();
            mCurrentIndex = (mCurrentIndex + 1) % mQuestions.length;
            setQuestion();
        }
        else
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mText = (TextView) findViewById(R.id.question_text);

        mTrueButton = (Button) findViewById(R.id.answer_true);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                public void onClick(View v){
                        checkAnswer(true);
                    }
                });

        mFalseButton = (Button) findViewById(R.id.answer_false);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        setQuestion();

        mNextButton = (Button) findViewById(R.id.next_question);
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCurrentIndex = (mCurrentIndex + 1) % mQuestions.length;
                setQuestion();
            }
        });

        setQuestion();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(INDEX, mCurrentIndex);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
