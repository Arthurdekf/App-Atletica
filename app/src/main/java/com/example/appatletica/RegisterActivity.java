package com.example.appatletica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appatletica.R;
import com.example.appatletica.model.User;
import com.example.appatletica.model.member;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private EditText nomeEditText;
    private EditText emailEditText;
    private EditText senhaEditText;
    private EditText senhaConfirmText;
    private Spinner spinnerCursos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register);

        nomeEditText = findViewById(R.id.nomeEditText);
        emailEditText = findViewById(R.id.emailEditText);
        senhaEditText = findViewById(R.id.senhaEditText);
        senhaConfirmText = findViewById(R.id.senhaConfirmText);
        spinnerCursos = findViewById(R.id.spinnerCursos);

        preencherSpinnerCursos();
    }

    private void preencherSpinnerCursos() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("cursos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<com.google.firebase.firestore.QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<com.google.firebase.firestore.QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<String> cursos = new ArrayList<>();
                            for (com.google.firebase.firestore.DocumentSnapshot document : task.getResult()) {
                                String nomeCurso = document.getString("nome_curso");
                                cursos.add(nomeCurso);
                            }

                            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                    RegisterActivity.this,
                                    android.R.layout.simple_spinner_item,
                                    cursos
                            );

                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spinnerCursos.setAdapter(adapter);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Erro ao carregar cursos", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void cadastrarUsuario(View view) {
        String email = emailEditText.getText().toString();
        String senha = senhaEditText.getText().toString();
        String confirmarSenha = senhaConfirmText.getText().toString();
        String nome = nomeEditText.getText().toString();
        String cursoEscolhido = spinnerCursos.getSelectedItem().toString();
        boolean receberNoticias = false;

        if (!senha.equals(confirmarSenha)) {
            Toast.makeText(RegisterActivity.this, "As senhas não correspondem", Toast.LENGTH_LONG).show();
            return;
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            member novoMembro = new member(email, senha, nome, cursoEscolhido, receberNoticias);

                            salvarDadosNoFirestore(novoMembro);

                            Toast.makeText(RegisterActivity.this, "Usuário criado com sucesso", Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, "Erro ao criar usuário: " +
                                    task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void salvarDadosNoFirestore(member novoMembro) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("alunos")
                .document(novoMembro.getEmail())
                .set(novoMembro);
    }

    public void btnVoltar (View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
