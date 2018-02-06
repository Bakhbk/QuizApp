package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText questionsEditText;
    //Declare Radio button for the FIRST question
    RadioButton questionsRadioButton;
    //Declare CheckBox for the SECOND question
    CheckBox questionsThreeFirst;
    CheckBox questionsThreeSecond;
    CheckBox questionsThreeThird;

    //Declare integer for the FIRST question
    int answerOne_Score;
    // Question 3
    //Declare integer for the SECOND question
    int answerTwoScore;
    //Declare integer for the THIRD question
    int answerThreeScore;
    //Declare integer for the Fourth question
    int answerFourScore;
    //Declare integer for the summaryScore
    int summaryScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // Hide the keyboard
        this.getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);
    }


    public void clickButton(View view) {
        //STARTS THE FIRST QUESTION
        String answer4;
        questionsEditText = this.findViewById(R.id.questionsOneFirst);
        answer4 = questionsEditText.getText().toString().toLowerCase();
        if (answer4.equals("11")) {
            answerOne_Score = 1;
        } else {
            answerOne_Score = 0;
        }

        //STARTS THE SECOND QUESTION
        Boolean answerTwoFirstChecked;
        Boolean answerTwoSecondChecked;
        questionsRadioButton = this.findViewById( R.id.questionsTwoFirst );
        answerTwoFirstChecked = questionsRadioButton.isChecked();
        questionsRadioButton = this.findViewById( R.id.questionsTwoSecond );
        answerTwoSecondChecked = questionsRadioButton.isChecked();
        if (answerTwoFirstChecked) {
            answerTwoScore = 0;
        } else if (answerTwoSecondChecked) {
            answerTwoScore = 1;
        }

        //STARTS THE THIRD QUESTION
        Boolean answerThreeFirstChecked;
        Boolean answerThreeSecondChecked;
        Boolean answerThreetThirdChecked;
        questionsThreeFirst = this.findViewById( R.id.questionsThreeFirst );
        questionsThreeSecond = this.findViewById( R.id.questionsThreeSecond );
        questionsThreeThird = this.findViewById( R.id.questionsThreeThird );
        answerThreeFirstChecked = questionsThreeFirst.isChecked();
        answerThreeSecondChecked = questionsThreeSecond.isChecked();
        answerThreetThirdChecked = questionsThreeThird.isChecked();
        if (answerThreeFirstChecked && !answerThreeSecondChecked && answerThreetThirdChecked) {
            answerThreeScore = 1;
        } else {
            answerThreeScore = 0;
        }
        //STARTS THE FOURTH QUESTION.
        Boolean answerFourFirstChecked;
        Boolean answerFourSecondChecked;
        questionsRadioButton = this.findViewById( R.id.questionsFourFirst );
        answerFourFirstChecked = questionsRadioButton.isChecked();
        questionsRadioButton = this.findViewById( R.id.questionsFourSecond );
        answerFourSecondChecked = questionsRadioButton.isChecked();
        if (answerFourFirstChecked) {
            answerFourScore = 1;
        } else if (answerFourSecondChecked) {
            answerFourScore = 0;
        }

        //Count total summary
        String resultsDisplay;
        summaryScore = answerOne_Score + answerTwoScore + answerThreeScore + answerFourScore;

        if (summaryScore == 4) {
            resultsDisplay = "Awesome! You scored 4 out of 4";
        } else {
            resultsDisplay = "You scored " + summaryScore + " out of 4. Try again.";
        }
        // Shows a toast
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText( context, resultsDisplay, duration );
        toast.setGravity( Gravity.CENTER_HORIZONTAL, 0, 0 );
        toast.show();
    }
}