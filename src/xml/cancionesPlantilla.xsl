<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>LISTADO DE CANCIONES</title>
            </head>
            <body>
                <h1>LISTA DE CANCIONES</h1>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Año</th>
                        <th>Título</th>
                        <th>Artista</th>
                        <th>Duración</th>
                        <th>En español?</th>
                    </tr>
                    <xsl:apply-templates select="Canciones" />
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="cancion">
        <tr>
            <xsl:apply-templates />
        </tr>
    </xsl:template>

    <xsl:template match="id|anyo|titulo|artista|duracion|espanyol">
        <td>
            <xsl:apply-templates />
        </td>
    </xsl:template>
</xsl:stylesheet>