package com.example.appatletica;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
public class PostDialog extends DialogFragment {

    private EditText editTextPostagem;
    private EscreverPostagemListener listener;

    interface EscreverPostagemListener {
        void onEnviarClick(String textoPostagem);
        void onCancelClick();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (EscreverPostagemListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " deve implementar EscreverPostagemListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_post, null);

        editTextPostagem = view.findViewById(R.id.editTextPostagem);

        builder.setView(view)
                .setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String textoPostagem = editTextPostagem.getText().toString();
                        listener.onEnviarClick(textoPostagem);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onCancelClick();
                    }
                });

        return builder.create();
    }
}