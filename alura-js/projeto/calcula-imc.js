var pacientesTr = document.getElementsByClassName("paciente");

for (var i = 0; i < pacientesTr.length; i++) {
	var pacienteTr = pacientesTr[i];

	var nomeTd = pacienteTr.getElementsByClassName("info-nome")[0];
	var pesoTd = pacienteTr.getElementsByClassName("info-peso")[0];
	var alturaTd = pacienteTr.getElementsByClassName("info-altura")[0];

	var paciente = {
		nome: nomeTd.textContent, 
		peso: pesoTd.textContent,
		altura: alturaTd.textContent,
		pegaImc: function() {
			if (this.altura <= 0) {
				console.log("Não posso executar uma divisão por 0!");
			} else {
				return this.peso / (this.altura * this.altura);		
			}
		}
	};

	var imcTd = pacienteTr.getElementsByClassName("info-imc")[0];
	imcTd.textContent = paciente.pegaImc();

};