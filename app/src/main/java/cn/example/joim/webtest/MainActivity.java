package cn.example.joim.webtest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.List;

import cn.example.joim.webtest.bridge.PoemBridge;
import cn.example.joim.webtest.bridge.UserLoginBridge;

public class MainActivity extends AppCompatActivity {

    private static final String POEM_BRIDGE = "poemBridge";

    private static final String USER_ACCOUNT_BRIDGE = "user";


    private static final String URL_STRING = "file:///android_asset/mui-sun/index.html";

    private WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mWebview = (WebView) findViewById(R.id.web_view);

        WebSettings webSettings = mWebview.getSettings();

        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAppCacheEnabled(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);


        PoemBridge poemBridge = new PoemBridge(this);

        mWebview.addJavascriptInterface(new UserLoginBridge(), USER_ACCOUNT_BRIDGE);
        mWebview.addJavascriptInterface(poemBridge, POEM_BRIDGE);

        List list = poemBridge.selectAllPoem();


        mWebview.setWebChromeClient(new WebChromeClient());

        mWebview.setBackgroundColor(Color.TRANSPARENT);  //  WebView 背景透明效果

        mWebview.loadUrl(URL_STRING);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
