Projeto Interdisciplinar 2
==========================

Projeto: aplicacao-corporativa

- Modifica��o dos arquivos de configura��o de Autoria

Para alterar a autoria:

Editar <i>[project]/.git/config</i> e adicionar:

    [user]
    name = <nome>
    email = <e-mail>

Se poss�vel, adicionar na op��o [branch "<i>branch</i>"]

    mergeoptions = --no-ff


- Altera��o do Idioma do NetBeans

Para alterar o idioma do NetBeans, existe duas formas:

1. Atalho do Windows

Coloque <i>--locale en</i> ou <i>--locale pt_br</i> no final do Destino, nas op��es do atalho. Por exemplo:

    "C:\Program Files\NetBeans 7.2.1\bin\netbeans64.exe" --locale en

2. Arquivo de configura��o

Modifique a op��o <i>netbeans_default_options</i> no arquivo de configura��o <i>[instala��o]/etc/netbeans.conf</i>. Por exemplo:

    netbeans_default_options="-J-client -J-Xss2m -J-Xms32m -J-XX:PermSize=32m -J-Dapple.laf.useScreenMenuBar=true -J-Dapple.awt.graphics.UseQuartz=true -J-Dsun.java2d.noddraw=true -J-Dsun.zip.disableMemoryMapping=true"

para

    netbeans_default_options="--locale en -J-client -J-Xss2m -J-Xms32m -J-XX:PermSize=32m -J-Dapple.laf.useScreenMenuBar=true -J-Dapple.awt.graphics.UseQuartz=true -J-Dsun.java2d.noddraw=true -J-Dsun.zip.disableMemoryMapping=true"


- Site do Projeto no servidor de Integra��o Cont�nua

    https://travis-ci.org/Prof-Calebe/aplicacao-corporativa

