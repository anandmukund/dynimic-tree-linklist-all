FreeMarker Template example: ${message}  
 
=======================
===  County List   ====
=======================
<#list countries as country>
    ${country_index + 1}. ${country}
    <#if country == "India123">
    India is in list
</#if>
</#list>
