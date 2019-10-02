<?xml version="1.0" encoding="UTF-8"?>
<html xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xsl:version="1.0">
	<head>Gonçalo Duarte e Ricardo Margarido</head>
	<body>
		<h1>Actors</h1>
		<table border="1">
			<tr>
				<th>Actor</th>
				<th>Episodes</th>
				<th>Series</th>

			</tr>
			<xsl:for-each select="aCatalog/actor">
				<tr>
					<td>
						<xsl:value-of select="name" />
					</td>
					<td>
						<xsl:value-of select="epFeat" />
					</td>
					<td>
						<xsl:for-each select="serieTitle">
							<xsl:value-of select="." />
							<xsl:text>&#160; &#160; &#160;</xsl:text>
						</xsl:for-each>
					</td>

				</tr>
			</xsl:for-each>
		</table>
		
		<h2>&#160;</h2>
		<h3>&#160;</h3>
		<h4>&#160;</h4>
		
		<h1>Statistics</h1>
		<table border="1">
			<tr>
				<th>Processed Actores</th>
			</tr>
			<tr>
				<td>
					<xsl:value-of select="aCatalog/procAtor" />
				</td>
			</tr>
		</table>


		<h2>Most Popular Actors</h2>
		<table border="1">
			<tr>
				<th>Actor</th>
				<th>Episodes</th>
			</tr>
			<xsl:for-each select="aCatalog/popActor">
				<tr>
					<td>
						<xsl:value-of select="name" />
					</td>
					<td>
						<xsl:value-of select="eps" />
					</td>
				</tr>
			</xsl:for-each>
		</table>




	</body>
</html>