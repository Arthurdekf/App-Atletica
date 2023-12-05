package com.example.appatletica;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appatletica.model.CardItem;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeActivity extends AppCompatActivity implements PostDialog.EscreverPostagemListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        createCardItemList();

        String userType = getIntent().getStringExtra("userType");
        if (userType != null) {
            String userTypeText = userType.equals("membro") ? "membro" : "administrador";
            Log.d("HomeActivity", "Você entrou como " + userTypeText);
        } else {
            Log.d("HomeActivity", "Tipo de usuário desconhecido");
        }
    }

    public void account1(View view){
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }

    public void shopping1 (View view) {
        Intent intent = new Intent(this, ShoppingActivity.class);
        startActivity(intent);
    }
    public void announcement1 (View view) {
        Intent intent = new Intent(this, AnnouncementActivity.class);
        startActivity(intent);
    }

    public void escreverPostagem(View view) {
        PostDialog dialog = new PostDialog();
        dialog.show(getSupportFragmentManager(), "escrever_postagem_dialog");
    }

    @Override
    public void onEnviarClick(String textoPostagem) {
        adicionarPostagem(textoPostagem);
    }

    @Override
    public void onCancelClick() {}

    private void adicionarPostagem(String textoPostagem) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> postagem = new HashMap<>();

        postagem.put("texto", textoPostagem);
        postagem.put("autor", FirebaseAuth.getInstance().getCurrentUser().getEmail());

        db.collection("postagens")
                .add(postagem)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        createCardItemList();
                    }
                });
    }

    private void atualizarRecyclerView(List<CardItem> itemList) {
        CardAdapter cardAdapter = new CardAdapter(itemList);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(cardAdapter);
    }


    private void createCardItemList() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("postagens")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<CardItem> itemList = new ArrayList<>();

                        for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                            String texto = document.getString("texto");
                            String autor = document.getString("autor");
                            itemList.add(new CardItem(autor, texto));
                        }

                        atualizarRecyclerView(itemList);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("HomeActivity", "Erro ao obter postagens", e);
                    }
                });
    }

}