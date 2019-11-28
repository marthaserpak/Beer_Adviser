package hfad.app.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {

    private TextView mBrands;
    private Spinner mColor;

    private BeerExpert mExpert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);

        mBrands = findViewById(R.id.brands);
        mColor = findViewById(R.id.color);
    }

    public void onClickFindBeer(View view) {
        String beerType = String.valueOf(mColor.getSelectedItem());
        List<String> brands = mExpert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder('\n');
        for (String brand : brands) {
            brandsFormatted.append(brand).append('\n');
        }
        mBrands.setText(brandsFormatted);
    }
}
