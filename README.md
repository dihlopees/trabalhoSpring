# trabalho Java com Spring Boot
Trabalho máteria Tópicos especiais em programação

Aluna: Ingrid Lopes R.A: 22.6980-1

# JSON de exemplos para utilizar na API:

# Crie um curso: 

```
{
    "name": "criando curso"
}
```

# Crie uma matéria:

```
{
    "name": "criando materia",
    "course": {
        "idCourse": 1
    }
}
```

# Crie um Aluno:
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
# Vincule uma nota ao Aluno:
```
{
    "idStudent": 1,
    "grade": 7.5,
    "subject": {
        "idSubject": 1
    }
}
```
# No método get /grades veja todas as notas cadastradas para todos os alunos.
# Para ver o boletim do Aluno, ou seja, todas as notas cadastradas para ele, utilize a rota /grades/{id_student}

