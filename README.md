<h1 align = "center">
<strong>Simulador de Memória Cache 💾</strong>
</h1>

<p align="center">
   <a href="https://www.linkedin.com/in/josu%C3%A9-batista-694bba135/">
      <img alt="Josué Batista" src="https://img.shields.io/badge/-JosuéBatista-EEAD2D?style=flat&logo=Linkedin&logoColor=white" />
   </a>
  <img alt="Repository size" src="https://img.shields.io/github/repo-size/Josuebmota/CacheMemorySimulator?color=EEAD2D">
  <a href="https://github.com/Josuebmota/CacheMemorySimulator/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/Josuebmota/CacheMemorySimulator?color=EEAD2D">
  </a> 
  <a href="https://github.com/Josuebmota/CacheMemorySimulator/blob/master/LICENSE"><img alt="License" src="https://img.shields.io/badge/license-MIT-EEAD2D">
  </a>
  <a href="https://github.com/Josuebmota/CacheMemorySimulator/stargazers"><img alt="Stargazers" src="https://img.shields.io/github/stars/Josuebmota/CacheMemorySimulator?color=EEAD2D&logo=github">
  </a>
</p>

> Trabalho desenvolvido durante a disciplina de arquitetura de computadores

## 🛠️ Ferramentas e Tecnologias Utilizadas
- [Vs Code](https://code.visualstudio.com/)
- [Java](https://www.java.com/pt_BR/)

## 📕 Descrição
Simula diversas arquiteturas de cache seguindo os parâmetros abaixo:
- Tamanho da cache: 1024, 2048, 4096, 8192, 16384 bytes
- Tamanho do bloco: 16 bytes;
- Mapeamentos: direto, 2-way, 4-way e 8-way;
- Política de substituição: LRU, FIFO

<p align = "justify">A cache contabiliza o número de acertos e erros para cada configuração de cache. A entrada do programa é um arquivo contendo uma sequência de endereços. Para cada endereço, é  simulado uma leitura real na cache. Portanto, dado um endereço é verificado se o mesmo está contido na cache. Caso não esteja, o contador de erros deve ser incrementado e a cache atualizada usando a política de substituição.</p>

## 🚀 Execução
```
# Clone o repositório
git clone https://github.com/Josuebmota/CacheMemorySimulator.git

# Vá para o diretório do arquivo
cd CacheMemorySimulator
```
No arquivo [principal](https://github.com/Josuebmota/CacheMemorySimulator/blob/master/teste.java), informe o diretorio do arquivo [hexadecimal](https://github.com/Josuebmota/CacheMemorySimulator/blob/master/sequ%C3%AAncia%20de%20endere%C3%A7os.txt) e os parâmetros de acordo, com o tamanho da cache e as politicas de substituição.

## 🥏Resultados
Após os testes foram gerados os seguintes resultados apresentados na tabela abaixo:
<p align="center">
  <img src="https://user-images.githubusercontent.com/34459397/60374013-c0508980-99d8-11e9-8567-368a23b033e1.png">
</p>

## 🐛 Problemas
Sinta-se a vontade de registrar um novo problema, com um respectivo título e descrição no repositório do [CacheMemorySimulator](https://github.com/Josuebmota/CacheMemorySimulator/issues). Se encontrar a solução, avaliarei seu Pull Request.

## 👨‍💻 [](<[https://github.com/Josuebmota/CacheMemorySimulator](https://github.com/Josuebmota/CacheMemorySimulator)#autor>)Autor

Criado por [**Josué Batista Mota** ](https://github.com/Josuebmota), <br>esse projeto está sobre [MIT license](./LICENSE) 📃.

Coloque uma ⭐️ caso esse proejto tenha lhe ajudado
