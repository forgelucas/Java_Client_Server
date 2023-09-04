# Cliente_Servidor

PROTOCOLO:

Análise da Mensagem:
OBS: A MENSAGEM DEVE ENVIAR SOMENTE 2 VALORES NA OPERAÇÃO.

A mensagem recebida é convertida de bytes para uma string.
A string da mensagem é dividida em partes usando o caractere ':' como separador.
A estrutura esperada da mensagem é: "operacao:valor1:valor2". Por exemplo,
"som:5:3" representa uma solicitação de soma de 5 e 3.


Execução das Operações :
Com base na operação especificada na mensagem, o servidor executa uma operação matemática correspondente.

Se a operação for "som" (soma), ele adiciona os dois valores.

Se a operação for "sub" (subtração), ele subtrai o segundo valor do primeiro.

Se a operação for "mul" (multiplicação), ele multiplica os dois valores.

Se a operação for "div" (divisão), ele divide o primeiro valor pelo segundo. Se o segundo valor for zero,
ele retorna o valor mínimo de um inteiro.

Se a operação for "pctg" (porcentagem), o servidor calculará a porcentagem do primeiro valor em relação ao segundo valor.

Envio da Resposta:
O resultado da operação é convertido em uma string e é enviado de volta ao cliente como uma resposta no formato "Resultado: resultado".
Por exemplo, "Resultado: 8" para a operação "som:5:3".

Tratamento de Mensagens Inválidas:
Se a mensagem não seguir o formato esperado (ou seja, não contiver três partes separadas por ":"),
o servidor imprime uma mensagem de erro no console, indicando que a mensagem é inválida.
