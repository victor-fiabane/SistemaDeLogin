package br.ulbra;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarActivity extends AppCompatActivity {

    EditText txtNome, txtEmail, txtSenha, txtDnvSenha;

    Button btnSalvar;

    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_usuario);
        db = new DBHelper(this);

        txtNome = (EditText) findViewById(R.id.txtNome);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        txtDnvSenha = (EditText) findViewById(R.id.txtDnvSenha);

        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = txtEmail.getText().toString();
                String pas1 = txtSenha.getText().toString();
                String pas2 = txtDnvSenha.getText().toString();
                if (userName.equals("")){
                    Toast.makeText(RegistrarActivity.this, "Insira o LOGIN DO USUÁRIO",
                            Toast.LENGTH_LONG).show();
                }else if (pas1.equals("") || pas2.equals("")){
                    Toast.makeText(RegistrarActivity.this, "Insira a SENHA DO USUÁRIO",
                            Toast.LENGTH_LONG).show();
                }else if (!pas1.equals(pas2)) {
                    Toast.makeText(RegistrarActivity.this, "As senhas não correspondem " +
                            "ao login do usuário", Toast.LENGTH_LONG).show();
                }else {
                    long res = db.criarUtilizador(userName, pas1);
                    if(res>0){
                        Toast.makeText(RegistrarActivity.this, "Registro OK",
                                Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(RegistrarActivity.this, "Senha inválida!",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
