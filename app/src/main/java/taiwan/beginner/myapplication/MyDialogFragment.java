package taiwan.beginner.myapplication;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;


public class MyDialogFragment extends DialogFragment {

    private 能處理確定取消 okCancelHander;
    private View view;
    private AlertDialog mDialog;
    private Spinner spinner;

    public interface 能處理確定取消 {
        void 處理確定();

        void 處理取消();
    }

    public MyDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        initOkCancelHander();
        initDialogView();
        initSpinner();
        initDialog();
        return mDialog;
    }

    private void initOkCancelHander() {
        try {
            okCancelHander = (能處理確定取消) getActivity();
        } catch (ClassCastException cause) {
            String message = "Activity無法處理確定取消";
            throw new MyDialogFragmenntException(message, cause);
        }
    }

    private void initDialogView() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.fragment_my_dialog, null);
    }

    private void initSpinner() {
        try {
            spinner = (Spinner) view.findViewById(R.id.Spinner);
            Activity activity = getActivity();
            SpinnerAdapter adapter = new MySpinnerAdapter(activity);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) activity);
        } catch (ClassCastException cause) {
            String message = "Activity無法處理OnItemSelectedListener";
            throw new MyDialogFragmenntException(message, cause);
        }
    }

    private void initDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("咖啡品項")
                .setIcon(android.R.drawable.ic_input_add)
                .setView(view)
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        okCancelHander.處理確定();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        okCancelHander.處理取消();
                    }
                });
        mDialog = builder.create();
    }
}
