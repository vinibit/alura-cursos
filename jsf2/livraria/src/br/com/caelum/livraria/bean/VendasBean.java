package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.dao.LivroDAO;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.Venda;

@Named
@ViewScoped
public class VendasBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LivroDAO livroDAO;
	@Inject
	private VendaDAO vendaDAO;

	public BarChartModel getVendasModel() {
		BarChartModel model = new BarChartModel();
		
		ChartSeries series = new ChartSeries();
		series.setLabel("Vendas 2016");
		
		List<Venda> vendas = vendaDAO.todas();
		for (Venda venda : vendas) {
			series.set(venda.getLivro(), venda.getQuantidade());
		}
		model.addSeries(series);
		
		Axis xAxis = model.getAxis(AxisType.X);
		xAxis.setLabel("Livros");
		xAxis.setMin(0);
		xAxis.setMax(500);
		
		Axis yAxis = model.getAxis(AxisType.Y);
		yAxis.setLabel("Unidades");
		
		//model.setLegendPosition("e");
		model.setStacked(true);
		model.setAnimate(true);
		return model;
	}
	
	private List<Venda> getVendas(long seed) {
		List<Venda> vendas = new ArrayList<>();
		
		Random ramdom = new Random();
		
		List<Livro> livros = livroDAO.listaTodos();
		for (Livro livro : livros) {
			int quantidade = ramdom.nextInt(500);
			vendas.add(new Venda(livro, quantidade));
		}
		
		return vendas ;
	}
	
}
