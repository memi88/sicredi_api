# Desafio Sicredi API

Projeto de automação criado na IDE Eclipse usando Rest-Assured, projeto desenvolvido com base na documentação enviada. Os cenários mapeados estão listados abaixo:<br/>
<br/>
<br/>
Restricoes<br/>
    . consultar cpf com restricao<br/>
    . consultar cpf sem restricao<br/>
<br/>
Simulacoes<br/>
Criar simulacao<br/>
    . criar simulacao corretamente com seguro true<br/>
    . criar simulacao corretamente com seguro false<br/>
    . criar simulacao sem cpf<br/>
    . criar simulacao com cpf invalido<br/>
    . criar simulacao sem nome<br/>
    . criar simulacao sem email<br/>
    . criar simulacao com email invalido<br/>
    . criar simulacao sem valor<br/>
    . criar simulacao com valor 999<br/>
    . criar simulacao com valor 40.001<br/>
    . criar simulacao sem parcela<br/>
    . criar simulacao com parcela 1<br/>
    . criar simulacao com parcela 49<br/>
    . criar simulacao sem seguro<br/>
    . criar simulacao com cpf existinte<br/>
<br/>
Alterar simulacao<br/>
    . alterar simulacao corretamente com seguro true<br/>
    . alterar simulacao corretamente com seguro false<br/>
    . alterar simulacao sem cpf<br/>
    . alterar simulacao com cpf invalido<br/>
    . alterar simulacao sem nome<br/>
    . alterar simulacao sem email<br/>
    . alterar simulacao com email invalido<br/>
    . alterar simulacao sem valor<br/>
    . alterar simulacao com valor 999<br/>
    . alterar simulacao com valor 40.001<br/>
    . alterar simulacao sem parcela<br/>
    . alterar simulacao com parcela 1<br/>
    . alterar simulacao com parcela 49<br/>
    . alterar simulacao sem seguro<br/>
    . alterar simulacao com cpf existinte<br/>
    . alterar simulacao com cpf sem simulacao<br/>
<br/>
Consultar todas as Simulacoes<br/>
    . consultar corretamente com simulacao<br/>
    . consultar corretamente sem simulacao<br/>
<br/>
Consultar uma simulacao <br/>
    . consultar corretamente com simulacao<br/>
    . Consultar corretamente sem simulacao<br/>
<br/>
Remover uma simulacao<br/>
    . deletar com sucesso<br/>
    . deletar sem simulacao<br/>



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
