# API Java com Spring Boot - Boletim Escolar
Trabalho submetido para máteria de tópicos especiais em programação.

Aluna: Ingrid Lopes R.A: 22.6980-1

# JSON de exemplos para utilizar na API:

Serviço irá rodar na porta 8082.

# Crie um curso em POST /course: 

```
{
    "name": "criando curso"
}
```

# Crie uma matéria em POST /subject:

```
{
    "name": "criando materia",
    "course": {
        "idCourse": 1
    }
}
```

# Crie um Aluno em POST /student:
```
{
    "name": "Aluno 1",
    "cpf": "11111111",
    "lastName": "sobrenome",
    "studentCourses": [{
       "pk": {
           "course": {
               "idCourse": 1
           }
       }
    }, 
   ]
}
```
# Vincule uma nota ao Aluno em POST /grades:
```
{
    "idStudent": 1,
    "grade": 7.5,
    "subject": {
        "idSubject": 1
    }
}
```
# No método GET /grades veja todas as notas cadastradas para todos os alunos.
# Para ver o boletim do Aluno, ou seja, todas as notas cadastradas para ele, utilize a rota GET /grades/{id_student}

