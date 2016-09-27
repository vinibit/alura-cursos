function montaPaciente(linha) {
	var paciente = {
			nome: linha.getElementsByClassName("info-nome")[0].textContent, 
			peso: linha.getElementsByClassName("info-peso")[0].textContent,
			altura: linha.getElementsByClassName("info-altura")[0].textContent,		
			pegaImc: function() {
				if (this.altura <= 0) {
					console.log("Não posso executar uma divisão por 0!");
				} else {
					return this.peso / (this.altura * this.altura);		
				}
			}
		};
	return paciente;		
}

function paraCadaLinha(linhas, executa) {
	for (var i = 0; i < linhas.length; i++) {
		linha = linhas[i];
		executa(linha);
	};	
}

var botao = document.getElementById("calcula-imcs");
botao.addEventListener("click", function() {
	var linhas = document.getElementsByClassName("paciente");
	paraCadaLinha(linhas, function(linha) {
		var paciente = montaPaciente(linha);		
		linha.getElementsByClassName("info-imc")[0].textContent = paciente.pegaImc();
	})
});
botao.addEventListener("click", function() {
	console.log("Calculando todos IMCs...");
});

