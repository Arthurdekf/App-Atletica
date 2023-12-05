package com.example.appatletica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.nullness.qual.NonNull;

public class AdminActivity extends AppCompatActivity {

    private EditText emailEditText1;
    private Button btnSalvar1;
    private EditText emailEditText2;
    private Button btnSalvar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_screen);

        emailEditText1 = findViewById(R.id.emailEditText1);
        btnSalvar1 = findViewById(R.id.btnSalvar1);
        emailEditText2 = findViewById(R.id.emailEditText2);
        btnSalvar2 = findViewById(R.id.btnSalvar2);
    }

    public void salvar1(View view) {
        String email = emailEditText1.getText().toString().trim();

        if (!email.isEmpty()) {
            FirebaseAuth.getInstance().fetchSignInMethodsForEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                        @Override
                        public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                            if (task.isSuccessful()) {
                                SignInMethodQueryResult result = task.getResult();
                                if (result != null && result.getSignInMethods() != null && !result.getSignInMethods().isEmpty()) {
                                    criarUsuarioNaColecao1(email);
                                } else {
                                    Toast.makeText(AdminActivity.this, "Usuário não existe no Firebase Authentication", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(AdminActivity.this, "Erro ao verificar usuário: " +
                                        task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            Toast.makeText(AdminActivity.this, "Insira um email válido", Toast.LENGTH_SHORT).show();
        }
    }

    private void criarUsuarioNaColecao1(String email) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, "senhaTemporaria")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            salvarEmailNoFirestore1(email);

                            Toast.makeText(AdminActivity.this, "Email salvo com sucesso", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(AdminActivity.this, "Falha ao criar usuário: " +
                                    task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void salvarEmailNoFirestore1(String email) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("administrador_eng")
                .document(email)
                .set(new Object())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(AdminActivity.this, "Falha ao salvar email no Firestore", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void salvar2(View view) {
        String email = emailEditText2.getText().toString().trim();

        if (!email.isEmpty()) {
            FirebaseAuth.getInstance().fetchSignInMethodsForEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                        @Override
                        public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                            if (task.isSuccessful()) {
                                SignInMethodQueryResult result = task.getResult();
                                if (result != null && result.getSignInMethods() != null && !result.getSignInMethods().isEmpty()) {
                                    criarUsuarioNaColecao2(email);
                                } else {
                                    Toast.makeText(AdminActivity.this, "Usuário não existe no Firebase Authentication", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(AdminActivity.this, "Erro ao verificar usuário: " +
                                        task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            Toast.makeText(AdminActivity.this, "Insira um email válido", Toast.LENGTH_SHORT).show();
        }
    }

    private void criarUsuarioNaColecao2(String email) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, "senhaTemporaria")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            salvarEmailNoFirestore2(email);

                            Toast.makeText(AdminActivity.this, "Email salvo com sucesso", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(AdminActivity.this, "Falha ao criar usuário: " +
                                    task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void salvarEmailNoFirestore2(String email) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("administrador_eng")
                .document(email)
                .set(new Object())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(AdminActivity.this, "Falha ao salvar email no Firestore", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void btnVoltarAdm(View view){
        Intent intent = new Intent(AdminActivity.this, HomeActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Saiu do modo Administrador", Toast.LENGTH_SHORT).show();
    }
}