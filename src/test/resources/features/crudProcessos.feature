#language: pt

  Funcionalidade: CRUD - Cadastro de processos

    Contexto:
      Dado que o usuário esteja na página inicial
        E que o usuário clique no menu processo
        E que o usuário clique no botão novo processo
        E o usuário preencha o campo "processo_vara" com o valor "teste"
        E o usuário preencha o campo "processo_numero_processo" com o valor "2345678"
        E o usuário preencha o campo "processo_natureza" com o valor "Civil"
        E o usuário preencha o campo "processo_partes" com o valor "Nenhuma"
        E o usuário selecione o campo "processo_urgente" com o valor "Sim"
        E o usuário clique no campo "processo_arbitramento_n"
        E o usuário preencha o campo "processo_assistente_social" com o valor "Mãe"
        E o usuário preencha o campo "processo_data_entrada" com o valor "2020-01-01"
        E o usuário preencha o campo "processo_data_saida" com o valor "2020-12-31"
        E o usuário preencha o campo "processo_data_agendamento" com o valor "2020-06-01"
        E o usuário preencha o campo "processo_status" com o valor "Indefinido"
        E o usuário preencha o campo "processo_observacao" com o valor "Teste adicionar processo novo"

    Cenario: Cadastro de novo processo
      Quando o usuário pressionar o botão salvar
      Entao O usuário deve ver a mensagem "Processo foi criado com sucesso."

    Cenario: Editar processo
        E o usuário pressionar o botão salvar
        E o usuário pressiona o botão voltar
        E o usuário pressiona o botão para editar o novo processo
        E o usuário preencha o campo "processo_vara" com o valor "teste edição"
      Quando o usuário pressionar o botão salvar
      Entao o usuário deveria ver o campo "vara" com o valor "teste edição"

    @ignore
    Cenario: Editar processo campo radio
      E o usuário pressionar o botão salvar
      E o usuário pressiona o botão voltar
      E o usuário pressiona o botão para editar o novo processo
      E o usuário clique no campo "processo_arbitramento_s"
      Quando o usuário pressionar o botão salvar
      Entao o usuário deveria ver o campo "arbitramento" com o valor "S"

    Cenario: Mostrar processo
        E o usuário pressionar o botão salvar
        E o usuário pressiona o botão voltar
      Quando o usuário pressiona o botão para mostrar o novo processo
      Entao o usuário deveria ver o campo "vara" com o valor "teste"
        E o usuário deveria ver o campo "numero" com o valor "2345678"
        E o usuário deveria ver o campo "natureza" com o valor "Civil"
        E o usuário deveria ver o campo "partes" com o valor "Nenhuma"
        E o usuário deveria ver o campo "urgente" com o valor "S"
        E o usuário deveria ver o campo "arbitramento" com o valor "N"
        E o usuário deveria ver o campo "as_social" com o valor "Mãe"
        E o usuário deveria ver o campo "dt_entrada" com o valor "2020-01-01"
        E o usuário deveria ver o campo "dt_saida" com o valor "2020-12-31"
        E o usuário deveria ver o campo "dt_agendamento" com o valor "2020-06-01"
        E o usuário deveria ver o campo "status" com o valor "Indefinido"
        E o usuário deveria ver o campo "observacao" com o valor "Teste adicionar processo novo"

    Cenario: Deletar processo
      E o usuário pressionar o botão salvar
      E o usuário pressiona o botão voltar
      E o usuário pressiona o botão para apagar o novo processo
      Quando o usuário confirma que quer apagar o processo
      Entao o usuário não deveria mais ver o novo processo na lista

    Esquema do Cenario: Cadastro de novo processo com Schema Outline
          E o usuário pressionar o botão salvar
          E o usuário pressiona o botão voltar
          E o usuário pressiona o botão para editar o novo processo
          E o usuário preencha o campo "<campo>", do tipo "<tipo>", com o valor "<valor>"
        Quando o usuário pressionar o botão salvar
        Entao o usuário deveria ver o campo "<campo_visualizar>" com o valor "<valor_final>"

    Exemplos:
      | campo                 | valor   | tipo   | campo_visualizar | valor_final |
      | processo_vara         | outline | text   | vara             | outline     |
      |                       | N       | radio  | arbitramento     | N           |
      |                       | S       | radio  | arbitramento     | S           |
      | processo_urgente      | Sim     | select | urgente          | S           |
      | processo_urgente      | Não     | select | urgente          | N           |
