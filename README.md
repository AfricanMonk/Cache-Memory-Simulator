## Simulador de Memoria Cache
Nesse programa, o principal objetivo é projetar um simulador de memória cache simples.
### Descrição
Simula diversas arquiteturas de cache seguindo os parâmetros abaixo:

- Tamanho da cache: 1024, 2048, 4096, 8192, 16384 bytes
- Tamanho do bloco: 16 bytes; 3. Mapeamentos: direto, 2-way, 4-way e 8-way; 4. Política de substituição: LRU, FIFO

A cache contabiliza o número de acertos e erros para cada configuração de cache. A entrada do programa é um arquivo contendo uma sequência de endereços. Para cada endereço, é  simulado uma leitura real na cache. Portanto, dado um endereço é verificado se o mesmo está contido na cache. Caso não esteja, o contador de erros deve ser incrementado e a cache atualizada usando a política de substituição.

### Resultados
O simulador é testado através de um arquivo com endereços estão em hexadecimal, que pode ser encontrado neste repositório
Após os testes forma gerados os seguintes resultados apresentados na tabela abaixo:

<p align="center">
  <img src="https://user-images.githubusercontent.com/34459397/60374013-c0508980-99d8-11e9-8567-368a23b033e1.png">
</p>

### [](<[https://github.com/Josuebmota/ApiSpringBoot](https://github.com/Josuebmota/ApiSpringBoot)#autor>)Autor

- **Josué Batista Mota** - [GitHub](https://github.com/Josuebmota) - Email: [josuebatistam1@gmail.com](mailto:josuebatistam1@gmail.com)
