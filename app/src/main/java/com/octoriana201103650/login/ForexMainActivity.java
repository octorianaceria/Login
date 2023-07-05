package com.octoriana201103650.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.text.DecimalFormat;

import cz.msebera.android.httpclient.Header;

public class ForexMainActivity extends AppCompatActivity {
    private ProgressBar loadingProgressBar;
    private SwipeRefreshLayout swipeRefreshLayout1;
    private TextView idrTextView, usdTextView, myrTextView, krwTextView, jpyTextView, hkdTextView, eurTextView, fjdTextView,fkpTextView,gbpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forex_main);

        swipeRefreshLayout1 = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout1);
        idrTextView = (TextView) findViewById(R.id.idrTextView);
        usdTextView = (TextView) findViewById(R.id.usdTextView);
        myrTextView = (TextView) findViewById(R.id.myrTextView);
        krwTextView = (TextView) findViewById(R.id.krwTextView);
        jpyTextView = (TextView) findViewById(R.id.jpyTextView);
        hkdTextView = (TextView) findViewById(R.id.hkdTextView);
        eurTextView = (TextView) findViewById(R.id.eurTextView);
        fjdTextView = (TextView) findViewById(R.id.fjdTextView);
        fkpTextView = (TextView) findViewById(R.id.fkpTextView);
        gbpTextView = (TextView) findViewById(R.id.gbpTextView);
        loadingProgressBar = (ProgressBar) findViewById(R.id.loadingProgressBar);

        initSwipeRefreshLayout();
        initForex();
    }
    private void initSwipeRefreshLayout() {
        swipeRefreshLayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initForex();

                swipeRefreshLayout1.setRefreshing(false);
            }
        });
    }

    public String formatNumber(double number, String format) {
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(number);
    }

    public void initForex() {
        loadingProgressBar.setVisibility(TextView.VISIBLE);

        String url = "https://openexchangerates.org/api/latest.json?app_id=9e281b166fd24f91a7d7a3a898ed89c8";

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                ForexRootModel rootModel = gson.fromJson(new String(responseBody), ForexRootModel.class);
                ForexRatesModel ratesModel = rootModel.getForexRatesModel();

                double idr  = ratesModel.getIDR();
                double usd = ratesModel.getIDR() / ratesModel.getUSD();
                double myr = ratesModel.getIDR() / ratesModel.getMYR();
                double krw = ratesModel.getIDR() / ratesModel.getKRW();
                double jpy = ratesModel.getIDR() / ratesModel.getJPY();
                double hkd = ratesModel.getIDR() / ratesModel.getHKD();
                double eur = ratesModel.getIDR() / ratesModel.getEUR();
                double fjd = ratesModel.getIDR() / ratesModel.getFJD();
                double fkp = ratesModel.getIDR() / ratesModel.getFKP();
                double gbp = ratesModel.getIDR() / ratesModel.getGBP();

                idrTextView.setText(formatNumber(idr, "###,##0.##"));
                usdTextView.setText(formatNumber(usd, "###,##0.##"));
                myrTextView.setText(formatNumber(myr, "###,##0.##"));
                krwTextView.setText(formatNumber(krw, "###,##0.##"));
                jpyTextView.setText(formatNumber(jpy, "###,##0.##"));
                hkdTextView.setText(formatNumber(hkd, "###,##0.##"));
                eurTextView.setText(formatNumber(eur, "###,##0.##"));
                fjdTextView.setText(formatNumber(fjd, "###,##0.##"));
                fkpTextView.setText(formatNumber(fkp, "###,##0.##"));
                gbpTextView.setText(formatNumber(gbp, "###,##0.##"));

                loadingProgressBar.setVisibility(TextView.INVISIBLE);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                loadingProgressBar.setVisibility(TextView.INVISIBLE);
            }
        });
    }
}