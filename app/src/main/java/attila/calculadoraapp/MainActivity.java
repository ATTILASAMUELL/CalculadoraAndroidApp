package attila.calculadoraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_limpar,btn_divisao,btn_numero_sete, btn_oito,btn_nove,btn_multiplicacao,
            btn_numero_um,btn_dois,btn_tres,btn_soma,btn_ponto,btn_zero,btn_igual,btn_numero_quatro,
            btn_numero_cinco,btn_numero_seis,btn_subtracao;

    private TextView txt_conteudo,txt_resultado;

    private ImageView backspace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicia os metodos
        IniciarComponentes();

        //TIRAR BARRA DE AÇÕES:
        getSupportActionBar().hide();

        btn_zero.setOnClickListener(this);
        btn_numero_um.setOnClickListener(this);
        btn_dois.setOnClickListener(this);
        btn_tres.setOnClickListener(this);
        btn_numero_quatro.setOnClickListener(this);
        btn_numero_cinco.setOnClickListener(this);
        btn_numero_seis.setOnClickListener(this);
        btn_numero_sete.setOnClickListener(this);
        btn_oito.setOnClickListener(this);
        btn_nove.setOnClickListener(this);
        btn_ponto.setOnClickListener(this);
        btn_soma.setOnClickListener(this);
        btn_subtracao.setOnClickListener(this);
        btn_multiplicacao.setOnClickListener(this);
        btn_divisao.setOnClickListener(this);

        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_conteudo.setText("");
                txt_resultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView conteudo = findViewById(R.id.txt_conteudo);
                String string = conteudo.getText().toString();

                if(!string.isEmpty()){

                    byte var0= 0;
                    int var1 = string.length()-1;
                    String txtConteudo = string.substring(var0, var1);
                    conteudo.setText(txtConteudo);
                }
                txt_resultado.setText("");

            }
        });

        btn_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Expression expression = new ExpressionBuilder(txt_conteudo.getText().toString()).build();
                    double resultado = expression.evaluate();
                    long longResultado = (long) resultado;

                    if (resultado == (double) longResultado) {
                        txt_resultado.setText((CharSequence) String.valueOf(longResultado));
                    } else {
                        txt_resultado.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){
                    Toast.makeText( MainActivity.this,"Erro na expressão",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void IniciarComponentes(){
        btn_limpar = findViewById(R.id.btn_limpar);
        btn_divisao = findViewById(R.id.btn_divisao);
        btn_numero_sete = findViewById(R.id.btn_numero_sete);
        btn_oito = findViewById(R.id.btn_oito);
        btn_nove = findViewById(R.id.btn_nove);
        btn_multiplicacao = findViewById(R.id.btn_multiplicacao);
        btn_numero_um = findViewById(R.id.btn_numero_um);
        btn_dois = findViewById(R.id.btn_dois);
        btn_tres = findViewById(R.id.btn_tres);
        btn_soma = findViewById(R.id.btn_soma);
        btn_ponto = findViewById(R.id.btn_ponto);
        btn_zero = findViewById(R.id.btn_zero);
        btn_igual = findViewById(R.id.btn_igual);
        btn_numero_quatro = findViewById(R.id.btn_numero_quatro);
        btn_numero_cinco = findViewById(R.id.btn_numero_cinco);
        btn_numero_seis = findViewById(R.id.btn_numero_seis);
        btn_subtracao = findViewById(R.id.btn_subtracao);

        txt_conteudo = findViewById(R.id.txt_conteudo);
        txt_resultado = findViewById(R.id.txt_resultado);

        backspace = findViewById(R.id.backspace);


    }

    //Metodo acrescentar uma expressao:

    public void AcrescentarExpressao(String string, boolean limpar){
        //Se não estiver o resultado vazio, ele está com numeros kk

        if(txt_resultado.getText().equals("")){
            txt_conteudo.setText(" ");
        }

        if(limpar){
            txt_resultado.setText(" ");
            txt_conteudo.append(string);

        }else{
            txt_conteudo.append(txt_resultado.getText());
            txt_conteudo.append(string);
            txt_resultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_zero:
                AcrescentarExpressao("0",true);
                break;
            case R.id.btn_numero_um:
                AcrescentarExpressao("1",true);
                break;
            case R.id.btn_dois:
                AcrescentarExpressao("2",true);
                break;
            case R.id.btn_tres:
                AcrescentarExpressao("3",true);
                break;
            case R.id.btn_numero_quatro:
                AcrescentarExpressao("4",true);
                break;
            case R.id.btn_numero_cinco:
                AcrescentarExpressao("5",true);
                break;
            case R.id.btn_numero_seis:
                AcrescentarExpressao("6",true);
                break;
            case R.id.btn_numero_sete:
                AcrescentarExpressao("7",true);
                break;
            case R.id.btn_oito:
                AcrescentarExpressao("8",true);
                break;
            case R.id.btn_nove:
                AcrescentarExpressao("9",true);
                break;
            case R.id.btn_ponto:
                AcrescentarExpressao(".",true);
                break;
            case R.id.btn_soma:
                AcrescentarExpressao("+",false);
                break;
            case R.id.btn_subtracao:
                AcrescentarExpressao("-",false);
                break;
            case R.id.btn_multiplicacao:
                AcrescentarExpressao("*",false);
                break;
            case R.id.btn_divisao:
                AcrescentarExpressao("/",false);
                break;



        }

    }
}