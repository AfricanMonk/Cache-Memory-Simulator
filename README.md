
<h1 id="cache-memory-simulator">Cache Memory Simulator</h1>
<p>Nesse código tem como principal objetivo projetar um simulador de memória cache simples.</p>
<h2 id="descrição">Descrição</h2>
<p>O simulador simula diversas arquiteturas de cache seguindo os parâmetros abaixo:<br>
1-Tamanho da cache: 1024, 2048, 4096, 8192, 16384 bytes;<br>
2. Tamanho do bloco: 16 bytes; 3. Mapeamentos: direto, 2-way, 4-way e 8-way; 4. Política de substituição: LRU, FIFO</p>
<p>A cache contabiliza o número de acertos e erros para cada configuração de cache. A entrada do programa é um arquivo contendo uma sequência de endereços. Para cada endereço, é  simulado uma leitura real na cache. Portanto, dado um endereço é verificado se o mesmo está contido na cache. Caso não esteja, o contador de erros deve ser incrementado e a cache atualizada usando a política de substituição.<br>
O simulador é testado através de um arquivo com endereços estão em hexadecimal.<br>
Após os testes forma gerados os seguintes resultados apresentados na tabela abaixo:</p>

![Tabela](https://user-images.githubusercontent.com/34459397/60374013-c0508980-99d8-11e9-8567-368a23b033e1.png)
