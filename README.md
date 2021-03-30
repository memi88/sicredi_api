# Desafio Sicredi API

Projeto de automação criado na IDE Eclipse usando Rest-Assured, projeto desenvolvido com base na documentação enviada.



#### Abaixo estão listados alguns bugs e informações referente ao sistema/documentação que foram encontradas:

##### ***BUGS***
. Consultar restrição com CPF com restrição está retornando mensagem "O CPF XXX tem problema" - Esperado era "O CPF XXX possui restrição"<br/>
. Simulação para um mesmo CPF está retornando um HTTP Status 400 - Esperado era HTTP Status 409<br/>
. Existe diferença nas mensagens que são retornadas sobre a regra de campos obrigatorios (Ex. Sem Email e Sem Nome)<br/>
. Criar simulação sem enviar o campo Seguro está retornando um HTTP Status 500 - Esperado era HTTP Status 400<br/>
. Simulação para um CPF invalido está retornando um HTTP Status 201<br/>
. Simulação para um email invalido possui mensagens diferentes<br/>
. Simulação com um valor maior que o permitido está retornando um HTTP Status 201 - Espearado era HTTP Status 400<br/>
. Alterar uma simulação não está alterando o campo Valor da simulação<br/>
. Sistema permite alterar o CPF de uma simulação, mesmo que o CPF novo da simulação possua restrições<br/>
. Alterar Simulação para um CPF invalido está retornando um HTTP Status 201<br/>
. Alterar Simulação para um email invalido possui mensagens diferentes<br/>
. Alterar Simulação com um valor maior que o permitido está retornando um HTTP Status 201 - Espearado era HTTP Status 400<br/>
. Deletar uma simulação está retornando HTTP Status 200 - Esperado era HTTP Status 204<br/>
. Deletar uma simulação que não existe está retornando HTTP Status 200 - Esperado era HTTP Status 404 com mensagem "Simulação não encontrada"<br/>

##### ***DOCUMENTAÇÃO***

Alterar uma simulação<br/>
. Documento de orientação não possui a informação referente ao retorno de HTTP Status 409 (CPF já existente)<br/>

Consultar todas simulações<br/>
. Documentação técnica não possui informações sobre o retorno HTTP Status 204 para quando não existir simulações cadastradas<br/>

Remover uma simulação<br/>
. Documentação técnico não possui informações sobre o retorno HTTP Status 404 - Simulação não encontrada<br/>
