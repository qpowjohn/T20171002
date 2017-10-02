package taiwan.beginner.myapplication;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;


public class MyDialogFragment extends DialogFragment {

    private 能處理確定取消 okCancelHander;
    public interface 能處理確定取消{
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
        try{
            okCancelHander = (能處理確定取消)getActivity();
        }catch (ClassCastException cause){
            String message = "Activity無法處理確定取消";
            throw new MyDialogFragmenntException(message,cause);
        }
        LayoutInflater inflater =getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_my_dialog,null);
        Spinner spinner = (Spinner)view.findViewById(R.id.Spinner);
        Activity activity = getActivity();
        SpinnerAdapter adapter = new MySpinnerAdapter(activity);
        spinner.setAdapter(adapter);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("咖啡品項")
                .setIcon(android.R.drawable.ic_input_add)
                .setView(view)
                .setPositiveButton("確定",null)
                .setNegativeButton("取消",null);

        return builder.create();
    }
}
