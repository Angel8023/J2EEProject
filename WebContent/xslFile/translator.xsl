<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<!-- TODO: Auto-generated template -->
		<html>
			<head>
				<title>
					<xsl:value-of select="view/header/title" />
				</title>
			</head>
			<body>
				<form>
				<!-- 配置form的各个属性 -->
					<xsl:attribute name="name">  
        				<xsl:value-of select="view/body/form/name"></xsl:value-of>  
        			</xsl:attribute>
        			
					<xsl:attribute name="action">
        				<xsl:value-of select="view/body/form/action"></xsl:value-of>  
        			</xsl:attribute>
        			
					<xsl:attribute name="method">
        				<xsl:value-of select="view/body/form/method"></xsl:value-of>  
        			</xsl:attribute>        			
        			<br></br>	     
        			<!-- 读取textView文本内容 -->   			
        			<xsl:for-each select="view/body/form/textView">
        				<xsl:value-of select="name"></xsl:value-of>
        				<xsl:value-of select="lable"></xsl:value-of> 						
        				<xsl:value-of select="value"></xsl:value-of>  
						<br/>						
   					</xsl:for-each>
   					<br/>    			        		
					
					<!-- 配置button -->
					<xsl:for-each select="view/body/form/buttonView">	
						<input type = "button">					
							<xsl:attribute name="name">  
        						<xsl:value-of select="name"></xsl:value-of> 
        					</xsl:attribute>
							<xsl:attribute name="label">  
        						<xsl:value-of select="label"></xsl:value-of>   
        					</xsl:attribute>	        					
        				</input>					
					</xsl:for-each>
				</form>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>