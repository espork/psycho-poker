psycho-poker
============

Cada jogador recebe 5 cartas e pode vê-las. O jogador pode então descartar entre 0 e 5 das suas cartas e trocá-las pelo mesmo número de cartas a partir do topo do monte. O objetivo é maximizar o valor final da mão do jogador.

As cartas do monte estão viradas para baixo, e normalmente não é possível saber a ordem das cartas. Vamos imaginar que o nosso jogador é um paranormal e que ele consiga saber as próximas 5 cartas do monte. Faça um código que ajude o jogador a descartar e trocar as cartas de forma a maximizar sua mão.

## Entradas e saídas

A entrada será uma série de linhas, cada linha contendo as 5 cartas na mão do jogador e depois as 5 cartas do topo do monte. Cada carta será representada por 2 caracteres: o primeiro é o valor da carta (A=ás, 2-9, T=10, J=Valete, Q=Dama, K=Rei) e o segundo valor é o naipe (C=Paus, D=Ouro, S=Espada, H=Copas). As cartas serão separadas por espaço e cada linha será de um único baralho válido. Logo, não haverá cartas duplicadas entre a mão e o monte.

Cada linha de entrada deve produzir uma linha de saída com a mão inicial, as 5 cartas do monte e a melhor mão possível.

A ordem das cartas na mão do jogador é irrelevante mas a ordem das cartas no monte são importantes, pois cada carta só pode ser trocada com carta no topo do monte.

## Exemplos de entrada
 
TH JH QC QD QS QH KH AH 2S 6S  
2H 2S 3H 3S 3C 2D 3D 6C 9C TH  
2H 2S 3H 3S 3C 2D 9C 3D 6C TH  
2H AD 5H AC 7H AH 6H 9H 4H 3C  
AC 2D 9C 3S KD 5S 4D KS AS 4C  
KS AH 2H 3C 4H KC 2C TC 2D AS  
AH 2C 9S AD 3C QH KS JS JD KD  
6C 9C 8C 2D 7C 2H TC 4C 9S AH  
3D 5S 2H QD TD 6S KH 9H AD QH  

## Exemplos de saída

Mão: TH JH QC QD QS Monte: QH KH AH 2S 6S Melhor Jogo: straight-flush (sequência numérica e de naipe)  
Mão: 2H 2S 3H 3S 3C Monte: 2D 3D 6C 9C TH Melhor Jogo: four-of-a-kind (quadra)  
Mão: 2H 2S 3H 3S 3C Monte: 2D 9C 3D 6C TH Melhor Jogo: full-house (trinca + par)  
Mão: 2H AD 5H AC 7H Monte: AH 6H 9H 4H 3C Melhor Jogo: flush (sequência de naipe)  
Mão: AC 2D 9C 3S KD Monte: 5S 4D KS AS 4C Melhor Jogo: straight (sequência numérica)  
Mão: KS AH 2H 3C 4H Monte: KC 2C TC 2D AS Melhor Jogo: three-of-a-kind (trinca)  
Mão: AH 2C 9S AD 3C Monte: QH KS JS JD KD Melhor Jogo: two-pairs (2 pares)  
Mão: 6C 9C 8C 2D 7C Monte: 2H TC 4C 9S AH Melhor Jogo: one-pair (1 par)  
Mão: 3D 5S 2H QD TD Monte: 6S KH 9H AD QH Melhor Jogo: highest-card (maior carta)  
