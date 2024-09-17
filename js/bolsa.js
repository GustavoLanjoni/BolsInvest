function adicionarAtivo() {
    const pesquisa = document.getElementById('pesquisa').value.toUpperCase();
    const ativosOcultos = document.querySelectorAll('#hiddenAtivos .sec-ativos');

    ativosOcultos.forEach(ativo => {
        const nome = ativo.querySelector('h5').innerText.toUpperCase();
        if (nome.includes(pesquisa)) {
            ativo.style.display = 'inline-block'; // Exibe o ativo
            document.getElementById('sec-ativos').appendChild(ativo); // Move o ativo para a lista visível
        }
    });
}

// Função para pesquisar ativos
function pesquisar() {
    const pesquisa = document.getElementById('pesquisa').value.toUpperCase();
    const visiveis = document.querySelectorAll('#sec-ativos .sec-ativos');
    const ocultos = document.querySelectorAll('#hiddenAtivos .sec-ativos');
    
    // Pesquisa nos ativos visíveis
    visiveis.forEach(ativo => {
        const nome = ativo.querySelector('h5').innerText.toUpperCase();
        if (nome.includes(pesquisa) || pesquisa === '') {
            ativo.style.display = 'inline-block';
        } else {
            ativo.style.display = 'none';
        }
    });
    
    // Pesquisa nos ativos ocultos
    ocultos.forEach(ativo => {
        const nome = ativo.querySelector('h5').innerText.toUpperCase();
        if (nome.includes(pesquisa)) {
            ativo.style.display = 'inline-block'; // Exibe o ativo
        } else {
            ativo.style.display = 'none';
        }
    });
}
