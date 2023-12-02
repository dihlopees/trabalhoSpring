# trabalho Java com Spring Boot
Trabalho máteria Tópicos especiais em programação

Aluna: Ingrid Lopes R.A: 22.6980-1

# Exemplos de como utilizar a API:

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


