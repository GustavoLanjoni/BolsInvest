// Variável para rastrear o estado atual
let estadoAlternado = false;

// Função para alternar a imagem e o texto dos preços
function alternarImagemTexto() {
    // 1. Obtemos a referência da imagem
    const imagem = document.querySelector(".olho-aberto img");

    // 2. Obtemos a referência dos elementos de preço
    const precos = document.querySelectorAll(".patrimonio h2");

    // 3. Verifica o estado atual e alterna conforme necessário
    if (!estadoAlternado) {
        // Estado não alternado, mudar para estado alternado
        imagem.src = "img/olho-vermelho.png"; // Nova imagem
        imagem.alt = "Olho Vermelho";
        
        // Pega o texto original e transforma em asteriscos
        precos.forEach(preco => {
            const textoOriginal = preco.innerText;
            const textoAsterisco = '*'.repeat(textoOriginal.length);
            preco.innerText = textoAsterisco;
        });

        estadoAlternado = true; // Atualiza o estado
    } else {
        // Estado alternado, voltar ao estado original
        imagem.src = "img/olho-aberto.png"; // Imagem original
        imagem.alt = "Olho Aberto";

        // Restaura o texto original
        precos.forEach(preco => {
            preco.innerText = "R$ 0,00"; // Restaure o texto original ou utilize variáveis se precisar
        });

        estadoAlternado = false; // Atualiza o estado
    }
}

// Adicionamos um ouvinte de evento para a imagem
document.querySelector(".olho-aberto img").addEventListener("click", alternarImagemTexto);
