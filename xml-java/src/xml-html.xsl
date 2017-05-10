<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="venda">
		<h2>Venda</h2>
		<p>Forma de pagamento: <xsl:value-of select="formaPagamento" /></p>
		<xsl:apply-templates select="produtos" />
	</xsl:template>
	
	<xsl:template match="produtos">
		<h3>Produtos</h3>
		<ul>
			<xsl:apply-templates select="produto" />
		</ul>
	</xsl:template>
	
	<xsl:template match="produto">
		<li><xsl:value-of select="nome" /> - <xsl:value-of select="preco" /></li>
	</xsl:template>
</xsl:stylesheet>