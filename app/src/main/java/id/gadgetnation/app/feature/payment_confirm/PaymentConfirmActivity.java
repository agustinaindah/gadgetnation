package id.gadgetnation.app.feature.payment_confirm;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import id.gadgetnation.app.R;
import id.gadgetnation.app.base.BaseActivity;
import id.gadgetnation.app.utils.Helper;

public class PaymentConfirmActivity extends BaseActivity {

    @BindView(R.id.edtNama)
    EditText edtNama;
    @BindView(R.id.edtNoPesan)
    EditText edtNoPesan;
    @BindView(R.id.edtJmlTransfer)
    EditText edtJmlTransfer;
    @BindView(R.id.txtTransferDate)
    TextView txtTransferDate;
    @BindView(R.id.edtNoRekAsal)
    EditText edtNoRekAsal;
    @BindView(R.id.edtNamaBankAsal)
    EditText edtNamaBankAsal;
    @BindView(R.id.edtNmaPemilikRekAsal)
    EditText edtNmaPemilikRekAsal;

    @BindView(R.id.imgUploadPhoto)
    ImageView imgUploadPhoto;
    @BindView(R.id.btnUploadPhoto)
    Button btnUploadPhoto;

    @BindView(R.id.btnSubmit)
    Button btnSubmit;

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Payment Confirm");
    }

    @OnClick(R.id.btnSubmit)
    public void submit(){
        Helper.createToast(this, "Berhasil, Terimakasih");
    }

    @Override
    protected int setView() {
        return R.layout.activity_payment_confirm;
    }
}
