package br.ulbra;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText txtAutEmail, txtAutSenha;

    Button btnLibera;

    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_autenticacao);
        db = new DBHelper(this);
        txtAutEmail = (EditText) findViewById(R.id.txtAutEmail);
        txtAutSenha = (EditText) findViewById(R.id.txtAutSenha);
        btnLibera = (Button) findViewById(R.id.btnLibera);
        btnLibera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtAutEmail.getText().toString();
                String password = txtAutSenha.getText().toString();
                if (username.equals("")){
                    Toast.makeText(LoginActivity.this, "Usuário não inserido," +
                            " tente novamente", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(LoginActivity.this, "Senha não inserida," +
                            " tente novamente", Toast.LENGTH_SHORT).show();
                }else {
                    String res = db.validarLogin(username, password);
                    if (res.equals("OK")){
                        Toast.makeText(LoginActivity.this, "Login OK!!",
                                Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(LoginActivity.this, "Login ou Senha errado(s)!!",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
