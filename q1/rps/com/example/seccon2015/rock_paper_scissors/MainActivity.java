// 
// Decompiled by Procyon v0.5.30
// 

package com.example.seccon2015.rock_paper_scissors;

import android.os.Bundle;
import java.util.Random;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Button;
import android.view.View$OnClickListener;
import android.app.Activity;

public class MainActivity extends Activity implements View$OnClickListener
{
    Button P;
    Button S;
    int cnt;
    int flag;
    private final Handler handler;
    int m;
    int n;
    Button r;
    private final Runnable showMessageTask;
    
    static {
        System.loadLibrary("calc");
    }
    
    public MainActivity() {
        this.cnt = 0;
        this.handler = new Handler();
        this.showMessageTask = new Runnable() {
            @Override
            public void run() {
                final TextView textView = (TextView)MainActivity.this.findViewById(2131492946);
                if (MainActivity.this.n - MainActivity.this.m == 1) {
                    final MainActivity this$0 = MainActivity.this;
                    ++this$0.cnt;
                    textView.setText((CharSequence)("WIN! +" + String.valueOf(MainActivity.this.cnt)));
                }
                else if (MainActivity.this.m - MainActivity.this.n == 1) {
                    MainActivity.this.cnt = 0;
                    textView.setText((CharSequence)"LOSE +0");
                }
                else if (MainActivity.this.m == MainActivity.this.n) {
                    textView.setText((CharSequence)("DRAW +" + String.valueOf(MainActivity.this.cnt)));
                }
                else if (MainActivity.this.m < MainActivity.this.n) {
                    MainActivity.this.cnt = 0;
                    textView.setText((CharSequence)"LOSE +0");
                }
                else {
                    final MainActivity this$2 = MainActivity.this;
                    ++this$2.cnt;
                    textView.setText((CharSequence)("WIN! +" + String.valueOf(MainActivity.this.cnt)));
                }
                if (1000 == MainActivity.this.cnt) {
                    textView.setText((CharSequence)("SECCON{" + String.valueOf((MainActivity.this.cnt + MainActivity.this.calc()) * 107) + "}"));
                }
                MainActivity.this.flag = 0;
            }
        };
    }
    
    public native int calc();
    
    public void onClick(final View view) {
        if (this.flag == 1) {
            return;
        }
        this.flag = 1;
        ((TextView)this.findViewById(2131492946)).setText((CharSequence)"");
        final TextView textView = (TextView)this.findViewById(2131492944);
        final TextView textView2 = (TextView)this.findViewById(2131492945);
        this.m = 0;
        this.n = new Random().nextInt(3);
        textView2.setText((CharSequence)(new String[] { "CPU: Paper", "CPU: Rock", "CPU: Scissors" })[this.n]);
        if (view == this.P) {
            textView.setText((CharSequence)"YOU: Paper");
            this.m = 0;
        }
        if (view == this.r) {
            textView.setText((CharSequence)"YOU: Rock");
            this.m = 1;
        }
        if (view == this.S) {
            textView.setText((CharSequence)"YOU: Scissors");
            this.m = 2;
        }
        this.handler.postDelayed(this.showMessageTask, 1000L);
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968600);
        this.P = (Button)this.findViewById(2131492941);
        this.S = (Button)this.findViewById(2131492943);
        this.r = (Button)this.findViewById(2131492942);
        this.P.setOnClickListener((View$OnClickListener)this);
        this.r.setOnClickListener((View$OnClickListener)this);
        this.S.setOnClickListener((View$OnClickListener)this);
        this.flag = 0;
    }
}
