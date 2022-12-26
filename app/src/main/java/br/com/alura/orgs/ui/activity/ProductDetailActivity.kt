package br.com.alura.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.databinding.ActivityProductDetailBinding
import br.com.alura.orgs.extensions.formataParaMoedaBrasileira
import br.com.alura.orgs.extensions.tentaCarregarImagem
import br.com.alura.orgs.model.Produto

class ProductDetailActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityProductDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        tentaCarregarProduto()
    }

    private fun tentaCarregarProduto() {
        intent.getParcelableExtra<Produto>(CHAVE_PRODUTO)?.let {produtoCarregado ->
            preencheCampos(produtoCarregado)

        }?: finish()
    }

    private fun preencheCampos(produtoCarregado: Produto) {
        with(binding) {
            productDetailImage.tentaCarregarImagem(produtoCarregado.imagem)
            productDetailName.text = produtoCarregado.nome
            productDetailDescription.text = produtoCarregado.descricao
            productDetailPrice.text = produtoCarregado.valor.formataParaMoedaBrasileira()
        }

    }
}