package com.example.hwcontextmenu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Adi Waizman
 * @version 1.0
 * @since 30/12/2025
 * <p>
 * this class is the main activity of the calculator app
 */
public class MainActivity extends AppCompatActivity  implements View.OnCreateContextMenuListener{

    EditText input1, input2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        tv = findViewById(R.id.tv);

        tv.setOnCreateContextMenuListener(this);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        menu.setHeaderTitle("select an operation");
        menu.add("+");
        menu.add("-");
        menu.add("*");
        menu.add("/");
        menu.add("C");
    }

    /**
     * this function sums two numbers from input1 and input2 and shows the result in tv
     */
    private void plus(){
        if (check1()) {
            int sum = (Integer.parseInt(String.valueOf(input1.getText()))) + (Integer.parseInt(String.valueOf(input2.getText())));
            tv.setText(Integer.toString(sum));
        }
    }


    /**
     * this function subtracts two numbers from input1 and input2 and shows the result in tv
     */
    private void minus(){
        if (check1()) {
            int sum = (Integer.parseInt(String.valueOf(input1.getText()))) - (Integer.parseInt(String.valueOf(input2.getText())));
            tv.setText(Integer.toString(sum));
        }
    }


    /**
     * this function multiplies two numbers from input1 and input2 and shows the result in tv
     */
    private void kefel(){
        if (check1()) {
            int sum = (Integer.parseInt(String.valueOf(input1.getText()))) * (Integer.parseInt(String.valueOf(input2.getText())));
            tv.setText(Integer.toString(sum));
        }
    }


    /**
     * this function divides two numbers from input1 and input2 and shows the result in tv
     */
    private void hiluk(){
        if (check1()) {
            if (Integer.parseInt(String.valueOf(input2.getText())) == 0) {
                Toast.makeText(this, "cant divide by zero", Toast.LENGTH_SHORT).show();
                return;
            }
            int sum = (Integer.parseInt(String.valueOf(input1.getText()))) / (Integer.parseInt(String.valueOf(input2.getText())));
            tv.setText(Integer.toString(sum));
        }
    }


    /**
     * this function clears the input fields and tv
     */
    private void nikuy(){
        tv.setText(" ");
        input1.setText("");
        input2.setText("");
    }


    /**
     * this function checks if the string is a valid number
     * @param string the string to check
     * @return true if the string is a valid number, false otherwise
     */
    public boolean check(String string){
        if (string == null || string.isEmpty()){
            return false;
        }
        if(string.charAt(0) == '-'){
            string = string.substring(1,(string.length())-1);
        }
        for(char c : string.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }


    /**
     * this function checks if the input fields are valid
     * @return true if the input fields are valid, false otherwise
     */
    public boolean check1(){
        if (!check(String.valueOf(input1.getText()))) {
            Toast.makeText(this,"input1 not ok", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!check(String.valueOf(input2.getText()))) {
            Toast.makeText(this, "input2 not ok", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    /**
     * this function is called when a context menu item is selected
     * @param item the selected context menu item
     * @return true if the item was handled, false otherwise
     */
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String oper = item.getTitle().toString();
        if (oper.equals("+")) {
            plus();
        } else if (oper.equals("-")) {
            minus();
        } else if (oper.equals("*")) {
            kefel();
        } else if (oper.equals("/")) {
            hiluk();
        } else if (oper.equals("C")) {
            nikuy();
        }
        return super.onContextItemSelected(item);
    }

}